package com.peng.crowd.service.impl;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peng.crowd.entity.ProjectVO;
import com.peng.crowd.mapper.ProjectPOMapper;
import com.peng.crowd.service.api.ProjectService;
import com.peng.crowd.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectPOMapper projectPOMapper;
	@Override
	public PageInfo<ProjectVO> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
		// 1.开启分页功能
		PageHelper.startPage(pageNum, pageSize);
		// 2.执行查询
		List<ProjectVO> projectVOS = projectPOMapper.selectProjectByKeyword(keyword);
		// 3.封装为PageInfo对象返回
		return new PageInfo<>(projectVOS);
	}

	@Override
	public void unCheck(List<Integer> roleIdList) {
		projectPOMapper.unCheck(roleIdList);
	}

	@Override
	public void check(List<Integer> projectIdList) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format1 = format.format(date);
		projectPOMapper.check(format1,projectIdList);
	}

//	@Override
//	public void saveRole(Role role) {
//		roleMapper.insert(role);
//	}
//
//	@Override
//	public void updateRole(Role role) {
//		roleMapper.updateByPrimaryKey(role);
//	}
//
//	@Override
//	public void removeRole(List<Integer> roleIdList) {
//
//		RoleExample example = new RoleExample();
//
//		Criteria criteria = example.createCriteria();
//
//		//delete from t_role where id in (5,8,12)
//		criteria.andIdIn(roleIdList);
//
//		roleMapper.deleteByExample(example);
//	}
//
//	@Override
//	public List<Role> getAssignedRole(Integer adminId) {
//
//		return roleMapper.selectAssignedRole(adminId);
//	}
//
//	@Override
//	public List<Role> getUnAssignedRole(Integer adminId) {
//		return roleMapper.selectUnAssignedRole(adminId);
//	}

}
