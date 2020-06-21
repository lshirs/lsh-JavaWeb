package com.lsh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.entity.SysMenu;
import com.lsh.vo.ResponseResult;

import java.util.List;
import java.util.Map;

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
     * 根据用户名获取对应菜单
     */
    List<SysMenu> findListByName(String username);

    /**
     * 以树状形式获取菜单
     * @return
     */
    List<Map<String, Object>> queryMenuTree();

    /**
     *
     * @param menuId
     * @return
     */
    SysMenu queryMenuById(Integer menuId);

    /**
     *
     * @param menuId
     * @return
     */
    SysMenu queryParentMenuById(Integer menuId);

    /**
     * 保存菜单
     * @param sysMenu
     */
    void saveMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    ResponseResult deleteMenu(Integer menuId);
}
