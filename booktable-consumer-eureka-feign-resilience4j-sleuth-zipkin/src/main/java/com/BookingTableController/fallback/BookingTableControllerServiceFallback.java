//package com.admin.fallback;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.admin.entity.Admin;
//import com.admin.proxy.AdminServiceProxy;
//
// 
//
//@Component
//public class AdminServiceFallback implements AdminServiceProxy{
//
//	@Override
//	public List<Admin> getAllAdmins() {
//		return new ArrayList<Admin>();
//	}
//
//	@Override
//	public Admin getAdminById(Integer id) {
//		return new Admin(id,"admin","admin","password");
//		
//	}
//
//}
package com.BookingTableController.fallback;


