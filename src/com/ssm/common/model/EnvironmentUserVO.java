package com.ssm.common.model;

public class EnvironmentUserVO {
	
	private Long userId;
	
	private Long roleId;
	
	private String userName;
	
	private Integer userType;

	private String nickname;
	
	private Integer headPic;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getHeadPic() {
		return headPic;
	}

	public void setHeadPic(Integer headPic) {
		this.headPic = headPic;
	}
	
}
