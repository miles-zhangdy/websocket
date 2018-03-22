package com.ssm.business.menu.dao;

import java.util.List;
import java.util.Map;

import com.ssm.business.menu.model.Menuinfo;

public interface MenuinfoMapper {
    int deleteByPrimaryKey(Long minfoId);

    int insert(Menuinfo record);

    int insertSelective(Menuinfo record);

    Menuinfo selectByPrimaryKey(Long minfoId);

    int updateByPrimaryKeySelective(Menuinfo record);

    int updateByPrimaryKey(Menuinfo record);
    
    List<Menuinfo> findMenuinfoList(Map<String, Object> map);
    
    List<Menuinfo> findMenuList(Map<String, Object> map);
    
    Menuinfo getMenuByParentIdFirst(Map<String, Object> map);
    
    int insertRoleMenuinfo(Map<String, Object> map);
}