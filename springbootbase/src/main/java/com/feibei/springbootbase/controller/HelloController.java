package com.feibei.springbootbase.controller;/**
 * @author zhf
 * @date 2023/4/29 10:57
 * @version 1.0
 */

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
        return "hello spring security!";
    }
}

