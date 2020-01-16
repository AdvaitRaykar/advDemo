package com.tvlk.advDemo.repository;

import com.tvlk.advDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Predicate;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByDesignationAndDeptId(String Designation, long deptId);
}
