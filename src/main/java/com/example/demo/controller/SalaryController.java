package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Salary;
import com.example.demo.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {
	@Autowired
	private SalaryService salaryService;
	
	@PostMapping("/{employeeId}")
	public ResponseEntity<String> addSalary(@PathVariable Long employeeId,@RequestBody Salary salary){
		salaryService.addSalary(employeeId,salary);
		return ResponseEntity.status(201).body("Salary Insert Successfully");
	}	
	
	@GetMapping
	public ResponseEntity<List<Salary>> displayAllSalarys(){
		List<Salary> list = salaryService.allSalary();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Salary> displayOneSalary(@PathVariable Long employeeId){
		Salary eSalary = salaryService.getSalaryByEmployeeId(employeeId);
		return ResponseEntity.ok().body(eSalary);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<String> updateSalary(@PathVariable Long employeeId,@RequestBody Salary uSalary){
		Salary nSalary = salaryService.updateSalary(employeeId, uSalary);
		return ResponseEntity.ok().body("Salary Update Successfully");
	}
	
	@DeleteMapping("/{salaryId}")
	public ResponseEntity<String> deleteSalary(@PathVariable Long salaryId){
		boolean dSalary = salaryService.deleteSalary(salaryId);
		return ResponseEntity.ok().body("Salary Deleted sucessfully");
	}
}
