package com.ssm.services.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.business.user.dao.UserMapper;
import com.ssm.business.user.model.User;
import com.ssm.business.user.vo.UserLoginVO;
import com.ssm.business.user.vo.UserVO;
import com.ssm.common.util.BeanUtils;
import com.ssm.services.user.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public int userRegister(UserVO userVO) {
		if(userVO == null){
			new Exception("对象为空");
		}
		userVO.setOperTime(new Date().getTime());
		return userMapper.insert(BeanUtils.copyBeanToBean(userVO, User.class));
	}

	@Override
	public UserVO userLogin(UserLoginVO userVO) {
		if(userVO == null){
			new Exception("对象为空");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userVO.getUserName());
		map.put("pwd", userVO.getPwd());
		User user = userMapper.userLogin(map);
		if(user == null){
			return null;
		}
		return BeanUtils.copyBeanToBean(user, UserVO.class);
	}

	@Override
	public UserVO getUserByPK(Long userId) {
		if(userId == null){
			new Exception("对象为空");
		}
		return BeanUtils.copyBeanToBean(userMapper.selectByPrimaryKey(userId), UserVO.class);
	}

}
