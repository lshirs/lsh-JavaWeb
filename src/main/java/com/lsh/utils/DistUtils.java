package com.lsh.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsh.entity.SysDict;
import com.lsh.service.ISysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 字典值
 * 工具类
 */
@Component
public class DistUtils {

    @Autowired
    private ISysDictService service;
    private static  ISysDictService sysDictService;
    @PostConstruct  // 对servise的注入
    public void init(){
        sysDictService = service;
    }

    /**
     *
     * @param type
     * @param value
     * @return
     * 根据type和labe获取对应的中文
     */
    public String getDictLabel(String type, Integer value){
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_code",type);
        queryWrapper.eq("value",value);
         SysDict sysDict = sysDictService.getOne(queryWrapper);
         return sysDict.getLabel();
    }

}
