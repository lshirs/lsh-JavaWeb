package com.lsh.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/a/user")
public class SysUserController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
