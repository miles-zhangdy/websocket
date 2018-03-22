/**   
* @Title: MenuService.java
* @Package com.ssm.services.menu
* @Description: TODO
* @author zhangdaye
* @date 2016年5月24日 下午5:33:35
* @version V1.0   
*/
package com.ssm.services.menu;

import java.util.List;

import com.ssm.business.menu.vo.MenuQueryVO;
import com.ssm.business.menu.vo.MenuVO;
import com.ssm.business.menu.vo.MenuViewVO;
import com.ssm.common.model.Page;


/**
* @ClassName: MenuService
* @Description: TODO
* @author zhangdy
* 
*/
public interface MenuService {

    public MenuViewVO getMenuDetail(Long menuId);
    
    public Page findMenuPageList(MenuQueryVO vo);
    
    public int insertMenu(MenuVO menuVO);
    
    public List<MenuViewVO> findMenuList(MenuQueryVO queryVO);
    
    public MenuViewVO getMenuByParentIdFirst(String parentId);
    
}
