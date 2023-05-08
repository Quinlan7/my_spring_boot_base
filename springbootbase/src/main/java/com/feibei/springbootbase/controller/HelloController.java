package com.feibei.springbootbase.controller;/**
 * @author zhf
 * @date 2023/4/29 10:57
 * @version 1.0
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhf
 * 项目：springbootbase
 * 描述：hello
 * @date 2023/4/29 10:57
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello spring security!");
        //1 获取认证完的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println("authentication = " + authentication);
        System.out.println("名字信息：" + authentication.getName());
        System.out.println("身份信息：" + user.getAuthorities());
        new Thread(() -> {
            Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("子线程获取: " + authentication1);
        }).start();
        return "hello spring security!";
    }
}

