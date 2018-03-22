package com.ssm.services.role.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ssm.business.role.dao.RoleMapper;
import com.ssm.business.role.model.Role;
import com.ssm.business.role.vo.RoleQueryVO;
import com.ssm.business.role.vo.RoleVO;
import com.ssm.business.role.vo.RoleViewVO;
import com.ssm.common.model.Page;
import com.ssm.common.model.ServiceResult;
import com.ssm.common.redis.RedisConst;
import com.ssm.common.redis.SpringRedisClientImpl;
import com.ssm.common.util.BeanUtils;
import com.ssm.services.role.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private SpringRedisClientImpl redisImpl;

	@Resource
	private RoleMapper roleMapper;

	@Override
	public Page findRolePageList(RoleQueryVO queryVO) {
		Map<String, Object> map = BeanUtils.objectToMap(queryVO);
		int count = roleMapper.getRolePageListCount(map);
		Page page = new Page(count, queryVO.getPageSize());
		List<Role> list = roleMapper.findRolePageList(map);
		page.setData(BeanUtils.listTransfer(list, RoleViewVO.class));
		page.setTotalCount(count);
		page.setBeginIndex(queryVO.getBeginIndex());
		page.setSuccess(true);
		return page;
	}

	@Override
	public int insertRole(RoleVO roleVO) {
		if(roleVO == null){
			new Exception("对象不能为空");
		}
		Role role = BeanUtils.copyBeanToBean(roleVO, Role.class);
		int count = roleMapper.insert(role);
		if(count > 0){
			redisImpl.setKey(RedisConst.roleKey + role.getRoleId(), roleMapper.selectByPrimaryKey(role.getRoleId()));
		}
		return count;
	}

	@Override
	public ServiceResult<RoleViewVO> getRoleByPK(RoleQueryVO queryVO) {
		ServiceResult<RoleViewVO> result = new ServiceResult<RoleViewVO>();
		result.setIsSuccess(false);
		if(!StringUtils.isNotBlank(queryVO.getRoleId()+"")){
			new Exception("主键不能为空");
		}
		Object obj = redisImpl.getKey(RedisConst.roleKey + queryVO.getRoleId());
		if(obj != null){
			result.setIsSuccess(true);
			result.setBusinessObject(BeanUtils.copyBeanToBean((Role)obj, RoleViewVO.class));
			return result;
		}
		Role role = roleMapper.selectByPrimaryKey(queryVO.getRoleId());
		if(role != null){
			result.setIsSuccess(true);
			result.setBusinessObject(BeanUtils.copyBeanToBean(role, RoleViewVO.class));
			return result;
		}
		return result;
	}
	
	
	
}
