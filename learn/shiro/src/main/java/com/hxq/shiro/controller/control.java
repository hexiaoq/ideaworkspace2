package com.hxq.shiro.controller;

import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class control {
    @RequestMapping("/index")
    public String login() {
        return "select";

    }

    @RequestMapping("/update")
    public String update() {
        return "update";
    }

    @RequestMapping("/down")
    public String down() {
        return "download";
    }
    @RequestMapping("/tologin")
    public String tologin()
    {
        return "login";
    }
    @RequestMapping("/login")
    public String login(String name, String password, Model model)
    {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken Token = new UsernamePasswordToken(name,password);

        try {
            subject.login(Token);
            return "select";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","账户名错误");
              return "login";
        } catch (IncorrectCredentialsException e)
        {
            model.addAttribute("msg","密码错误");
            return "login";

        }


    }
    @RequestMapping(("/tonoau"))
    @ResponseBody
    public String tonoau()
    {
        return "未经授权,不得访问";

    }

}
