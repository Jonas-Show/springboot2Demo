//package com.udian.conf.db;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//public class DruidDataSourceConfiguration {
//	@Value("${spring.datasource.maxActive}")
//	private int maxActive;
//
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//    	DruidDataSource druidDataSource =  new DruidDataSource();
//    	druidDataSource.setMaxActive(maxActive);
//    	return druidDataSource;
//    }
//
//	@Bean
//	public ServletRegistrationBean druidServlet() {
//		ServletRegistrationBean reg = new ServletRegistrationBean();
//		reg.setServlet(new StatViewServlet());
//		reg.addUrlMappings("/druid/*");
//		reg.addInitParameter("loginUsername", "druid");
//		reg.addInitParameter("loginPassword", "jiajian123456");
//		return reg;
//	}
//
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new WebStatFilter());
//		filterRegistrationBean.addUrlPatterns("/*");
//		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//		filterRegistrationBean.addInitParameter("profileEnable", "true");
//		filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
//		filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
//		return filterRegistrationBean;
//	}
//
//
//}
