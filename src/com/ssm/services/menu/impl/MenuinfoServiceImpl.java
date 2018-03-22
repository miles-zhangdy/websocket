package com.ssm.services.menu.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.business.menu.dao.MenuinfoMapper;
import com.ssm.business.menu.model.Menuinfo;
import com.ssm.business.menu.vo.MenuinfoQueryVO;
import com.ssm.business.menu.vo.MenuinfoVO;
import com.ssm.business.menu.vo.MenuinfoViewVO;
import com.ssm.common.redis.SpringRedisClient;
import com.ssm.common.util.BeanUtils;
import com.ssm.services.menu.MenuinfoService;

@Service
public class MenuinfoServiceImpl implements MenuinfoService{

	@Resource
	private MenuinfoMapper menuinfoMapper;
	
	@SuppressWarnings("unused")
	@Resource
	private SpringRedisClient redisService;
	
	@Override
	public List<MenuinfoViewVO> findMenuinfoList(MenuinfoQueryVO queryVO) {
		Map<String, Object> map = BeanUtils.objectToMap(queryVO);
		List<Menuinfo> list = menuinfoMapper.findMenuList(map);
		return BeanUtils.listTransfer(list, MenuinfoViewVO.class);
	}

	@Override
	public int insertMenuinfo(MenuinfoVO menuinfoVO) {
		return 0;
	}

	@Override
	public int deleteMenuinfo(MenuinfoVO menuinfoVO) {
		return 0;
	}

	@Override
	public int roleMenuinfo(MenuinfoVO menuinfoVO) {
		Menuinfo menuinfo = new Menuinfo();
		menuinfo.setAliveFlag(0);
		menuinfo.setRoleId(menuinfoVO.getRoleId());
		menuinfoMapper.updateByPrimaryKeySelective(menuinfo);
		Map<String, Object> map = BeanUtils.objectToMap(menuinfoVO);
		map.put("menuIds", menuinfoVO.getIds().split(","));
		int count = menuinfoMapper.insertRoleMenuinfo(map);
		return count;
	}

	@Override
	public List<MenuinfoViewVO> findOneRankMenuinfoList(MenuinfoQueryVO queryVO) {
		Map<String, Object> map = BeanUtils.objectToMap(queryVO);
		List<Menuinfo> list = menuinfoMapper.findMenuList(map);
		return BeanUtils.listTransfer(list, MenuinfoViewVO.class);
	}

	@Override
	public List<MenuinfoViewVO> findTwoRankMenuinfoList(MenuinfoQueryVO queryVO) {
		Map<String, Object> map = BeanUtils.objectToMap(queryVO);
		List<Menuinfo> list = menuinfoMapper.findMenuList(map);
		return BeanUtils.listTransfer(list, MenuinfoViewVO.class);
	}

	@Override
	public MenuinfoViewVO findFirstMenuinfo(MenuinfoQueryVO queryVO) {
		Map<String, Object> map = BeanUtils.objectToMap(queryVO);
		Menuinfo menuinfo = menuinfoMapper.getMenuByParentIdFirst(map);
		return BeanUtils.copyBeanToBean(menuinfo, MenuinfoViewVO.class);
	}

}
