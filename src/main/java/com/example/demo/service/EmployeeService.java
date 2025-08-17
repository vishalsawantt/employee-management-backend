package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	Employee getOneEmployee(Long employeeId);
	List<Employee> getAllEmployee();
	Employee updateEmployee(Long employeeId,Employee updatedEmployee);
	boolean deleteEmployee(Long employeeId);
	Page<Employee> getPaginatedEmployee(Pageable pageable);
	
	List<Employee> findByEmployeeDept(String employeeDept);
	List<Employee> findByDeptAndName(@Param("dept") String dept,@Param("name") String name);
}
