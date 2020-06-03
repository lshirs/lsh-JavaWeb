package com.lsh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.entity.SysUser;
import com.lsh.mapper.SysUserMapper;
import com.lsh.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsh
 * @since 2020-05-27
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void saveSysUser(SysUser sysUser) {
        if (sysUser.getId() != null) {
            sysUserMapper.updateById(sysUser);
        } else {
            //新增用户设置默认密码123456
            String pwd = new BCryptPasswordEncoder().encode("123456");
            sysUser.setPassword(pwd);
            sysUser.setStatus(1);//用户状态
            Integer index = sysUserMapper.insert(sysUser);
        }
        //更新角色
        updateSysUserRoles(sysUser);
    }

    /**
     * 更新用户角色
     */
    private void updateSysUserRoles(SysUser sysUser) {
        if (sysUser != null && sysUser. getRoles() != null) {
            //删除原有角色
            sysUserMapper.deleteRoles(sysUser);
            //更新角色
            sysUserMapper.insertRoles(sysUser);
        }
    }

    @Override
    public SysUser findUserById(Integer userId) {
        return sysUserMapper.findUserById(userId);
    }
}
