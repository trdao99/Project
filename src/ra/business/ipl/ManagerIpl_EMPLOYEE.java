package ra.business.ipl;

import ra.business.design.Imanager_EMPLOYEE;
import ra.business.entity.Department;
import ra.business.entity.Employee;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class ManagerIpl_EMPLOYEE implements Imanager_EMPLOYEE, Serializable {
    List<Employee> managerEmployee = IOFile.readFromFile(IOFile.EMPLOYEE_PATH);
    List<Department> departmentList = IOFile.readFromFile(IOFile.DEPARTMENT_PATH);
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;

    @Override
    public void addData() {
        System.out.println("nhấp số lượng muốn thêm:");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            managerEmployee.add(inputData());
            IOFile.writeToFile(IOFile.EMPLOYEE_PATH, managerEmployee);
        }
    }

    @Override
    public void displayData() {
        for (Employee employee : managerEmployee) {
            System.out.println(employee);
        }
    }

    @Override
    public void updateData() {
        System.out.println("nhập ID nhân viên muốn thay đổi");
        int id = InputMethods.getInteger();
        for (int i = 0; i < managerEmployee.size(); i++) {
            if (managerEmployee.get(i).getEmployeeid() == id) {
                flag = false;
                managerEmployee.set(i, inputData());
                managerEmployee.get(i).setEmployeeid(id);
                IOFile.writeToFile(IOFile.EMPLOYEE_PATH, managerEmployee);
                break;
            }
        }
    }

    @Override
    public void delData() {
        System.out.println("nhập ID nhân viên muốn xoa");
        int id = InputMethods.getInteger();
        for (Employee employee : managerEmployee) {
            if (employee.getEmployeeid() == id) {
                managerEmployee.remove(employee);
                IOFile.writeToFile(IOFile.EMPLOYEE_PATH, managerEmployee);
                break;
            }
        }
    }

    @Override
    public void searchData() {
        System.out.println("nhập tên nhân viên muốn tìm ");
        String nameFind = InputMethods.getString().toLowerCase();
        for (Employee employee : managerEmployee) {
            if (employee.getEmployeename().toLowerCase().equals(nameFind)) {
                System.out.println(employee);
                break;
            }
        }
    }

    Employee inputData() {
        Employee employee = new Employee();
        if (flag) {
            employee.setEmployeeid(getNewId());
        }
        System.out.println("nhập tên:");
        employee.setEmployeename(InputMethods.getString());
        out:
        while (true) {
            System.out.println("chọn phòng ban theo ID :");
            for (Department dept : departmentList) {
                System.out.println(dept);
            }
            int id = InputMethods.getInteger();
            if (id > departmentList.size() || id < 0) {
                System.err.println("ID không tồn tại, mời chọn lại ");
            } else {
                for (Department dept : departmentList) {
                    if (id == dept.getDepartmentid()) {
                        employee.setDepartmentName(dept.getDepartmentname());
                        break out;
                    }
                }
            }
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.println("nhập ngày sinh:");
                employee.setBirth(LocalDate.parse(InputMethods.getString(), dtf));
                break;
            } catch (DateTimeException e) {
                System.err.println("nhập đúng định dạng (dd/MM/yyyy)");
            }
        }
        System.out.println("sex:");
        employee.setSex(InputMethods.getBoolean());
        employee.setCreatedDate(LocalDate.now());
        System.out.println("salary: ");
        employee.setSalary(InputMethods.getFloat());
        return employee;
    }

    private int getNewId() {
        int max = managerEmployee.stream().map(Employee::getEmployeeid).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }
}
