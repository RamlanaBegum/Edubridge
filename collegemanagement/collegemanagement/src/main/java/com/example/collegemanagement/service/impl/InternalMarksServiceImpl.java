package com.example.collegemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.collegemanagement.exception.ResourceNotFoundException;
import com.example.collegemanagement.model.InternalMarks;
import com.example.collegemanagement.model.Staff;
import com.example.collegemanagement.model.Student;
import com.example.collegemanagement.repository.InternalMarksRepository;
import com.example.collegemanagement.service.InternalMarksService;
import com.example.collegemanagement.service.StaffService;
import com.example.collegemanagement.service.StudentService;
@Service
public class InternalMarksServiceImpl implements InternalMarksService{
	
	private InternalMarksRepository internalmarksRepository;
	private StudentService studentService;
	
	public InternalMarksServiceImpl(InternalMarksRepository internalmarksRepository, StudentService studentService) {
		super();
		this.internalmarksRepository = internalmarksRepository;
		this.studentService = studentService;
	}

	@Override
	public InternalMarks saveInternalMarks(InternalMarks internalMarks, long id) {
		// TODO Auto-generated method stub
		Student student =studentService.getStudentById(id);
		internalMarks.setStudent(student);
		return internalmarksRepository.save(internalMarks);
	}

	@Override
	public List<InternalMarks> getAllInternalMarks() {
		// TODO Auto-generated method stub
		return internalmarksRepository.findAll();
	}

	@Override
	public InternalMarks getInternalMarksById(long id) {
		// TODO Auto-generated method stub
		return internalmarksRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("InternalMarks","Id",id)); 
	}

	@Override
	public InternalMarks updateInternalMarks(InternalMarks internalMarks, long id) {
		// TODO Auto-generated method stub
         InternalMarks existingInternalMarks=internalmarksRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("InternalMarks","Id",id));
		existingInternalMarks.setInternalmarksId(internalMarks.getInternalmarksId());
		existingInternalMarks.setCoursesId(internalMarks.getCoursesId());
		existingInternalMarks.setInternalmarks1(internalMarks.getInternalmarks1());
		existingInternalMarks.setInternalmarks2(internalMarks.getInternalmarks2());
		existingInternalMarks.setInternalmarks3(internalMarks.getInternalmarks3());
		existingInternalMarks.setAssignmentmarks(internalMarks.getAssignmentmarks());
		existingInternalMarks.setTotalmarks(internalMarks.getTotalmarks());
		internalmarksRepository.save(existingInternalMarks);
		return existingInternalMarks;
	}

	@Override
	public void deleteInternalMarks(long id) {
		// TODO Auto-generated method stub
		internalmarksRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("InternalMarks","Id",id));
		internalmarksRepository.deleteById(id);
		
	}

	

	


	}
	
	
	
	
	