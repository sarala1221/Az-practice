package com.azure.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.demo.model.Employee;
import com.azure.demo.repo.DemoRepository;

@Service
public class EmployeeService {

	@Autowired
	private DemoRepository demoRepository;

	public void saveEmployee(Employee emp) {
		demoRepository.save(emp);
	}

	public Employee getEmployee(String name) {
		return demoRepository.findEmployeeByName(name);
	}

}
