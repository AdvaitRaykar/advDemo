package com.tvlk.advDemo.pojo;

public class EmployeeFilter {
    private String designation;
    private long deptId;

    public EmployeeFilter(String designation, long deptId) {
        this.designation = designation;
        this.deptId = deptId;
    }

    public EmployeeFilter(String designation) {
        this.designation = designation;
    }

    public EmployeeFilter(long deptId) {
        this.deptId = deptId;
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
}
