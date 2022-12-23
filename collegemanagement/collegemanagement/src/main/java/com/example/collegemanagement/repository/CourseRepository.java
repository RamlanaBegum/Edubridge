package com.example.collegemanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.collegemanagement.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
}

