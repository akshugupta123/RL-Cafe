package com.cafe.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.entity.Admin;


@Repository(value = "adminRepository")
@Scope("singleton")
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin getByEmail(String email);

	

}
