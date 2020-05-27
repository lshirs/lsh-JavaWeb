package com.lsh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author jzhang
 * @since 2020-05-27
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 根据用户名获取菜单
     */
    List<SysMenu> findListByName(String username);
}
