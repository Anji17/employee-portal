package com.test.employee.service;

import com.test.employee.dto.EmployeeDTO;
import com.test.employee.entity.Employee;

public interface EmployeeService {
	public EmployeeDTO register(Employee request);
	public EmployeeDTO getEmployees();

}
