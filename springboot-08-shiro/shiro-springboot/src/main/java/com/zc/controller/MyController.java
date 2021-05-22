package com.zc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/")
    public String toIndex(Model model) {
        model.addAttribute("msg","hello,shiro");
        return "index";
    }

    @GetMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @GetMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {

        //  获取当前的用户
        Subject subject = SecurityUtils.getSubject();

        //  封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //  执行登录的方法，如果没有异常证明ok
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException exception) {   // 用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException exception) { // 密码不存在
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @GetMapping("noauth")
    @ResponseBody
    public String unauthorized() {
        return "未经过授权无法访问此页面";
    }
}
