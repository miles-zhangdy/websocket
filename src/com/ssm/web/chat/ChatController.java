package com.ssm.web.chat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.business.user.vo.UserLoginVO;
import com.ssm.business.user.vo.UserVO;
import com.ssm.common.controller.BaseController;
import com.ssm.common.interceptor.Password;
import com.ssm.common.model.EnvironmentUserVO;
import com.ssm.services.user.UserService;
import com.ssm.util.Const;

@Controller
@RequestMapping("chat")
public class ChatController extends BaseController{

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/index")
	public ModelAndView chatIndex(){
		ModelAndView modelAndView = new ModelAndView("/chat/chatindex");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/tologin")
	public String chatLogin(HttpServletRequest request){
		Object obj = request.getSession().getAttribute(Const.SESSION_ENVIR);
		if(obj != null){
			return "redirect:/chat/index";
		}
		return "/chat/login";
	}
	
	@RequestMapping(value = "/login")
	public String chatlogin(UserLoginVO userLoginVO, @Password String password,
			HttpServletRequest request){
		if(StringUtils.isEmpty(password)){
			return "/chat/login";
		}
		userLoginVO.setPwd(password);
		UserVO userVO = userService.userLogin(userLoginVO);
		setSession(userVO, request.getSession());
		return "redirect:/chat/index";
	}
	
	private void setSession(UserVO vo, HttpSession session) {
		EnvironmentUserVO environmentUserVO = new EnvironmentUserVO();
		environmentUserVO.setUserId(vo.getUserId());
		environmentUserVO.setUserName(vo.getUserName());
		environmentUserVO.setUserType(vo.getUserType());
		environmentUserVO.setRoleId(vo.getRoleId());
		environmentUserVO.setNickname(vo.getNickname());
		environmentUserVO.setHeadPic(vo.getHeadPic());
		session.setAttribute(Const.SESSION_ENVIR, environmentUserVO);
	}
	
}
