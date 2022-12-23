package com.example.collegemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegemanagement.exception.ResourceNotFoundException;
import com.example.collegemanagement.model.Course;
import com.example.collegemanagement.model.Staff;
import com.example.collegemanagement.repository.StaffRepository;
import com.example.collegemanagement.service.CourseService;
import com.example.collegemanagement.service.StaffService;

@Service

public class StaffServiceImpl implements StaffService {
	@Autowired    
     
private  StaffRepository staffRepository;
	private CourseService courseService;


	
public StaffServiceImpl(StaffRepository staffRepository, CourseService courseService) {
		super();
		this.staffRepository = staffRepository;
		this.courseService = courseService;
	}



@Override
	
public Staff saveStaff(Staff staff,long courseId) {
	
	// TODO Auto-generated method stub
	Course course =courseService.getCourseById(courseId);
	staff.setCourse(course);
	return staffRepository.save(staff);
}



@Override
public Staff loginStaff(Staff staff) {
	// TODO Auto-generated method stub
	return this.staffRepository.findByEmailIDAndPassword(staff.emailID,staff.password).orElseThrow(()->new ResourceNotFoundException("Staff ", "Id",staff.emailID+" and password "+staff.password ));
}

@Override
public List<Staff> getAllStaff() {
	// TODO Auto-generated method stub
	return staffRepository.findAll();
}


@Override
public Staff getStaffById(long id) {
	// TODO Auto-generated method stub
	return staffRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff","Id",id));
}


@Override
public Staff updateStaff(Staff staff, long id) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void deleteStaff(long id) {
	// TODO Auto-generated method stub
	staffRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff","Id",id));
	staffRepository.deleteById(id);
	
}



	


}
