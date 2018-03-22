package com.ssm.services.role;

import com.ssm.business.role.vo.RoleQueryVO;
import com.ssm.business.role.vo.RoleVO;
import com.ssm.business.role.vo.RoleViewVO;
import com.ssm.common.model.Page;
import com.ssm.common.model.ServiceResult;

public interface RoleService {

	public Page findRolePageList(RoleQueryVO queryVO);

	public int insertRole(RoleVO roleVO);

	public ServiceResult<RoleViewVO> getRoleByPK(RoleQueryVO queryVO);
	
}
