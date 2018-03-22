/**   
* @Title: MenuServiceImpl.java
* @Package com.ssm.services.menu.impl
* @Description: TODO
* @author zhangdaye
* @date 2016年5月24日 下午5:34:41
* @version V1.0   
*/
package com.ssm.services.menu.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.business.menu.dao.MenuMapper;
import com.ssm.business.menu.model.Menu;
import com.ssm.business.menu.vo.MenuQueryVO;
import com.ssm.business.menu.vo.MenuVO;
import com.ssm.business.menu.vo.MenuViewVO;
import com.ssm.common.model.Page;
import com.ssm.common.redis.SpringRedisClient;
import com.ssm.common.util.BeanUtils;
import com.ssm.services.menu.MenuService;

/**
* @ClassName: MenuServiceImpl
* @Description: TODO
* @author zhangdy
* 
*/
@Service
public class MenuServiceImpl implements MenuService{

    @Resource
    private MenuMapper menuMapper;
    
    @Resource
	private SpringRedisClient redisService;
    
    @Override
    public MenuViewVO getMenuDetail(Long menuId) {
    	if(menuId == 0 || menuId == null){
    		new Exception("主键不能为空");
    	}
    	//FIXME  redis缓存使用
    	redisService.setKey("", "");
        return BeanUtils.copyBeanToBean(menuMapper.selectByPrimaryKey(menuId), MenuViewVO.class);
    }

	@Override
	public Page findMenuPageList(MenuQueryVO vo) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		map = BeanUtils.objectToMap(vo);
		int count = menuMapper.getMenuPageListCount(map);
		Page page = new Page(count, vo.getPageSize());
		List<Menu> list = menuMapper.findMenuPageList(map);
		page.setData(BeanUtils.listTransfer(list, MenuViewVO.class));
		page.setTotalCount(count);
		page.setBeginIndex(vo.getBeginIndex());
		page.setSuccess(true);
		return page;
	}

	@Override
	public int insertMenu(MenuVO menuVO) {
		if(menuVO == null){
			new Exception("存储对象不能为空");
			return 0;
		}
		String parentId = menuVO.getParentId();
		if(parentId == null || "".equals(parentId)){
			menuVO.setMenuRank(1);
		}else{
			menuVO.setMenuRank(2);
		}
		return menuMapper.insert(BeanUtils.copyBeanToBean(menuVO, Menu.class));
	}

	@Override
	public List<MenuViewVO> findMenuList(MenuQueryVO queryVO) {
		if(queryVO == null){
			new Exception("查询条件不能为空");
		}
		return BeanUtils.listTransfer(menuMapper.findMenuList(BeanUtils.objectToMap(queryVO)), MenuViewVO.class);
	}

	@Override
	public MenuViewVO getMenuByParentIdFirst(String parentId) {
		if(parentId == null || "".equals(parentId)){
			new Exception("查询条件不能为空");
		}
		menuMapper.getMenuByParentIdFirst(parentId);
		return BeanUtils.copyBeanToBean(menuMapper.getMenuByParentIdFirst(parentId), MenuViewVO.class);
	}
    
}
