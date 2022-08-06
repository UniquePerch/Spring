package com.example.controller;

import com.example.service.SimpleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Controller
public class PageController {
    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/admin")
    public String admin(){return "index";}

    @PreAuthorize("hasAnyRole('user','admin')")//注解形式的权限设置
    @RequestMapping("/index")
    public String index(){
        SecurityContext context = SecurityContextHolder.getContext();//获取当前用户信息
        Authentication authentication = context.getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        System.out.println(user.getAuthorities());
        return "index";
    }

    @RequestMapping("/login")
    public String login(){return "login";}
}
