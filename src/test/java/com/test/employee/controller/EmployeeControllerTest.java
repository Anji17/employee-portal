package com.test.employee.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.test.employee.dto.EmployeeDTO;
import com.test.employee.entity.Employee;
import com.test.employee.service.EmployeeService;
import com.test.employee.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController controller;
	@Mock
	EmployeeService service;
	
	private EmployeeDTO employeeDTO;
	private EmployeeDTO employeeDTOList;
	private Employee employeeMock;
	@Before
	public void init() {
		
		employeeMock=new Employee();
		employeeMock.setFirstName("Anjali");
		employeeMock.setLastName("Grover");
		employeeMock.setGender("female");
		employeeMock.setDepartment("IT");
		employeeMock.setId(101);
		employeeMock.setDob(new Date());
		employeeDTO=new EmployeeDTO(employeeMock, 0, Constants.SUCCESS);
		
		List<Employee> list=new ArrayList<>();
		Employee e=new Employee();
		e.setFirstName("Anjali");
		e.setLastName("Grover");
		e.setGender("female");
		e.setDepartment("IT");
		e.setDob(new Date());
		e.setId(101);
		Employee e1=new Employee();
		e1.setFirstName("Smriti");
		e1.setLastName("Awasthy");
		e1.setGender("female");
		e1.setDepartment("IT");
		e1.setDob(new Date());
		e1.setId(101);
		list.add(e);
		list.add(e1);
		employeeDTOList=new EmployeeDTO(list, 0, Constants.SUCCESS);
		
	}

	@Test
	public void registerTest() {
		when(service.register(Mockito.any(Employee.class))).thenReturn(employeeDTO);
		EmployeeDTO response=service.register(employeeMock);
		verify(service, times(1)).register(employeeMock);
		assertNotNull(response.getData());
		assertEquals(Constants.SUCCESS, response.getStatusMessage());	
		assertEquals(0, response.getStatusCode());	
	}
	
	@Test
	public void getEmployeesTest() {
		when(service.getEmployees()).thenReturn(employeeDTOList);
		EmployeeDTO response=service.getEmployees();
		verify(service, times(1)).getEmployees();
		assertNotNull(response.getData());
		assertEquals(Constants.SUCCESS, response.getStatusMessage());	
		assertEquals(0, response.getStatusCode());
	}

}
