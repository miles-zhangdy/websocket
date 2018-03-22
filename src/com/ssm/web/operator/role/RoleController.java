package com.ssm.web.operator.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ssm.business.menu.vo.MenuQueryVO;
import com.ssm.business.menu.vo.MenuViewVO;
import com.ssm.business.role.vo.RoleQueryVO;
import com.ssm.common.controller.BaseController;
import com.ssm.common.model.EnvironmentUserVO;
import com.ssm.common.model.Page;
import com.ssm.services.menu.MenuService;
import com.ssm.services.role.RoleService;
import com.ssm.util.JSTressUtil;

@Controller
@RequestMapping("admin/role")
public class RoleController extends BaseController {

	@Resource
	private RoleService roleService;
	
	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/toRolePage")
	public ModelAndView toRoleMgrPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/operator/role/rolemgr");
		EnvironmentUserVO environmentUserVO = this.getEnvironmentUserVO();
		RoleQueryVO queryVO = new RoleQueryVO();
		queryVO.setBeginIndex(0);
		queryVO.setPageSize(10);
		queryVO.setAliveFlag(1);
		queryVO.setCreateUser(environmentUserVO.getUserId() + "");
		Page page = roleService.findRolePageList(queryVO);
		modelAndView.addObject("data", JSON.toJSONString(page));
		
		MenuQueryVO menuQueryVO = new MenuQueryVO();
		queryVO.setAliveFlag(1);
		List<MenuViewVO> menuList = menuService.findMenuList(menuQueryVO);
		List<JSTressUtil> jsTree = new ArrayList<JSTressUtil>();
		for(MenuViewVO vo : menuList){
			jsTree.add(new JSTressUtil(vo));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jsontree", jsTree);
		modelAndView.addObject("menuList", JSON.toJSONString(map));
		
		this.setMenu(modelAndView);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/findRolePageList")
	public Page findMenuPageList(HttpServletRequest request, RoleQueryVO queryVO) {
		queryVO.setBeginIndex((queryVO.getPage() - 1) * queryVO.getPageSize());
		Page page = roleService.findRolePageList(queryVO);
		return page;
	}

}
