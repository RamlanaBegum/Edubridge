package com.example.collegemanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.collegemanagement.model.InternalMarks;
import com.example.collegemanagement.model.Student;

@Repository
public interface InternalMarksRepository extends JpaRepository<InternalMarks, Long>{
	
	List<InternalMarks> findByStudentId(long id );
}