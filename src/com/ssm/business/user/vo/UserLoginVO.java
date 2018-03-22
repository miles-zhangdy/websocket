package com.ssm.business.user.vo;


public class UserLoginVO {
	private String userName;

	private String pwd;
	
	private String validateCode;

	private Integer headPic;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getHeadPic() {
		return headPic;
	}

	public void setHeadPic(Integer headPic) {
		this.headPic = headPic;
	}
	
	
}
