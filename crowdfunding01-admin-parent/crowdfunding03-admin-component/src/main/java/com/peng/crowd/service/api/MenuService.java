package com.peng.crowd.service.api;

import java.util.List;

import com.peng.crowd.entity.Menu;

public interface MenuService {
	
	List<Menu> getAll();

	void saveMenu(Menu menu);

	void updateMenu(Menu menu);

	void removeMenu(Integer id);

}
