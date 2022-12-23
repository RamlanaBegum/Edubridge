package com.example.collegemanagement.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.collegemanagement.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student> findByEmailIDAndPassword(String emailID,String password);
	Optional<Student> findByEmailID(String emailID);
	List<Student> findByStaffStaffId(long staffId);
}
