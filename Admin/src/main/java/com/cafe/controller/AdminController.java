package com.cafe.controller;

import java.util.List;

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
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.cafe.entity.Admin;
import com.cafe.services.IAdminService;



@RestController

@Scope("request")
public class AdminController {
	 private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;
	
	@GetMapping(value = "/Admins", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Admin> getAllAdmins() {
        logger.debug("Fetching all admins...");
        List<Admin> admins = adminService.getAllAdmins();
        logger.debug("Fetched {} admins.", admins.size());
        return admins;
    }

    @GetMapping(value = "/Admins/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Admin getAdminById(@PathVariable("id") Integer id) {
        logger.debug("Fetching admin with ID: {}", id);
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            logger.debug("Fetched admin with ID {}: {}", id, admin);
        } else {
            logger.debug("Admin with ID {} not found.", id);
        }
        return admin;
    }

    @PostMapping(value = "/Admins", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin addAdmin(@RequestBody Admin admin) {
        logger.debug("Adding a new admin: {}", admin);
        Admin addedAdmin = adminService.addAdmin(admin);
        logger.debug("Added admin with ID {}: {}", addedAdmin.getId(), addedAdmin);
        return addedAdmin;
    }

    @PutMapping(value = "/Admins", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.OK)
    public Admin updateAdmin(@RequestBody Admin admin) {
        logger.debug("Updating admin with ID: {}", admin.getId());
        Admin updatedAdmin = adminService.updateAdmin(admin);
        if (updatedAdmin != null) {
            logger.debug("Updated admin with ID {}: {}", updatedAdmin.getId(), updatedAdmin);
        } else {
            logger.debug("Admin with ID {} not found.", admin.getId());
        }
        return updatedAdmin;
    }

    @DeleteMapping(value = "/Admins/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAdminById(@PathVariable("id") Integer id) {
        logger.debug("Deleting admin with ID: {}", id);
        adminService.deleteAdminById(id);
        logger.debug("Admin with ID {} deleted successfully.", id);
    	}
}










