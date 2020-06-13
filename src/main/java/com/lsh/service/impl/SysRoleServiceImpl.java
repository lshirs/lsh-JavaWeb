package com.lsh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.entity.SysRole;
import com.lsh.mapper.SysRoleMapper;
import com.lsh.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jzhang
 * @since 2020-05-27
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public void saveRole(SysRole sysRole, int[] roleMenus) {

    }

    @Override
    public List<Map<String, Object>> getRoleMenuTree(SysRole role) {
        return null;
    }
}
