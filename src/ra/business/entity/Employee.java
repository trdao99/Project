package ra.business.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    private int Employeeid;
    private String Employeename;
    private String DepartmentName;
    private LocalDate Birth;
    private Boolean Sex;
    private LocalDate createdDate;
    private float salary;

    public Employee() {
    }

    public Employee(int employeeid, String employeename, String departmentName, LocalDate birth, Boolean sex, LocalDate createdDate, float salary) {
        Employeeid = employeeid;
        Employeename = employeename;
        DepartmentName = departmentName;
        Birth = birth;
        Sex = sex;
        this.createdDate = createdDate;
        this.salary = salary;
    }

    public int getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(int employeeid) {
        Employeeid = employeeid;
    }

    public String getEmployeename() {
        return Employeename;
    }

    public void setEmployeename(String employeename) {
        Employeename = employeename;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public LocalDate getBirth() {
        return Birth;
    }

    public void setBirth(LocalDate birth) {
        Birth = birth;
    }

    public Boolean getSex() {
        return Sex;
    }

    public void setSex(Boolean sex) {
        Sex = sex;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name : %s | Department : %s | Birth : %s | ngày vào công ty : %s | sex: %s | Salary : %s", Employeeid, Employeename, DepartmentName, Birth, createdDate,Sex?"Nam":"Nữ", salary);
    }
}
