package com.test.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.employee.dto.EmployeeDTO;
import com.test.employee.entity.Employee;
import com.test.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDTO register(@RequestBody Employee request) {
		return service.register(request);
	}

	@GetMapping(path = "/getAll",produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDTO getEmployees() {
		return service.getEmployees();
	}

}
