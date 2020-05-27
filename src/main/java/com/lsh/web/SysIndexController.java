package com.lsh.web;

import com.lsh.entity.SysMenu;
import com.lsh.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/a")
public class SysIndexController {
    @Autowired
    private ISysMenuService sysMenuService;


    @RequestMapping("index")
    public String index(Model model){
        // 读取登录用户的角色,并加载菜单
        // 获取spring security用户

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        //读取用户管理菜单
        List<SysMenu> menuList = sysMenuService.findListByName(userDetails.getUsername());
        menuList.forEach(System.out::println);
        model.addAttribute("menuList",menuList);
        return "index";
    }
}
