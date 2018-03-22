package com.ssm.web.operator.main;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.business.user.vo.UserLoginVO;
import com.ssm.business.user.vo.UserVO;
import com.ssm.common.controller.BaseController;
import com.ssm.common.interceptor.Password;
import com.ssm.common.interceptor.Token;
import com.ssm.common.model.EnvironmentUserVO;
import com.ssm.services.user.UserService;
import com.ssm.util.Const;

@Controller
@RequestMapping("admin")
public class MainController extends BaseController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/index")
	public ModelAndView adminIndex(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/operator/main/index");
		HttpSession session = request.getSession();
		EnvironmentUserVO environmentUserVO = (EnvironmentUserVO) session
				.getAttribute(Const.SESSION_ENVIR);
		if (environmentUserVO == null) {
			modelAndView = new ModelAndView("/operator/main/login");
			return modelAndView;
		}
		this.setMenu(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/tologin")
	@Token(save = true)
	public String toLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		EnvironmentUserVO environmentUserVO = (EnvironmentUserVO) session
				.getAttribute(Const.SESSION_ENVIR);
		if (environmentUserVO == null) {
			// 未登录
			return "/operator/main/login";
		}
		// 已登录
		return "redirect:/admin/index";
	}

	@RequestMapping(value = "/login")
	@Token(remove = true)
	public String login(UserLoginVO userLoginVO, @Password String password,
			HttpServletRequest request) {
		userLoginVO.setPwd(password);
		HttpSession session = request.getSession();
		String validatiCode = session.getAttribute(Const.validatiCode) == null ? ""
				: session.getAttribute(Const.validatiCode).toString();

		if (!validatiCode.equals(userLoginVO.getValidateCode())) {
			// 验证码错误
		} else {
			UserVO userVO = userService.userLogin(userLoginVO);
			// 向session中塞值
			setSession(userVO, request.getSession());
		}
		return "redirect:/admin/index";
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/operator/main/login");
		HttpSession session = request.getSession();
		session.setAttribute(Const.SESSION_ENVIR, null);
		return modelAndView;
	}

	private void setSession(UserVO vo, HttpSession session) {
		EnvironmentUserVO environmentUserVO = new EnvironmentUserVO();
		environmentUserVO.setUserId(vo.getUserId());
		environmentUserVO.setUserName(vo.getUserName());
		environmentUserVO.setUserType(vo.getUserType());
		environmentUserVO.setRoleId(vo.getRoleId());
		environmentUserVO.setNickname(vo.getNickname());
		session.setAttribute(Const.SESSION_ENVIR, environmentUserVO);
	}

}
