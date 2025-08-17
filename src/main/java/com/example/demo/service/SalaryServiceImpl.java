package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Salary;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SalaryRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService{
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Salary addSalary(Long employeeId, Salary salary) {
		Employee eEmployee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Id Not Found"));
		salary.setEmployee(eEmployee);
		return salaryRepository.save(salary);
	}

	@Override
	public List<Salary> allSalary() {
		return salaryRepository.findAll();
	}

	@Override
	public Salary getSalaryByEmployeeId(Long employeeId) {
		Salary eSalary = salaryRepository.findByEmployeeEmployeeId(employeeId);
		if(eSalary==null) {
			throw new ResourceNotFoundException("Incorrect Employee Id");
		}else {
			return eSalary;
		}
	}

	@Override
	public Salary updateSalary(Long employeeId, Salary updateSalary) {
		Salary uSalary = salaryRepository.findByEmployeeEmployeeId(employeeId);
		if(uSalary==null) {
			throw new ResourceNotFoundException("Cannot Updat Salary! Employee Not Found");
		}else {
			uSalary.setAmount(updateSalary.getAmount());
			salaryRepository.save(uSalary);
			return uSalary;
		}
	}

	@Override
	public boolean deleteSalary(Long salaryId) {
	    Salary dSalary = salaryRepository.findById(salaryId).orElseThrow(() -> new ResourceNotFoundException("Not Deleted! Salary Not Found"));
	    Employee employee = dSalary.getEmployee();
	    if (employee != null) {
	        employee.setSalary(null); // unlink from employee side
	    }
	    salaryRepository.deleteById(salaryId); //here first original amount set null then deleted.
	    return true;
	}
}
