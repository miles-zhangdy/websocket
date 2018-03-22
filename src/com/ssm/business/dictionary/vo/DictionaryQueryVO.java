package com.ssm.business.dictionary.vo;

import com.ssm.common.model.SupperVO;

public class DictionaryQueryVO extends SupperVO{

	private String createUser;

	private Integer aliveFlag;
	
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getAliveFlag() {
		return aliveFlag;
	}

	public void setAliveFlag(Integer aliveFlag) {
		this.aliveFlag = aliveFlag;
	}
	
	
}
