package ra.business.entity;

import java.io.Serializable;

public class Department implements Serializable {
    private int Departmentid;
    private String Departmentname;
    private String Description;

    public Department() {
    }

    public Department(int Departmentid, String Departmentname, String Description) {
        this.Departmentid = Departmentid;
        this.Departmentname = Departmentname;
        this.Description = Description;
    }

    public int getDepartmentid() {
        return Departmentid;
    }

    public void setDepartmentid(int departmentid) {
        Departmentid = departmentid;
    }

    public String getDepartmentname() {
        return Departmentname;
    }

    public void setDepartmentname(String departmentname) {
        Departmentname = departmentname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return String.format("ID : %d | Name : %s | Description : %s\n", getDepartmentid(), getDepartmentname(), getDescription());
    }
}
