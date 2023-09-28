package com.cafe.cafemenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.cafemenu.entity.Menu;

@Repository(value = "menuRepository")
public interface MenuRepository extends JpaRepository<Menu, Long> {
  
	void deleteById(Integer id);
}
