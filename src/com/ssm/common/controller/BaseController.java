package com.ssm.common.controller;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.business.menu.vo.MenuQueryVO;
import com.ssm.business.menu.vo.MenuViewVO;
import com.ssm.common.model.EnvironmentUserVO;
import com.ssm.services.menu.MenuService;
import com.ssm.util.Const;

public class BaseController {

	@SuppressWarnings("unused")
	private EnvironmentUserVO environmentUserVO;

	@SuppressWarnings("unused")
	private String ctx;

	@Resource
	private MenuService menuService;

	public EnvironmentUserVO getEnvironmentUserVO() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		return (EnvironmentUserVO) session.getAttribute(Const.SESSION_ENVIR);
	}

	public String getCtx() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request.getContextPath();
	}

	public void setMenu(ModelAndView modelAndView) {
		EnvironmentUserVO userVO = getEnvironmentUserVO();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		if (userVO.getUserType() == 1) {
			// 管理员登录 去menu表信息
			// 获取二级菜单
			MenuQueryVO menuVO = new MenuQueryVO();
			menuVO.setMenuRank(2);
			List<MenuViewVO> menuList2 = menuService.findMenuList(menuVO);
			modelAndView.addObject("menuList2", menuList2);
			// 获取1级菜单
			menuVO = new MenuQueryVO();
			menuVO.setMenuRank(1);
			List<MenuViewVO> menuList1 = menuService.findMenuList(menuVO);
			modelAndView.addObject("menuList1", menuList1);
			String parentId = request.getParameter("parentId");
			if (parentId != null && !"".equals(parentId)) {
				modelAndView.addObject("parentId", parentId);
			} else {
				modelAndView.addObject("parentId", "");
			}
		} else {
			// 非管理登录 去menuinfo表信息
			// Long roleId = userVO.getRoleId();
			// 获取一级菜单

			// 获取二级菜单

		}

		// 登录用户信息
		EnvironmentUserVO environmentUserVO = getEnvironmentUserVO();
		modelAndView.addObject("userVO", environmentUserVO);
	}

	public static void transMap2Bean(Object bean, Map<String, Object> map) {

		if (null == bean || null == map) {
			return;
		}

		try {
			PropertyDescriptor[] propertyDescriptors = propertyDescriptor(bean);
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (map.containsKey(key)) {
					Object value = map.get(key);
					Method setter = property.getWriteMethod();
					if (null != setter) {
						setter.invoke(bean, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static PropertyDescriptor[] propertyDescriptor(Object obj)
			throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		return beanInfo.getPropertyDescriptors();
	}
}
