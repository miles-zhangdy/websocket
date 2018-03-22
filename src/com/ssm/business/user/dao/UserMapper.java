package com.ssm.business.user.dao;

import java.util.Map;

import com.ssm.business.user.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User userLogin(Map<String, Object> map);
}