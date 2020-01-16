package com.tvlk.advDemo.model;

public class DeptEmpDTO {
    private String empName;
    private long empId;
    private String deptName;
    private String designation;

    public DeptEmpDTO(long empId, String empName, String designation, String deptName){
        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.deptName = deptName;
    }

    public long getEmpId(){return this.empId; }
    public void setEmpId(long empId){ this.empId = empId; }

    public String getEmpName(){return this.empName;}
    public void setEmpName(){this.empName = empName;}

    public String getDesignation(){return this.designation;}
    public void setDesignation(){this.designation = designation;}

    public String getDeptName(){return this.deptName;}
    public void setDeptName(){this.deptName = deptName;}
}
