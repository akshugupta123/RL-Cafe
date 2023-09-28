package com.menu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.menu.entity.Menu;
import com.menu.repository.MenuRepository;

 

@Service(value = "menuService")
@Scope("singleton")
@Transactional
public class MenuService implements IMenuService{
	
	@Autowired
	@Qualifier("menuRepository")
	private MenuRepository menuRepository;

	@Override
	public Menu addMenu(Menu menu) {
		
		return  menuRepository.save(menu);
	}
	@Override
	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}

	

	@Override
	public Menu updateMenu(Menu menu)
	{
		return menuRepository.save(menu);
	}

	@Override
	public void deleteMenuById(Integer id) {
		menuRepository.deleteById(id);
		
	}
	@Override
	public Menu getMenuById(int id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id).get();
	}

}
