package com.ssm.business.dictionary.dao;

import com.ssm.business.dictionary.model.DicValue;

public interface DicValueMapper {
    int deleteByPrimaryKey(Long dicValueId);

    int insert(DicValue record);

    int insertSelective(DicValue record);

    DicValue selectByPrimaryKey(Long dicValueId);

    int updateByPrimaryKeySelective(DicValue record);

    int updateByPrimaryKey(DicValue record);
}