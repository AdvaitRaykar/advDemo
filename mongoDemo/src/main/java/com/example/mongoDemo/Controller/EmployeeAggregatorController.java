package com.example.mongoDemo.Controller;

import com.example.mongoDemo.Repository.EmployeeAggregateRepository;
import com.example.mongoDemo.Repository.EmployeeRepository;
import com.example.mongoDemo.entity.Department;
import com.example.mongoDemo.entity.EmployeeAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/updateCount")
public class EmployeeAggregatorController {

    @Autowired
    EmployeeAggregateRepository employeeAggregateRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public long updateCount() {
        long count = employeeRepository.count();

        return count;
    }
}
