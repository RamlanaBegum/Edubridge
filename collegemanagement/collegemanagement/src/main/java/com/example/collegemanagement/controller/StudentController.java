package com.example.collegemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegemanagement.service.StudentService;
import com.example.collegemanagement.model.Student;

@RestController 
@CrossOrigin(origins="*")
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@PostMapping("{staffId}")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student,@PathVariable("staffId") long staffId)
	{
		System.out.println(student);
		return new ResponseEntity<Student>(studentService.saveStudent(student,staffId),HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<Student> loginStudent(@RequestBody Student student)
	{
		System.out.println(student);
		return new ResponseEntity<Student>(studentService.loginStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	@GetMapping("/getStudents/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId)
	{
		return new ResponseEntity<Student>(studentService.getStudentById(studentId),HttpStatus.OK);
	}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student)
	{
		return new ResponseEntity<Student> (studentService.updateStudent(student, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id)
	{
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
	}
}