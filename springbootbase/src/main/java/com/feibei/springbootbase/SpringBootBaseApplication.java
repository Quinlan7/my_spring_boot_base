package com.feibei.springbootbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBaseApplication.class, args);
        System.out.println("==========服务已启动！==========");
    }

}
