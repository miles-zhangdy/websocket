package com.ssm.web.operator.menu;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ssm.business.menu.vo.MenuQueryVO;
import com.ssm.business.menu.vo.MenuVO;
import com.ssm.common.controller.BaseController;
import com.ssm.common.model.EnvironmentUserVO;
import com.ssm.common.model.Page;
import com.ssm.common.model.Result;
import com.ssm.services.menu.MenuService;
import com.ssm.util.Const;


@Controller
@RequestMapping("admin/menumgr")
public class MenuMgrController extends BaseController {
	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/tomenumgrpage")
	public ModelAndView toMenuMgrPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/operator/menu/menumgr");
		MenuQueryVO queryVO = new MenuQueryVO();
		queryVO.setBeginIndex(0);
		queryVO.setPageSize(10);
		queryVO.setAliveFlag(1);
		queryVO.setMenuRank(1);
		Page page = menuService.findMenuPageList(queryVO);
		modelAndView.addObject("data", JSON.toJSONString(page));
		this.setMenu(modelAndView);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/findMenuPageList")
	public Page findMenuPageList(HttpServletRequest request, MenuQueryVO queryVO) {
		queryVO.setBeginIndex((queryVO.getPage() - 1) * queryVO.getPageSize());
		return menuService.findMenuPageList(queryVO);
	}

	@ResponseBody
	@RequestMapping(value = "/insertMenu")
	public Result insertMenu(HttpServletRequest request, MenuVO menuVO) {
		Result result = new Result();
		EnvironmentUserVO environmentUserVO = this.getEnvironmentUserVO();
		menuVO.setCreateUser(environmentUserVO.getUserId());
		menuVO.setCreateTime(new Date().getTime());
		int count = menuService.insertMenu(menuVO);
		if (count > 0) {
			result.setSuccess(true);
			result.setMsg(Const.ADD_SUC);
			return result;
		}
		result.setSuccess(false);
		result.setMsg(Const.ADD_FAIL);
		return result;
	}

}
