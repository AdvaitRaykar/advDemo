package com.example.mongoDemo.Controller;

import com.example.mongoDemo.Repository.DepartmentRepository;
import com.example.mongoDemo.Repository.EmployeeAggregateRepository;
import com.example.mongoDemo.Repository.EmployeeRepository;
import com.example.mongoDemo.entity.Department;
import com.example.mongoDemo.entity.Employee;
import com.example.mongoDemo.entity.EmployeeAggregate;
import com.example.mongoDemo.pojo.EmployeeFilter;
import com.mongodb.MongoClient;
import com.mongodb.session.ClientSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeAggregateRepository employeeAggregateRepository;

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

    @Transactional(rollbackFor = NullPointerException.class)
    @PostMapping(consumes = {"application/json"})
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        Optional<Department> departmentOptional = departmentRepository.findById(employee.getDeptId());
        MongoClient client = new MongoClient();
        ClientSession session = client.startSession();
        EmployeeAggregate employeeAggregate = employeeAggregateRepository.findAll().get(0);
        employeeAggregate.setTotalEmployeeCount(employeeAggregate.getTotalEmployeeCount()+1);
        employeeAggregateRepository.save(employeeAggregate);
        if(departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            return employeeRepository.save(employee);
        }
        else{
            throw new NullPointerException();
        }
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
