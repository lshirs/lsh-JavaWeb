package com.lsh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsh.entity.SysUser;
import org.springframework.stereotype.Component;

@Component

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findUserByName(String username);
    SysUser findUserById(Integer id);
    void insertRoles(SysUser sysUser);
    void deleteRoles(SysUser sysUser);
}
