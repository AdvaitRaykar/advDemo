package com.tvlk.advDemo.controller;

import com.tvlk.advDemo.model.Department;
import com.tvlk.advDemo.model.DeptEmpDTO;
import com.tvlk.advDemo.model.Employee;
import com.tvlk.advDemo.repository.DepartmentRepository;
import com.tvlk.advDemo.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.models.media.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "DepartmentController", description="REST APIs related to the Department Entity")
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @ApiOperation(value = "Create a new department entity.")
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

//    @GetMapping("/{id}/employees")
//    public List<DeptEmpDTO> getEmployeesByDept(@PathVariable(value="id") long deptId){
//        return departmentRepository.fetchEmpDeptDataLeftJoin();
//    }

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

    @GetMapping(value = "/{id}/employees", consumes = {"application/json"})
    public List<DeptEmpDTO> getEmployeesFromDept(@PathVariable (value = "id") long deptId){
//        return departmentRepository.findById(deptId).get().getEmployees();
        return departmentRepository.join();
    }
}
