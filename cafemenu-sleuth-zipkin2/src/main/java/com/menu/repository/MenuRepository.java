package com.menu.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.entity.Menu;

 


@Repository(value = "menuRepository")
@Scope("singleton")
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	
	

}
