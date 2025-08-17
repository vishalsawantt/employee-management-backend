package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name = "employee_dept")
	private String employeeDept;
	@Column(name = "employee_email")
	private String employeeEmail;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<EmployeeFamily> employeeFamily = new ArrayList<>();
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference 
	private Salary salary;

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDept="
				+ employeeDept + ", employeeEmail=" + employeeEmail + ", employeeFamily=" + employeeFamily + "]";
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDept() {
		return employeeDept;
	}

	public void setEmployeeDept(String employeeDept) {
		this.employeeDept = employeeDept;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public List<EmployeeFamily> getEmployeeFamily() {
		return employeeFamily;
	}

	public void setEmployeeFamily(List<EmployeeFamily> employeeFamily) {
		this.employeeFamily = employeeFamily;
	}
}

