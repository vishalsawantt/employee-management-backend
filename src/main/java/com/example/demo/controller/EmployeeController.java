package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final SalaryController salaryController;

	@Autowired
	private EmployeeService employeeService;

    EmployeeController(SalaryController salaryController) {
        this.salaryController = salaryController;
    }

	@PostMapping
	public ResponseEntity<String> insertEmployee(@RequestBody Employee newEmployee){
		Employee employee = employeeService.saveEmployee(newEmployee);
		return ResponseEntity.status(201).body("insert successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> displayAllEmployee(){
		List<Employee> list = employeeService.getAllEmployee();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/singleEmployee/{employeeId}")
	public ResponseEntity<Employee> oneEmployee(@PathVariable Long employeeId){
		Employee sEmployee = employeeService.getOneEmployee(employeeId);
		return ResponseEntity.ok(sEmployee);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee updatedEmployee){
		Employee eEmployee = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok().body("Update Sucessfully");
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
		boolean isDeleted = employeeService.deleteEmployee(employeeId);
		if(isDeleted) {
			return ResponseEntity.ok().body(employeeId + " Deleted Sucessfully");
		}else {
			return ResponseEntity.ok().body(employeeId + " Not Found");
		}
	}
	
	@GetMapping("/employeeInPages")
	public ResponseEntity<Page<Employee>> getEmployeeInPages(
			@RequestParam (defaultValue = "0") int page,
	        @RequestParam (defaultValue = "3") int size){
	        	PageRequest pageable = PageRequest.of(page,size);
	        	Page<Employee> list = employeeService.getPaginatedEmployee(pageable);
	        	return ResponseEntity.ok().body(list);
	        }
	
	@GetMapping("/findByDept/{employeeDept}")
	public ResponseEntity<List<Employee>> getEmployeeByDept(@PathVariable String employeeDept){
		List<Employee> dEmployee = employeeService.findByEmployeeDept(employeeDept);
		return ResponseEntity.ok().body(dEmployee);
	}
	
	@GetMapping("/findByDeptAndName/{employeeDept}/{employeeName}")
	public ResponseEntity<List<Employee>> getEmployeeByDeptAndName(@PathVariable String employeeDept,@PathVariable String employeeName){
		List<Employee> list = employeeService.findByDeptAndName(employeeDept, employeeName);
		return ResponseEntity.ok().body(list);
	}
}
