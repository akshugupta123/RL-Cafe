package com.menu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.menu.entity.Menu;
import com.menu.services.IMenuService;

 

// Book Restful WebServices

@RestController
@Scope("request")
public class MenuRestController {

	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService;
	
	private Logger log =LoggerFactory.getLogger(MenuRestController.class);

	
	@GetMapping(value = "/menus", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Menu> getAllMenus() {
		List<Menu> menu=menuService.getAllMenus();
		log.debug("In getAllMenus with return value Menu: " + menu);
		return menu;
		//return adminService.getAllAdmins();
	}
	
	@GetMapping(value = "/menus/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Menu getMenuById(@PathVariable("id")int id) {
		log.debug("In getMenuById with ID: " + id);
		Menu menu=menuService.getMenuById(id);
		log.debug("In getMenuById with return value Menu: " + menu);
		return menu;
//		return bookService.getBookById(id);
	}
	 
//	@GetMapping(value = "/books/publisher/{publisher}", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public Book getBookpublisher(@PathVariable("publisher") String publisher) {
//		
//		return bookService.getBookPublisher(publisher);
//	}
	
	 
	
	@PostMapping(value = "/menus", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Menu addMenu(@RequestBody Menu menu) {
		
		return menuService.addMenu(menu);
	}

	@PutMapping(value = "/menus", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Menu updateMenu(@RequestBody Menu menu) {
		
		return menuService.updateMenu(menu);
	}

	@DeleteMapping(value = "/menus/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMenuById(@PathVariable("id")Integer id) {
		
		menuService.deleteMenuById(id);
	}
}










