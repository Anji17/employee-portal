package com.test.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.employee.dto.EmployeeDTO;
import com.test.employee.entity.Employee;
import com.test.employee.repository.EmployeeRepository;
import com.test.employee.util.Constants;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repository;

	@Override
	public EmployeeDTO register(Employee request) {
		Employee result =null;
		try {
			result = repository.save(request);
		}
		catch(Exception e) {
			return new EmployeeDTO(result, -1, Constants.FAILURE+" : "+e.getMessage());
		}
		return new EmployeeDTO(result, 0, Constants.SUCCESS);
	}

	@Override
	public EmployeeDTO getEmployees() {
		List<Employee> data=new ArrayList<>();
		try {
			data=repository.sortByFirstName();
		}
		catch(Exception e) {
			return new EmployeeDTO(data, -1, Constants.FAILURE+" : "+e.getMessage());
		}
		return new EmployeeDTO(data, 0, Constants.SUCCESS);
	}

}
