package com.ssm.web.portal.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.business.user.vo.UserVO;
import com.ssm.common.interceptor.Password;
import com.ssm.services.user.UserService;

@Controller
@RequestMapping("/portal/register")
public class UserRegisterController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/toregister")
	public ModelAndView toRegister() {
		ModelAndView modelAndView = new ModelAndView("/portal/register");
		return modelAndView;
	}

	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest request, UserVO userVO, @Password String password) {
		ModelAndView modelAndView = new ModelAndView("/portal/register");
		userVO.setPassword(password);
		userVO.setHeadPic((int)(1+Math.random()*10));
		int count = userService.userRegister(userVO);
		System.out.println(count);
		return modelAndView;
	}

}
