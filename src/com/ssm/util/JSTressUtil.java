package com.ssm.util;

import java.io.Serializable;

import com.ssm.business.menu.vo.MenuViewVO;
import com.ssm.business.menu.vo.MenuinfoViewVO;

public class JSTressUtil implements Serializable{

	private static final long serialVersionUID = -4621055052138136781L;

	private String id;
	
	private String parent;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	
	public JSTressUtil(){}
	
	public JSTressUtil(MenuViewVO menu){
		this.id = menu.getMenuId() + "";
		this.parent = menu.getParentId() == null || "".equals(menu.getParentId()) || "0".equals(menu.getParentId()) ? "#" : menu.getParentId();
		this.setName(menu.getMenuName());
	}
	
	public JSTressUtil(MenuinfoViewVO menu){
		this.id = menu.getMenuId() + "";
		this.parent = menu.getParentId() == null || "".equals(menu.getParentId()) || "0".equals(menu.getParentId()) ?  "#" : menu.getParentId();
		this.setName(menu.getMenuName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
