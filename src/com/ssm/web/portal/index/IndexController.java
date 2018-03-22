package com.ssm.web.portal.index;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.controller.BaseController;
import com.ssm.util.ZTreeUtil;

@Controller
@RequestMapping("index")
public class IndexController extends BaseController{
	
	@RequestMapping(value = "/")
	public String index(){
		return "/portal/index/index";
	}
	@RequestMapping(value = "/sp")
	public String sp(){
		return "/portal/index/sp";
	}
	@RequestMapping(value = "/ztree")
	public String ztree(){
		return "/portal/ztree/ztree";
	}
	@ResponseBody
	@RequestMapping(value = "/getztree")
	public String getztree(){
		List<ZTreeUtil> list = new ArrayList<ZTreeUtil>();
		list.add(new ZTreeUtil("1", "0", "菜单1"));
		list.add(new ZTreeUtil("2", "1", "菜单2"));
		list.add(new ZTreeUtil("3", "2", "菜单3"));
		list.add(new ZTreeUtil("4", "1", "菜单4"));
		list.add(new ZTreeUtil("5", "1", "菜单5"));
		list.add(new ZTreeUtil("6", "4", "菜单6"));
		list.add(new ZTreeUtil("7", "3", "菜单7"));
		list.add(new ZTreeUtil("8", "2", "菜单8"));
		list.add(new ZTreeUtil("9", "4", "菜单9"));
		list.add(new ZTreeUtil("10", "4", "菜单10"));
		list.add(new ZTreeUtil("11", "3", "菜单11"));
		list.add(new ZTreeUtil("12", "2", "菜单12"));
		
		return JSONArray.fromObject(list).toString();
	}
}
