package com.tvlk.advDemo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.atomic.AtomicInteger;

@Document(collection = "Employees")
public class EmployeeNoSQL {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private long id = counter.getAndIncrement();
    private String name;
    private String designation;




    public EmployeeNoSQL(String name, String designation, long deptId) {
        this.name = name;
        this.designation = designation;
        this.deptId = deptId;
    }

    public EmployeeNoSQL() {
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

