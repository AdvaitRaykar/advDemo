package com.tvlk.advDemo.controller;


import com.tvlk.advDemo.model.DeptEmpDTO;
import com.tvlk.advDemo.model.Employee;
import com.tvlk.advDemo.pojo.EmployeeFilter;
import com.tvlk.advDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/filter", consumes = {"application/json"})
    public List<Employee> getEmployeeByFilter(@Valid @RequestBody EmployeeFilter filter){
        return employeeRepository.findByDesignationAndDeptId(filter.getDesignation(), filter.getDeptId());
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId)
    {
        return employeeRepository.findById(employeeId);
    }

    @PostMapping(consumes = {"application/json"})
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable (value="id") long employeeId,
                                   @Valid @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(employeeId)
                .orElse(new Employee());
        employee.setDeptId(employeeDetails.getDeptId());
        employee.setDesignation(employeeDetails.getDesignation());

        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value="id") long employeeId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElse(new Employee());
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
