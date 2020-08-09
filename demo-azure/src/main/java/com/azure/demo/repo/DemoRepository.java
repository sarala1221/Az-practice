package com.azure.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.azure.demo.model.Employee;

@Repository
public interface DemoRepository extends MongoRepository<Employee, String> {

	public Employee findEmployeeByName(String name);
}
