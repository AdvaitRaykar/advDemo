package com.tvlk.advDemo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="departments")
public class Department implements Serializable {
    private long id;
    private String deptName;
    private String deptHead;
    private long budget;
    private List<Employee> employees;


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

    @Column(name = "name", nullable = false)
    public String getDeptName(){return deptName;}
    public void setDeptName(String deptName){this.deptName = deptName; }

    @Column(name = "deptHead", nullable = false)
    public String getDeptHead(){return deptHead; }
    public void setDeptHead(String deptHead){this.deptHead = deptHead; }

    @Column(name = "budget", nullable = false)
    public long getBudget(){return budget;}
    public void setBudget(long budget){this.budget = budget; }

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
