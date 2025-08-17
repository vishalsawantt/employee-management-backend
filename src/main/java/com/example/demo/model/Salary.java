package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_id")
	private Long salaryId;
	@Column(name = "total_amount")
    private double amount;
	
	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", amount=" + amount + ", employee=" + employee + "]";
	}
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	@JsonBackReference
	private Employee employee;
	
	public Long getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
