package com.tvlk.advDemo.model;

import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;

@Entity
@Table(name="employees")
public class Employee implements Serializable {
    private long id;
    private String name;
    private String designation;
    private long deptId;
//    private Department department;

    public Employee() {

    }

    public Employee(String name, String designation, long deptId) {
        this.name = name;
        this.designation = designation;
        this.deptId = deptId;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "designation", nullable = false)
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Column(name = "dept_id", nullable = false)
    public long getDeptId() {
        return deptId;
    }
    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    public void setDepartment(Department department){
//        this.department = department;
//    }
//
//    @JoinColumn(name = "department", nullable = false)
//    public Department getDepartment() {
//        return department;
//    }


    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", deptId=" + deptId
                + "]";
    }
}
