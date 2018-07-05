//package com.udian.controller;
//
//import com.baomidou.kisso.SSOHelper;
//import com.baomidou.kisso.security.token.SSOToken;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by Administrator on 2018/5/21.
// */
//@RestController
//public class LoginController {
//
//    @ApiOperation(value = "kisso demo", notes = "kiss note", response = String.class,code = 200)
//    @GetMapping("/kisso")
//    public String home(@ApiParam(value = "param",type = "String", required = true) String param) {
//        return "Hello Kisso!";
//    }
//
//
//
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, HttpServletResponse response) {
//        //TODO: 验证用户信息
//        // 设置登录 COOKIE
//        SSOHelper.setCookie(request, response, SSOToken.create().setIp(request).setId(1000).setIssuer("kisso"), false);
//        return "login success!";
//    }
//
//    /**
//     * 查看登录信息
//      */
//    @ResponseBody
//    @RequestMapping("/token")
//    public String token(HttpServletRequest request) {
//        String msg = "暂未登录";
//        SSOToken ssoToken = SSOHelper.attrToken(request);
//        if (null != ssoToken) {
//            msg = "登录信息 ip=" + ssoToken.getIp();
//            msg += "， id=" + ssoToken.getId();
//            msg += "， issuer=" + ssoToken.getIssuer();
//        }
//        return msg;
//    }
//
//    /**
//     * 退出登录
//      */
//    @ResponseBody
//    @RequestMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        SSOHelper.clearLogin(request, response);
//        return "Logout Kisso!";
//    }
//
//
//}
