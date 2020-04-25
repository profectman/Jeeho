package com.jeeho.module.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = {"/","/login"})
    public String login(HttpServletRequest request, HttpServletResponse response){
        //1.数据校验

        //2.判断用户名是否存在

        //3.密码加密 判断密码是否正确

        //错误信息以json的形式进行返回，。。。。
        return "";
    }
}
