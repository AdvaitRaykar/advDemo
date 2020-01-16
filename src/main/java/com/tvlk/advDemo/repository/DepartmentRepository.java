package com.tvlk.advDemo.repository;

import com.tvlk.advDemo.model.Department;
import com.tvlk.advDemo.model.DeptEmpDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DepartmentRepository extends JpaRepository <Department, Long> {

    @Query("SELECT new com.tvlk.advDemo.model.DeptEmpDTO(e.id, e.name, e.designation, d.deptName) FROM Department d join d.employees e")
    public List<DeptEmpDTO> join();
}
