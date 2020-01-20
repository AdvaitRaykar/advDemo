package com.example.mongoDemo.Repository;

import com.example.mongoDemo.entity.Department;
import com.example.mongoDemo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, Long> {
}
