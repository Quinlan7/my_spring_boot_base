package com.feibei.springbootbase.controller;/**
 * @author zhf
 * @date 2023/4/29 21:53
 * @version 1.0
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhf
 * 项目：springbootbase
 * 描述：index
 * @date 2023/4/29 21:53
 **/
@RestController
@RequestMapping("/portal")
public class PortalController {

    @RequestMapping("/info")
    public String portal() {
        System.out.println("portal website");
        return "portal website";
    }
}
