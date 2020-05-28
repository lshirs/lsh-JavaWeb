package com.lsh.web;

import com.lsh.entity.SysMenu;
import com.lsh.service.ISysMenuService;
import com.lsh.service.ISysRoleService;
import com.lsh.service.ISysUserService;
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
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;


    @RequestMapping("index")
    public String index(Model model){
        // 读取登录用户的角色,并加载菜单
        // 获取spring security用户

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        //读取用户管理菜单
        List<SysMenu> menuList = sysMenuService.findListByName(userDetails.getUsername());
        /*menuList.forEach(System.out::println);*/
        model.addAttribute("menus",menuList);
        return "index";
    }
    /**
     * 读取控制台
     */
    @RequestMapping("/console")
    public String console(Model model){

        //用户数
        Integer userCount = sysUserService.count();

        //角色数
        Integer roleCount = sysRoleService.count();

        //菜单数
        Integer menuCount = sysMenuService.count();

        model.addAttribute("userCount",userCount);
        model.addAttribute("roleCount",roleCount);
        model.addAttribute("menuCount",menuCount);
        return "console";
    }
}
