package com.peng.crowd.service.api;

import java.util.List;

import com.peng.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;

public interface AdminService {
	
	void saveAdmin(Admin admin, HttpSession session);

	List<Admin> getAll();

	Admin getAdminByLoginAcct(String loginAcct, String userPswd);
	
	PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

	void remove(Integer adminId);

	Admin getAdminById(Integer adminId);

	void update(Admin admin);

	void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);

	Admin getAdminByLoginAcct(String username);

}
