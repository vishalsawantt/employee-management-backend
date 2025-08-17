package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Salary;

public interface SalaryService {
	Salary addSalary(Long employeeId,Salary salary);
	List<Salary> allSalary();
	Salary getSalaryByEmployeeId(Long employeeId);
	Salary updateSalary(Long employeeId,Salary updateSalary);
	boolean deleteSalary(Long salaryId);
}
