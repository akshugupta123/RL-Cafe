package com.cafe.services;

import java.util.List;

import com.cafe.entity.Admin;

public interface IAdminService {
Admin addAdmin(Admin admin);
	
	

	List<Admin> getAllAdmins();

	Admin getAdminById(Integer id);



	Admin getAdminByEmail(String email);



	Admin updateAdmin(Admin admin);



	void deleteAdminById(Integer id);

}
