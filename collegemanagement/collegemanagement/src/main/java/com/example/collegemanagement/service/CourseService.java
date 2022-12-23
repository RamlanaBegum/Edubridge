package com.example.collegemanagement.service;

import java.util.List;

import com.example.collegemanagement.model.Course;

public interface CourseService {
	Course saveCourse(Course course);
	List<Course> getAllCourse();
	Course getCourseById(long id);
	Course updateCourse(Course course, long id);
	void deletecourse(long id);
	List<Course> getAllcourse();
}

