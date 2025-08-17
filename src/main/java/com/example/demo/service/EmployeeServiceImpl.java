package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeFamily;
import com.example.demo.repository.EmployeeFamilyRepository;
import com.example.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeFamilyRepository employeeFamilyRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		List<EmployeeFamily> employeeFamily = employee.getEmployeeFamily();
		if(employeeFamily!=null) {
			for(EmployeeFamily family:employeeFamily) {
				family.setEmployee(savedEmployee);
				employeeFamilyRepository.save(family);
			}
		}
		return savedEmployee;
	}

	@Override
	public Employee getOneEmployee(Long employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee Id " + employeeId + " Is Not Found"));
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
		Employee exitingEmployee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Cannot Update!!! Employee Not Found"));
		if(exitingEmployee!=null) {
			exitingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
			exitingEmployee.setEmployeeDept(updatedEmployee.getEmployeeDept());
			exitingEmployee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
			employeeRepository.save(exitingEmployee);
		}
		
		List<EmployeeFamily> retriveList = updatedEmployee.getEmployeeFamily();
		if(retriveList!=null) {
			for(EmployeeFamily memberList:retriveList) {
				memberList.setEmployee(exitingEmployee);
				
				if(memberList.getFamilyId()!=null) {
					EmployeeFamily eEmployeeFamily = employeeFamilyRepository
							.findById(memberList.getFamilyId())
							.orElse(null);
					if(eEmployeeFamily!=null) {
						eEmployeeFamily.setFamilyMemberName(memberList.getFamilyMemberName());
						eEmployeeFamily.setFamilyRelation(memberList.getFamilyRelation());
						eEmployeeFamily.setFamilyMemberAge(memberList.getFamilyMemberAge());
						employeeFamilyRepository.save(eEmployeeFamily);
						continue;
					}else {
						employeeFamilyRepository.save(memberList);
					}
				}else {
					employeeFamilyRepository.save(memberList);
				}
			}
		}
		return exitingEmployee;
	}

	@Override
	public boolean deleteEmployee(Long employeeId) {
		Employee dEmployee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Wrong Id!!! Employee Number " + employeeId + " Not Exist In Database"));
			employeeRepository.deleteById(employeeId);
			return true;
	}

	@Override
	public Page<Employee> getPaginatedEmployee(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	@Override
	public List<Employee> findByEmployeeDept(String employeeDept) {
		List<Employee> dEmployee= employeeRepository.findByEmployeeDept(employeeDept);
		if(dEmployee!=null && dEmployee.isEmpty()) {
			throw new ResourceNotFoundException(employeeDept + " Department Employees Not Found");
		}else {
			return dEmployee;
		}
	}

	@Override
	public List<Employee> findByDeptAndName(String dept, String name) {
		return employeeRepository.findByDeptAndName(dept, name);
	}	
}
