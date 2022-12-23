package com.example.collegemanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.collegemanagement.model.Admin;
import com.example.collegemanagement.repository.AdminRepository;
import com.example.collegemanagement.service.AdminService;
import com.example.collegemanagement.exception.AdminNotFoundException;

@Service

public class AdminServiceImpl implements AdminService{
   
  @Autowired
 private AdminRepository adminRepository;

public AdminServiceImpl(AdminRepository adminRepository) {
	super();
	this.adminRepository = adminRepository;
}

	
	
@Override
		
public Admin saveAdmin(Admin admin) {
		
	return adminRepository.save(admin);
		
		
	
	
}
@Override
public Admin loginAdmin(Admin admin) {
	return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.getAdminEmailId(),admin.getAdminPassword()).orElseThrow(()->new AdminNotFoundException("Admin ", "Id",admin.getAdminEmailId()+"and password "+admin.getAdminPassword() ));
}

}
