package com.peng.crowd.service.api;

import com.github.pagehelper.PageInfo;
import com.peng.crowd.entity.ProjectVO;
import com.peng.crowd.entity.Role;

import java.util.List;

public interface ProjectService {
	
	PageInfo<ProjectVO> getPageInfo(Integer pageNum, Integer pageSize, String keyword);

    void unCheck(List<Integer> roleIdList);

    void check(List<Integer> projectIdList);

//	void saveRole(Role role);
//
//	void updateRole(Role role);
//
//	void removeRole(List<Integer> roleIdList);
//
//	List<Role> getAssignedRole(Integer adminId);
//
//	List<Role> getUnAssignedRole(Integer adminId);

}
