package EmployeeManagementSystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeService {
HashSet<Employee> empset = new HashSet<Employee>();
	
	Employee emp1 = new Employee(101, "Ramlana", 24, "Developer", "IT", 75000);
	Employee emp2 = new Employee(102, "Subha", 26, "Tester", "CO", 35000);
	Employee emp3 = new Employee(103, "Savitha", 22, "DevOps Eng", "Admin", 55000);
	Employee emp4 = new Employee(104, "Sriranjani", 28, "System Eng", "CO", 45000);
	
	Scanner scanner = new Scanner(System.in);
	
	int id;
	String name;
	int age;
	String designation;
	String department;
	double salary;

	private boolean found;
	
	public EmployeeService() {
		
		empset.add(emp1);
		empset.add(emp2);
		empset.add(emp3);
		empset.add(emp4);
		
	}
	
	//view all employees
	public void viewAllEmps() {
		for(Employee emp:empset) {
			System.out.println(emp);
			
		}
	}
	
	//view emp based on there ID
	public void viewEmp() {
		boolean found = false;
		System.out.println("\nEnter Id: ");
		id = scanner.nextInt();
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				System.out.println(emp);
				found=true;
			}
		}
		if(!found) {
			System.out.println("\nEmployee With this id is not present");
		}
	}
	
	//update the employee
	public void updateEmployee() {
		System.out.println("\nEnter Id: ");   
		id=scanner.nextInt();
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				System.out.println("\nEnter Name: ");
				name = scanner.next();
				System.out.println("\nEnter New Salary");
				salary = scanner.nextDouble();
				emp.setName(name);
				emp.setSalary(salary);
				System.out.println("\nUpdated Deatils Of Employee are: ");
				System.out.println(emp);
				found=true;
			}
		}
		if(!found) {
			System.out.println("\nEmployee is not Present");
		}
		else {
			System.out.println("\nEmployee Details Updated Successfully!!");
		}
	}
	
	//Delete Emp
	public void deleteEmp() {
		System.out.println("\nEnter Id: ");
		id = scanner.nextInt();
		Employee empdelete=null;
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				empdelete=emp;
				found=true;
			}
		}
		if(!found) {
			System.out.println("\nEmployee is not Present");
		}
		else {
			empset.remove(empdelete);
			System.out.println("\nEmployee Deatils Deleted Successfully!!");
		}
			
	}
	//Add Emp
	public void addEmp() {
		System.out.println("Enter Id: ");
		id=scanner.nextInt();
		System.out.println("\nEnter Name: ");
		name = scanner.next();
		System.out.println("\nEnter Age: ");
		age = scanner.nextInt();
		System.out.println("\nEnter Designation: ");
		designation = scanner.next();
		System.out.println("\nEnter Department: ");
		department = scanner.next();
		System.out.println("\nEnter Salary: ");
		salary = scanner.nextDouble();
		
		Employee emp = new Employee(id, name, age, designation, department, salary);
		empset.add(emp);
		System.out.println(emp);
		System.out.println("\nEmployee Details Added Successfully!!");
	}

}
