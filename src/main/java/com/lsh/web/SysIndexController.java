package com.lsh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class SysIndexController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
