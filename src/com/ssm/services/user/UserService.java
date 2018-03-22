package com.ssm.services.user;

import com.ssm.business.user.vo.UserLoginVO;
import com.ssm.business.user.vo.UserVO;

public interface UserService {
	
	public int userRegister(UserVO userVO);
	
	public UserVO userLogin(UserLoginVO userVO);
	
	public UserVO getUserByPK(Long userId);
}
