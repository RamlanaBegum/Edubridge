package com.example.collegemanagement.service;
import java.util.List;

import com.example.collegemanagement.model.Student;

public interface StudentService {
	Student saveStudent(Student student,long staffId);
	Student loginStudent(Student student);
	Student getStudentById(long id);
	Student updateStudent(Student student, long id);
	void deleteStudent(long id);
	List<Student> getAllStudents();

}
