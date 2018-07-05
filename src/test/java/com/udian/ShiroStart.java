package com.udian;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by Administrator on 2018/5/25.
 */
public class ShiroStart {
    @Test
    public void test01(){
        SecurityUtils.setSecurityManager(new DefaultSecurityManager());
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("hello", "world!");

        if ( !currentUser.isAuthenticated() ) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            //(do you know what movie this is from? ;)
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);
            currentUser.login(token);
        }
    }

    @Test
    public void shiroBasicTest(){

    }
}
