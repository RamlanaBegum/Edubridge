package com.example.collegemanagement.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.collegemanagement.model.Course;
import com.example.collegemanagement.service.CourseService;

@RestController 
@CrossOrigin(origins="*")
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	@PostMapping("/register")
	public ResponseEntity<Course> saveStudent( @RequestBody Course course)
	{
		System.out.println(course);
		return new ResponseEntity<Course>(courseService.saveCourse(course),HttpStatus.CREATED);
	}
	@GetMapping("/getAllcourses")
	public List<Course> getAllCourse()
	{
		return courseService.getAllCourse();
	}
	@GetMapping("/getCourses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") long courseId)
	{
		return new ResponseEntity<Course>(courseService.getCourseById(courseId),HttpStatus.OK);
	}
	@PutMapping("/updateCourse{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course)
	{
		return new ResponseEntity<Course> (courseService.updateCourse(course, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("id") long id)
	{
		courseService.deletecourse(id);
		return new ResponseEntity<String>("Course deleted successfully",HttpStatus.OK);
	}
}
