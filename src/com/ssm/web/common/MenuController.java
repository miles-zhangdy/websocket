package com.ssm.web.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.business.menu.vo.MenuViewVO;
import com.ssm.services.menu.MenuService;

@Controller
@RequestMapping("admin/switch")
public class MenuController {

	@Resource
	private MenuService menuService;
	
	@RequestMapping(value = "/{witemgr}/{menuId}")
	public String switchMenu(HttpServletRequest request, @PathVariable String menuId){
		MenuViewVO menuViewVO = menuService.getMenuByParentIdFirst(menuId);
		return "redirect:/" + menuViewVO.getMenuUrl() + "?parentId=" + menuId;
	}
	
}
