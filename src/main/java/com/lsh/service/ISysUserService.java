package com.lsh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.entity.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsh
 * @since 2020-05-27
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 保存用户
     */
    void saveSysUser(SysUser sysUser);

    /**
     * 根据id查询用户关联查询角色
     * @param userId
     * @return
     */
    SysUser findUserById(Integer userId);
}
