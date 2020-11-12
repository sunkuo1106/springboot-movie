package com.kgc.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author shkstart
 * @create 2020-09-15 11:00
 */
@Controller
public class LoginController {
    @RequestMapping("/")
    public String tologin(){
        return "/index";
    }


    @RequestMapping("/login")
    public String login(){
        return "/login";
    }
}
