package ra.business.ipl;

import ra.business.design.IDepartment;
import ra.business.entity.Department;
import ra.business.entity.Employee;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class ManagerIPL_DEPARTMENT implements IDepartment, Serializable {
    List<Department> departmentList = IOFile.readFromFile(IOFile.DEPARTMENT_PATH);
    Scanner sc = new Scanner(System.in);
    boolean flag = true;

    @Override
    public void addData() {
        System.out.println("nhấp số lượng muốn thêm:");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            departmentList.add(inputData());
            IOFile.writeToFile(IOFile.DEPARTMENT_PATH, departmentList);
        }
    }

    @Override
    public void displayData() {
        for (Department department : departmentList) {
            System.out.println(department);
        }
    }

    @Override
    public void delData() {
        System.out.println("nhập ID phòng ban muốn xóa");
        int id = InputMethods.getInteger();
        boolean check = true;
        List<Employee> managerEmployee = IOFile.readFromFile(IOFile.EMPLOYEE_PATH);
        for (Department department : departmentList) {
            if (department.getDepartmentid() == id) {
                for (Employee employee : managerEmployee) {
                    if (employee.getDepartmentName().equals(department.getDepartmentname())) {
                        System.err.println("phòng ban có nhân viên không được xóa");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    departmentList.remove(department);
                    IOFile.writeToFile(IOFile.DEPARTMENT_PATH, departmentList);
                    break;
                }
            }
        }
    }

    @Override
    public void searchData() {
        System.out.println("nhập tên phòng ban muốn tìm ");
        String nameFind = InputMethods.getString().toLowerCase();
        for (Department department : departmentList) {
            if (department.getDepartmentname().toLowerCase().equals(nameFind)) {
                System.out.println(department);
                break;
            }
        }
    }

    @Override
    public void updateData() {
        System.out.println("nhập ID phòng ban muốn thay đổi");
        int id = InputMethods.getInteger();
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentid() == id) {
                flag = false;
                departmentList.set(i, inputData());
                departmentList.get(i).setDepartmentid(id);
                IOFile.writeToFile(IOFile.DEPARTMENT_PATH, departmentList);
                break;
            }
        }
    }

    public Department inputData() {
        Department department = new Department();
        if (flag) {
            department.setDepartmentid(getNewId());
        }
        while (true) {
            System.out.println("Nhập tên phòng ban: ");
            String name = InputMethods.getString();
            department.setDepartmentname(name);
            boolean flag1 = false;
            if (!departmentList.isEmpty()) {
                //check tồn tại
                for (int i = 0; i < departmentList.size(); i++) {
                    if (department.getDepartmentname().equals(departmentList.get(i).getDepartmentname())) {
                        System.err.println("Phòng đã tồn tại");
                        flag1 = true;
                        break;
                    }
                }
            }
            if (!flag1) {
                break;
            }
        }
        System.out.println("Nhập mô tả phòng ban:");
        String descr = InputMethods.getString();
        department.setDescription(descr);
        System.out.println(department);
        return department;
    }

    private int getNewId() {
        int max = departmentList.stream().map(Department::getDepartmentid).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }
}
