package com.cafe.cafemenu.services;

import java.util.List;

import com.cafe.cafemenu.entity.Menu;


public interface IMenuService {
    Menu addMenu(Menu menu);
    List<Menu> getAllMenus();
    Menu getMenuById(Long id);
    Menu updateMenu(Menu menu);
    void deleteMenuById(Integer id);
}