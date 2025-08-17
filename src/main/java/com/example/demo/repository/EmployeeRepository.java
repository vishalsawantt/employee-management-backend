package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByEmployeeDept(String employeeDept);
	
	@Query(value = "select * from employee where employee_dept = :dept and employee_name = :name", nativeQuery = true)
	List<Employee> findByDeptAndName(@Param("dept") String dept, @Param("name") String name);

}
