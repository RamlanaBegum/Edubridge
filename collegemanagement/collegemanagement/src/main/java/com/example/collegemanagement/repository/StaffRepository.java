package com.example.collegemanagement.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.collegemanagement.model.Staff;


@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {

	Optional<Staff> findByEmailIDAndPassword(String emailID, String password);
	List<Staff>findByCourseCourseId(long courseId);
}


