package com.example.collegemanagement.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="courses_table")
public class Course {

@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private long courseId;

@Column(name="courses_name")
	private String courseName;

@Column(name="courses_type")
	private String courseType;

@Column(name="start_date")
	private String startDate;
	
@Column(name="end_date")
	private String endDate;
@JsonIgnore
@OneToMany(mappedBy="course" , cascade=CascadeType.ALL)
private List<Staff> staff;

public long getCourseId() {
	return courseId;
}


public void setCourseId(long courseId) {
	this.courseId = courseId;
}


public String getCourseName() {
	return courseName;
}


public void setCourseName(String courseName) {
	this.courseName = courseName;
}


public String getCourseType() {
	return courseType;
}


public void setCourseType(String courseType) {
	this.courseType = courseType;
}


public String getStartDate() {
	return startDate;
}


public void setStartDate(String startDate) {
	this.startDate = startDate;
}


public String getEndDate() {
	return endDate;
}


public void setEndDate(String endDate) {
	this.endDate = endDate;
}


public List<Staff> getStaff() {
	return staff;
}


public void setStaff(List<Staff> staff) {
	this.staff = staff;
}


public Course(long courseId, String courseName, String courseType, String startDate, String endDate) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.courseType = courseType;
	this.startDate = startDate;
	this.endDate = endDate;
}


public Course() {
	super();
	// TODO Auto-generated constructor stub
}




}
	
	
		
	
		

