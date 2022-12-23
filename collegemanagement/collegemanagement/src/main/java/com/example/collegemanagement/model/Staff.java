package com.example.collegemanagement.model;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
	@Table(name = "STAFF_Table")

	public class Staff {

		@Id
		
		
		
	@Column(name="Staff_ID")
	  
	  private long staffId;
		
		@Column(name="Staff_FirstName")
		
		private String firstName;
		@Column(name="Staff_LastName")

		private String lastName;
			
		@Column(name="Email_ID")
			
		public String emailID ;
		@Column(name="Staff_Password")

		public String password;

	@Column(name="DEPARTMENT")
	  
	  private String department;
	@Column(name="SALARY")
	  
	  private double salary;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL) 
	  @JoinColumn(name="courseId")
	 private Course course;
	@JsonIgnore
@OneToOne(mappedBy="staff" , cascade=CascadeType.ALL)
private Student student;

	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
		
	
}
