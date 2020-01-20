package com.example.mongoDemo.Controller;

import com.example.mongoDemo.Repository.DepartmentRepository;
import com.example.mongoDemo.Repository.EmployeeRepository;
import com.example.mongoDemo.entity.Department;
import com.example.mongoDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @PostMapping(consumes = {"application/json"})
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping(produces = {"application/json"})
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public Optional<Department> getDepartmentById(@PathVariable(value = "id") long deptId){
        return departmentRepository.findById(deptId);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDept(@PathVariable(value="id") long deptId){
        return employeeRepository.findByDeptId(deptId);
    }

    @PutMapping(value = "/{id}/head", consumes = {"application/json"})
    public Department updateDepartmentHead(@PathVariable (value="id") long deptId,
                                           @Valid @RequestBody Department departmentDetails){


        Department department = departmentRepository.findById(deptId)
                .orElse(new Department());
        department.setDeptHead(departmentDetails.getDeptHead());
        return departmentRepository.save(department);
    }

    @PutMapping(value = "/{id}/budget", consumes = {"application/json"})
    public Department updateDepartmentBudget(@PathVariable (value="id") long deptId,
                                             @Valid @RequestBody Department departmentDetails){
        Department department = departmentRepository.findById(deptId)
                .orElse(new Department());
        department.setBudget(departmentDetails.getBudget());
        return departmentRepository.save(department);
    }

}
