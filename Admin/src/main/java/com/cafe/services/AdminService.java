package com.cafe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.entity.Admin;
import com.cafe.repository.AdminRepository;


@Service(value = "adminService")
@Scope("singleton")
@Transactional
public class AdminService implements IAdminService{
	
	@Autowired
	@Qualifier("adminRepository")
	private AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(Integer id) {
		return adminRepository.findById(id).get();
	}

	@Override
	public Admin getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepository.getByEmail(email);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdminById(Integer id) {
		adminRepository.deleteById(id);
		
	}

	

	

}
