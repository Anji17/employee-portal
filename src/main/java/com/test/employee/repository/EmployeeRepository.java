package com.test.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("select e from Employee e order by firstName")
	public List<Employee> sortByFirstName();

}
