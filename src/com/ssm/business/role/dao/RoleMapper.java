package com.ssm.business.role.dao;

import java.util.List;
import java.util.Map;

import com.ssm.business.role.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    int getRolePageListCount(Map<String, Object> map);
    
    List<Role> findRolePageList(Map<String, Object> map);
    
}