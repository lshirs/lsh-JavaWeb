package com.lsh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsh.entity.SysRole;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jzhang
 * @since 2020-05-27
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    //查询角色关联查询角色菜单
    SysRole findRoleAndMenu(Integer id);

    //根据id删除所有角色菜单
    void deleteRoleMenus(SysRole sysRole);

    //批量插入角色菜单
    void insertRoleMenus(SysRole sysRole);
}
