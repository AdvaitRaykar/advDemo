package com.example.mongoDemo.Repository;

import com.example.mongoDemo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
    public List<Employee> findByDesignationAndDeptId(String Designation, long deptId);
    public List<Employee> findByDeptId(long deptId);
}
