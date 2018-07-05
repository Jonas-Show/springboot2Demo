package com.udian.conf.shiro;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1.配置securityManager核心
 * 2.配置shiroFilter
 * 3.配置realm
 * 4.可选配置cacheManager、sessionManager(SessionDAO)、Authenticator(AuthenticationStrategy)、Authorizer等securityManager组件
 * 5.添加自定义Filter实现验证码、权限等处理
 */
@Configuration
public class ShiroConfig {

    /**
     * 可自定义realm的密码匹配规则，如Md5CredentialsMatcher
     * @return
     */
    @Bean
    public CredentialsMatcher getCredentialsMatcher(){
        return new SimpleCredentialsMatcher();
    }

    /**
     * 配置realm数据源，或继承AuthorizingRealm实现相关自定义功能
     * @return
     */
    @Bean
    public Realm getRealm(DataSource dataSource, CredentialsMatcher credentialsMatcher){
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);

        // 设置密码匹配规则
        jdbcRealm.setCredentialsMatcher(credentialsMatcher);
        return jdbcRealm;
    }

    /**
     * 可自定义CacheManger,使用EHCache、redis、memache等
     * @return
     */
    @Bean
    public CacheManager getCacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    /**
     * 自定义sessionDao可以继承EnterpriseCacheSessionDAO，实现session存储到其他地方如redis、db等。
     * @return
     */
    @Bean
    public SessionDAO getSessionDao(CacheManager cacheManager){
        EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
        enterpriseCacheSessionDAO.setCacheManager(cacheManager);
        return enterpriseCacheSessionDAO;
    }


    /**
     * 配置SessionManager
     * @return
     */
    @Bean("sessionManager")
    public SessionManager getSessionManager(SessionDAO sessionDAO){
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();

        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        defaultWebSessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);

        // 使用自定义SeesionDAO实现。
        defaultWebSessionManager.setSessionDAO(sessionDAO);
        return defaultWebSessionManager;
    }



    @Bean(name="securityManager")
    public SecurityManager getSecurityManager(Realm jdbcRealm, SessionManager sessionManager, CacheManager cacheManager){
        DefaultWebSecurityManager dwm=new DefaultWebSecurityManager();
        dwm.setRealm(jdbcRealm);
        dwm.setCacheManager(cacheManager);
        dwm.setSessionManager(sessionManager);
        return dwm;
    }

    /**
     * 自定义Filter
     * @return
     */
    @Bean
    public PermissionFilter getPermissionFilter(){
        return new PermissionFilter();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean sfb = new ShiroFilterFactoryBean();
        sfb.setSecurityManager(securityManager);
        sfb.setLoginUrl("/login");
        sfb.setUnauthorizedUrl("/goLogin");

        Map<String, Filter> filters = new HashMap<>();
        // 添加字段Filter
        filters.put("per", getPermissionFilter());
        sfb.setFilters(filters);

        /**
         * 所有默认Filter位置 {@link DefaultFilter}
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 开发swagger相关访问页面
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");

        filterMap.put("/login", "anon");
        filterMap.put("/getCode", "anon");
        filterMap.put("/logout", "logout");
        filterMap.put("/plugin/**", "anon");
        filterMap.put("/user/**", "per");
        filterMap.put("/**", "authc");
        sfb.setFilterChainDefinitionMap(filterMap);
        return sfb;
    }



    /**
     * 添加如下三个bean使能Spring AOP扫描shiro注解
     * @RequiresPermissions.class, @RequiresRoles.class,
     * @RequiresUser.class, @RequiresGuest.class, @RequiresAuthentication.class等。
     *
     */

    /**
     * 对实现Initializable接口的bean对象调用init().
     * @return
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    // end
}
