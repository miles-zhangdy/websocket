package com.ssm.services.dictionary;

import com.ssm.business.dictionary.vo.DictionaryQueryVO;
import com.ssm.business.dictionary.vo.DictionaryVO;
import com.ssm.common.model.Page;

public interface DictionaryService {

	public int insertDictionary(DictionaryVO dictionaryVO);
	
	public Page findDictionaryPageList(DictionaryQueryVO queryVO);
	
	public int delDictionary(Long dicId);
	
}
