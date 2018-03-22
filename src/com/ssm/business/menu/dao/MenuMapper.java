package com.ssm.business.menu.dao;

import java.util.List;
import java.util.Map;

import com.ssm.business.menu.model.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> findMenuPageList(Map<String, Object> map);
    
    int getMenuPageListCount(Map<String, Object> map);
    
    List<Menu> findMenuList(Map<String, Object> map);
    
    Menu getMenuByParentIdFirst(String parentId);
    
}