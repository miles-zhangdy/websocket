package com.ssm.common.model;

import java.io.Serializable;

public class ServiceResult<B> implements Serializable {
	
	private static final long serialVersionUID = -5461351103181713117L;
	
    private boolean isSuccess = false;

    private B businessObject;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public B getBusinessObject() {
		return businessObject;
	}

	public void setBusinessObject(B businessObject) {
		this.businessObject = businessObject;
	}

}
