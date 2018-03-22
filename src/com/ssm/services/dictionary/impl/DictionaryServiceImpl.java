package com.ssm.services.dictionary.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.business.dictionary.dao.DictionaryMapper;
import com.ssm.business.dictionary.model.Dictionary;
import com.ssm.business.dictionary.vo.DictionaryQueryVO;
import com.ssm.business.dictionary.vo.DictionaryVO;
import com.ssm.business.dictionary.vo.DictionaryViewVO;
import com.ssm.common.model.Page;
import com.ssm.common.util.BeanUtils;
import com.ssm.services.dictionary.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService{

	@Resource
	private DictionaryMapper dictionaryMapper;
	
//    @Resource
//    private SpringRedisClientImpl redisClientImpl ;
	
	@Override
	public int insertDictionary(DictionaryVO dictionaryVO) {
		
		if(dictionaryVO == null){
			new Exception("存储对象不能为空");
		}
		int count = dictionaryMapper.insert(BeanUtils.copyBeanToBean(dictionaryVO, Dictionary.class));
//		redisClientImpl.setKey(RedisConst.dictionaryKey + "22", "123");
//		System.out.println(redisClientImpl.getKey(RedisConst.dictionaryKey + "22"));
		return count;
	}

	@Override
	public Page findDictionaryPageList(DictionaryQueryVO queryVO) {
		Map<String, Object> map = BeanUtils.objectToMap(queryVO);
		int count = dictionaryMapper.findDictionaryPageListCount(map);
		Page page = new Page(count, queryVO.getPageSize());
		List<Dictionary> list = dictionaryMapper.findDictionaryPageList(map);
		page.setData(BeanUtils.listTransfer(list, DictionaryViewVO.class));
		page.setTotalCount(count);
		page.setBeginIndex(queryVO.getBeginIndex());
		page.setSuccess(true);
		return page;
	}

	@Override
	public int delDictionary(Long dicId) {
		if(dicId == 0 || dicId == null){
			new Exception("删除对象不能为空");
		}
		return dictionaryMapper.deleteByPrimaryKey(dicId);
	}

}
