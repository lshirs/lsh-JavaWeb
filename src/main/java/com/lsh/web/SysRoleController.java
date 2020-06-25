package com.lsh.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.entity.SysRole;
import com.lsh.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/a/role")
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;

    @ModelAttribute("role")
    public SysRole get(Integer id) {
        if (id != null) {
            return sysRoleService.getById(id);
        } else {
            return new SysRole();
        }
    }

    @RequestMapping("/list")
    public String list(Model model, Integer page, Integer size) {
        int currentPage = 1;
        int pageSize = 5;
        if (page != null) {
            currentPage = page;
        }
        if (size != null) {
            pageSize = size;
        }
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        IPage<SysRole> pageList = sysRoleService.page(new Page<>(currentPage,pageSize), queryWrapper);
        model.addAttribute("roles", pageList.getRecords());
        model.addAttribute("count", pageList.getTotal());
        model.addAttribute("curr", pageList.getCurrent());
        return "sys/roleList";
    }

    @RequestMapping("/form")
    public String form(Model model, SysRole role) {
        if (role != null && role.getId() != null) {
            role = sysRoleService.getById(role.getId());
        }
        model.addAttribute("sysRole", role);
        return "sys/roleForm";
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save(SysRole sysRole, int[] roleMenus) {
        sysRoleService.saveRole(sysRole, roleMenus);
        return "success";
    }

    /**
     * 获取角色授权菜单树
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoleMenuTree")
    public List<Map<String, Object>> getRoleMenuTree(SysRole role) {
        List<Map<String, Object>> list = sysRoleService.getRoleMenuTree(role);
        return list;
    }
}
