package com.lsh.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.entity.SysRole;
import com.lsh.entity.SysUser;
import com.lsh.service.ISysRoleService;
import com.lsh.service.ISysUserService;
import com.lsh.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/a/user")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;

    @RequestMapping("/login")
    public String login(){
        return "sys/login";
    }

    @RequestMapping("/logout")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {

            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/a/user/login";
    }
        //加载用户数据
    @RequestMapping("list")
    public String list(Integer curr,Integer size,SysUser sysUser,Model model){
        //分页,用户数据
        Integer cuurent = 1;
        Integer pageList = 4;
        //判断前台数据
        if (curr != null) cuurent = curr;
        if (size != null) pageList = size;
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // 绑定查询条件 要判断空字符
        if (sysUser != null && sysUser.getUsername() != null && sysUser.getUsername() != ""){
            queryWrapper.eq("username",sysUser.getUsername());
        }
        if (sysUser != null && sysUser.getEmail() != null && sysUser.getEmail() != ""){
            queryWrapper.eq("email",sysUser.getEmail());
        }

        IPage<SysUser> page = sysUserService.page(new Page<>(cuurent,pageList),queryWrapper);

        //列表
        model.addAttribute("userList",page.getRecords());
        model.addAttribute("total",page.getTotal());
        model.addAttribute("current",page.getCurrent());
        return "sys/userList";
    }
    /**
     * 编辑
     */
    @RequestMapping("/form")
    public String form(Model model, Integer id, SysUser sysUser) {
        //获取所有的角色
        List<SysRole> roleList = sysRoleService.list();
        if (id != null) {
            sysUser = sysUserService.findUserById(id);
        }
        model.addAttribute("roleList", roleList);
        System.out.println(sysUser);
        model.addAttribute("sysUser", sysUser);
        return "sys/userForm";
    }

    @RequestMapping("/save")
    public String save(SysUser sysUser) {
        sysUserService.saveSysUser(sysUser);
        return "redirect:list";
    }
    /**
     * 修改密码
     */
    @RequestMapping("/modify")
    public String modify(Model model) {
        // 获取spring security用户
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDetails.getUsername());
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        //将用户保存到model
        model.addAttribute("sysUser",sysUser);
        return "sys/modifyUserPwd";
    }
    /**
     * 保存密码
     */
    @ResponseBody
    @RequestMapping("/modifySubmit")
    public String modifySubmit(SysUser sysUser){
        //sysUserService 有就改没有新增
        //密码加密
        String pwd = new BCryptPasswordEncoder().encode(sysUser.getPassword());
        sysUser.setPassword(pwd);
        sysUserService.saveOrUpdate(sysUser);

        return "success";
    }

    /**
     * 修改用户状态
     */
    @ResponseBody
    @RequestMapping("/changeStatus")
    public ResponseResult changStatus(SysUser sysUser){
        sysUserService.updateById(sysUser);
        ResponseResult result = null;
        if (sysUser.getStatus() == 2){
            result = new ResponseResult("200","账户已冻结");
        }else{
            result = new ResponseResult("200","账户已解锁");
        }

        return result;
    }

}
