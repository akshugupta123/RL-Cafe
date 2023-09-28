package com.cafe.cafemenu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cafe.cafemenu.entity.Menu;
import com.cafe.cafemenu.services.IMenuService;


@RestController
@Scope("request")
public class MenuController {

    @Autowired
    @Qualifier("menuService")
    private IMenuService menuService;

    @GetMapping(value = "/menus", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping(value = "/menus/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Menu getMenuById(@PathVariable("id") Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping(value = "/menu", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @PutMapping(value = "/menu", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.OK)
    public Menu updateMenu(@RequestBody Menu menu) {
        return menuService.updateMenu(menu);
    }

    @DeleteMapping(value = "/menu/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteMenuById(@PathVariable("id") Integer id) {
        menuService.deleteMenuById(id);
    }
}