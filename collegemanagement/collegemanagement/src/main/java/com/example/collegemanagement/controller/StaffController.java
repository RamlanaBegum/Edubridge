package com.example.collegemanagement.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.collegemanagement.model.Staff;
import com.example.collegemanagement.service.StaffService;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/staff")


public class StaffController {
	@Autowired

	private StaffService staffService;

	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
		

		@PostMapping("{courseId}")
		
	public ResponseEntity<Staff>saveStaff( @RequestBody  Staff staff,@PathVariable("courseId") long courseId)
		
	{
		
		System.out.println(staff);
			
		return new ResponseEntity<Staff>(staffService.saveStaff(staff,courseId),HttpStatus.CREATED);
		
	}
		@PostMapping("/login")
		public  ResponseEntity<Staff> loginStaff( @RequestBody Staff staff)
		{
			System.out.println(staff);
		return new ResponseEntity<Staff>(staffService.loginStaff(staff),HttpStatus.CREATED);
			


		}
		
		
		
		@GetMapping("/getAllStaffs")
		public List<Staff> getAllStaff()
		{
			return staffService.getAllStaff();
		}
		
		@GetMapping("/getStaff/{staffId}")
		public ResponseEntity<Staff> getStaffById(@PathVariable("staffId") long staffId)
		{
			return new ResponseEntity<Staff>(staffService.getStaffById(staffId),HttpStatus.OK);
		}
		
		@PutMapping("/updateStaff/{staffId}")
		public ResponseEntity<Staff> updateStaff(@PathVariable("id") long id, @RequestBody Staff staff)
		{
			return new ResponseEntity<Staff> (staffService.updateStaff(staff, id),HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteStaff/{staffId}")
		public ResponseEntity<String> deleteStaff(@PathVariable("staffId") long staffId)
		{
			staffService.deleteStaff(staffId);
			return new ResponseEntity<String>("Staff deleted successfully",HttpStatus.OK);
		}

}

