package com.ssm.services.menu;

import java.util.List;

import com.ssm.business.menu.vo.MenuinfoQueryVO;
import com.ssm.business.menu.vo.MenuinfoVO;
import com.ssm.business.menu.vo.MenuinfoViewVO;

public interface MenuinfoService {
	
	public List<MenuinfoViewVO> findMenuinfoList(MenuinfoQueryVO queryVO);
	
	public int insertMenuinfo(MenuinfoVO menuinfoVO);
	
	public int deleteMenuinfo(MenuinfoVO menuinfoVO);
	
	public int roleMenuinfo(MenuinfoVO menuinfoVO);
	
	public List<MenuinfoViewVO> findOneRankMenuinfoList(MenuinfoQueryVO queryVO);
	
	public List<MenuinfoViewVO> findTwoRankMenuinfoList(MenuinfoQueryVO queryVO);
	
	public MenuinfoViewVO findFirstMenuinfo(MenuinfoQueryVO queryVO);
	
}
