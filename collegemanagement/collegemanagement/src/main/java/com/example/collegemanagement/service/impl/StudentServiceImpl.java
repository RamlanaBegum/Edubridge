package com.example.collegemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.collegemanagement.exception.ResourceNotFoundException;
import com.example.collegemanagement.model.Course;
import com.example.collegemanagement.model.Staff;
import com.example.collegemanagement.model.Student;
import com.example.collegemanagement.repository.StudentRepository;
import com.example.collegemanagement.service.CourseService;
import com.example.collegemanagement.service.StaffService;
import com.example.collegemanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	private StaffService staffService;
	
	
	public StudentServiceImpl(StudentRepository studentRepository, StaffService staffService) {
		super();
		this.studentRepository = studentRepository;
		this.staffService = staffService;
	}


	@Override
	public Student saveStudent(Student student,long staffId) {
		// TODO Auto-generated method stub
		Staff staff =staffService.getStaffById(staffId);
		student.setStaff(staff);
		return studentRepository.save(student);
	}
	

	@Override
	public Student loginStudent(Student student) {
		// TODO Auto-generated method stub
		return this.studentRepository.findByEmailIDAndPassword(student.emailID,student.password).orElseThrow(()->new ResourceNotFoundException("Student ", "Id",student.emailID+" and password "+student.password ));
	}
	

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}



	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
	}



	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
		Student existingStudent=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setDateOfBirth(student.getDateOfBirth());
		existingStudent.setPhoneNumber(student.getPhoneNumber());
		existingStudent.setDistrict(student.getDistrict());
		existingStudent.setState(student.getState());
		existingStudent.setZipCode(student.getZipCode());
		existingStudent.setEmailID(student.getEmailID());
		existingStudent.setGender(student.getGender());
		existingStudent.setPassword(student.getPassword());
		studentRepository.save(existingStudent);
		return existingStudent;
		
		
	}



	@Override
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub
		studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
		studentRepository.deleteById(id);
		
	}

	
}

