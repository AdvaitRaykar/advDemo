package com.example.mongoDemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.atomic.AtomicInteger;


@Document(collection = "Employees")
public class Employee {
    private static final AtomicInteger counter = new AtomicInteger(0);
    @Id
    private long id = counter.getAndIncrement();
    private String name;
    private String designation;




    public Employee(String name, String designation, long deptId) {
        this.name = name;
        this.designation = designation;
        this.deptId = deptId;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    private long deptId;
}
