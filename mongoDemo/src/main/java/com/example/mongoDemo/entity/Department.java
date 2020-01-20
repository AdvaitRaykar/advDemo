package com.example.mongoDemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection="Departments")
public class Department implements Serializable {
    private long id;
    private String deptName;
    private String deptHead;
    private long budget;



    public Department(){

    }

    public Department(long id, String deptName, String deptHead, long budget)
    {
        this.id = id;
        this.deptHead = deptHead;
        this.deptName = deptName;
        this.budget = budget;
    }

    @Id
    public long getId() {return id;}
    public void setId(long id) {this.id = id; }


    public String getDeptName(){return deptName;}
    public void setDeptName(String deptName){this.deptName = deptName; }

    public String getDeptHead(){return deptHead; }
    public void setDeptHead(String deptHead){this.deptHead = deptHead; }

    public long getBudget(){return budget;}
    public void setBudget(long budget){this.budget = budget; }

}