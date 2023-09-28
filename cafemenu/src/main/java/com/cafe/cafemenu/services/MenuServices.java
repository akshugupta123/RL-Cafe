package com.cafe.cafemenu.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.cafemenu.entity.Menu;
import com.cafe.cafemenu.repository.MenuRepository;


@Service(value = "menuService")
@Scope("singleton")
@Transactional
public class MenuServices implements IMenuService {

    @Autowired
    @Qualifier("menuRepository")
    private MenuRepository menuRepository;

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }


    @Override
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenuById(Integer id) { 
        menuRepository.deleteById(id);
    }

	@Override
	public Menu getMenuById(Long id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id).get();
	}
}