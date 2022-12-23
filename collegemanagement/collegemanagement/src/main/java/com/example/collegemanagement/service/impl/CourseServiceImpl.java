package com.example.collegemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegemanagement.exception.ResourceNotFoundException;
import com.example.collegemanagement.model.Course;
import com.example.collegemanagement.repository.CourseRepository;
import com.example.collegemanagement.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(long id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course","Id",id)); 
	}

	@Override
	public Course updateCourse(Course course, long id) {
		// TODO Auto-generated method stub
		 Course existingCourse=courseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Course","Id",id));
			
		 existingCourse.setCourseName(course.getCourseName());
			existingCourse.setCourseType(course.getCourseType());
			existingCourse.setStartDate(course.getStartDate());
			existingCourse.setEndDate(course.getEndDate());
			courseRepository.save(existingCourse);
			return existingCourse;
		}

	@Override
	public void deletecourse(long id) {
		// TODO Auto-generated method stub
		courseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Course","Id",id));
		courseRepository.deleteById(id);
		
}

	@Override
	public List<Course> getAllcourse() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	}