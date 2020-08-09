package com.azure.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azure.demo.model.Employee;
import com.azure.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/message")
	public ResponseEntity<String> getMessage() {
		return new ResponseEntity<>("Welcome to Azure World!!", HttpStatus.OK);
	}

	@GetMapping(path = "/employee")
	public ResponseEntity<Employee> getEmployeeByName(@RequestParam String name) {
		return new ResponseEntity<>(employeeService.getEmployee(name), HttpStatus.OK);
	}

	@PostMapping(path = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
