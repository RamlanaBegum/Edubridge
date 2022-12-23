package com.example.collegemanagement.service;

import java.util.List;
import com.example.collegemanagement.model.Staff;



	public interface StaffService {
		Staff saveStaff(Staff staff,long courseId);
		Staff loginStaff(Staff staff);
		List<Staff> getAllStaff();
		Staff getStaffById(long staffId);
		Staff updateStaff(Staff staff, long staffId);
		void deleteStaff(long staffId);

	}




