package com.example.collegemanagement.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="internalmarks_table")
public class InternalMarks {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name="internalmarks_id")
private  long internalmarksId;

@Column(name="courses_id")
private  long coursesId;



@Column(name="internal_marks1")
private  long internalmarks1;


@Column(name="internal_marks2")
private  long internalmarks2;


@Column(name="internal_marks3")
private  long internalmarks3;

@Column(name="assignment_marks")
private  long assignmentmarks;


@Column(name="total_marks")
private  long totalmarks=internalmarks1+internalmarks2+internalmarks3+assignmentmarks;




@JsonIgnore
@ManyToOne(cascade=CascadeType.ALL) 
@JoinColumn(name="studentId")
private Student student;





public long getInternalmarksId() {
	return internalmarksId;
}





public void setInternalmarksId(long internalmarksId) {
	this.internalmarksId = internalmarksId;
}





public long getCoursesId() {
	return coursesId;
}





public void setCoursesId(long coursesId) {
	this.coursesId = coursesId;
}





public long getInternalmarks1() {
	return internalmarks1;
}





public void setInternalmarks1(long internalmarks1) {
	this.internalmarks1 = internalmarks1;
}





public long getInternalmarks2() {
	return internalmarks2;
}





public void setInternalmarks2(long internalmarks2) {
	this.internalmarks2 = internalmarks2;
}





public long getInternalmarks3() {
	return internalmarks3;
}





public void setInternalmarks3(long internalmarks3) {
	this.internalmarks3 = internalmarks3;
}





public long getAssignmentmarks() {
	return assignmentmarks;
}





public void setAssignmentmarks(long assignmentmarks) {
	this.assignmentmarks = assignmentmarks;
}





public long getTotalmarks() {
	return totalmarks;
}





public void setTotalmarks(long totalmarks) {
	this.totalmarks = totalmarks;
}





public Student getStudent() {
	return student;
}





public void setStudent(Student student) {
	this.student = student;
}






}





