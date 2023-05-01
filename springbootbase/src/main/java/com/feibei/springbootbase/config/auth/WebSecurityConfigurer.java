package com.feibei.springbootbase.config.auth;/**
 * @author zhf
 * @date 2023/4/29 22:05
 * @version 1.0
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 **/

/**
 * @author zhf
 * 项目：springbootbase
 * 描述：Spring Security Configure
 * @date 2023/4/29 22:05
 **/

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/portal/*").permitAll()//放行资源写在任何前面
                .mvcMatchers("/login.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html") //用来指定默认登录页面 注意: 一旦自定义登录页面以后必须指定登录url
                .loginProcessingUrl("/doLogin") //指定处理登录请求 url
                .usernameParameter("uname")
                .passwordParameter("passwd")
                //.successForwardUrl("/index") //认证成功 forward 跳转路径  始终在认证成功之后跳转到指定请求
                //.defaultSuccessUrl("/index", true) //认证成功 redirect 之后跳转   根据上一保存请求进行成功跳转
                .successHandler(new SecurityAuthenticationSuccessHandler()) //认证成功时处理 前后端分离解决方案
                //.failureForwardUrl("/login.html") //认证失败之后 forward 跳转
                //.failureUrl("/login.html") // 默认 认证失败之后 redirect 跳转
                .failureHandler(new SecurityAuthenticationFailureHandler()) //用来自定义认证失败之后处理  前后端分离解决方案
                .and()
                .logout()
                //.logoutUrl("/logout")  //指定注销登录 url 默认请求方式必须: GET
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/aa", "GET"),
                        new AntPathRequestMatcher("/bb", "POST")
                ))
                .invalidateHttpSession(true) //默认(可以不用显式配置) 会话失效
                .clearAuthentication(true)   //默认 清楚认证标记
                //.logoutSuccessUrl("/login.html") //注销登录 成功之后跳转页面
                .logoutSuccessHandler(new SecurityLogoutSuccessHandler())  //注销登录成功之后处理
                .and()
                .csrf().disable();
    }
}
