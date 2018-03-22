package com.ssm.business.dictionary.dao;

import java.util.List;
import java.util.Map;

import com.ssm.business.dictionary.model.Dictionary;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Long dictionaryId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long dictionaryId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    
    List<Dictionary> findDictionaryPageList(Map<String, Object> map);
    
    int findDictionaryPageListCount(Map<String, Object> map);
}