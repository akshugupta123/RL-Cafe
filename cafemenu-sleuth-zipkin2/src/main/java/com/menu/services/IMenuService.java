package com.menu.services;

import java.util.List;

import com.menu.entity.Menu;

//import com.cafe.entity.Admin;

public interface IMenuService {
Menu addMenu(Menu menu);
	List<Menu> getAllMenus();
	
	Menu updateMenu(Menu menu);
	void deleteMenuById(Integer id);
	Menu getMenuById(int id);


}
