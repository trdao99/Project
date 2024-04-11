package ra.business.ipl;

import ra.business.design.Imanager_PROJECT;
import ra.business.entity.Contract;
import ra.business.entity.Employee;
import ra.business.entity.Project;
import ra.utils.IOFile;
import ra.utils.InputMethods;
import ra.utils.Pagination;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManagerIpLProject implements Serializable, Imanager_PROJECT {
    List<Project> projectList = IOFile.readFromFile(IOFile.PROJECT_PATH);
    List<Contract> contractList = IOFile.readFromFile(IOFile.CONTRACT_PATH);
    List<Employee> managerEmployee = IOFile.readFromFile(IOFile.EMPLOYEE_PATH);
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    @Override
    public void updateData() {
        System.out.println("nhập ID dự án muốn thay đổi");
        int id = InputMethods.getInteger();
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getProjectId() == id) {
                flag = false;
                projectList.set(i, inputData());
                projectList.get(i).setProjectId(id);
                IOFile.writeToFile(IOFile.PROJECT_PATH, projectList);
                break;
            }
        }
    }

    @Override
    public void searchData() {

    }

    @Override
    public void addData() {
        System.out.println("nhấp số lượng muốn thêm:");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            projectList.add(inputData());
            IOFile.writeToFile(IOFile.PROJECT_PATH, projectList);
        }
    }

    @Override
    public void displayData() {
        Pagination.pagination(projectList);
    }

    @Override
    public void delData() {

    }

    @Override
    public void changeStatus() {
        System.out.println("nhập ID dự án muốn thay đổi");
        int id = InputMethods.getInteger();
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getProjectId() == id) {
                projectList.get(i).setStatus(!projectList.get(i).isStatus());
                break;
            }
        }
    }

    public Project inputData() {
        Project project = new Project();
        if(flag){
            project.setProjectId(getNewId());
        }
        while (true) {
            boolean check = true;
            System.out.println("nhập tên dự án");
            String contractName = InputMethods.getString();
            if (!projectList.isEmpty()) {
                for (Project p : projectList) {
                    if (contractName.equals(p.getProjectName())) {
                        System.err.println("dự án đã tồn tại");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    project.setProjectName(contractName);
                    break;
                }
            } else {
                project.setProjectName(contractName);
                break;
            }
        }
        System.out.println("nhập mô tả dự án");
        project.setProjectDescription(InputMethods.getString());

        System.out.println("chọn ID hợp đồng :");
        for (Contract c : contractList) {
            System.out.println(c);
        }
        int choseContract = InputMethods.getInteger();
        for (Contract c : contractList) {
            if (choseContract == c.getContractId()) {
                project.setContractId(c.getContractId());
            }
        }

        System.out.println("chọn ID leader");
        for (Employee e : managerEmployee) {
            System.out.println(e);
        }
        int choseLeader = InputMethods.getInteger();
        for (Employee e : managerEmployee) {
            if (choseLeader == e.getEmployeeid()) {
                project.setLeader_id(e.getEmployeeid());
            }
        }

        System.out.println("chọn số thành viên tham giá dự án:");
        project.setTotalMember(InputMethods.getInteger());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.println("nhập ngày bắt đầu dự án:");
                project.setStartDate(LocalDate.parse(InputMethods.getString(), dtf));
                break;
            } catch (DateTimeException e) {
                System.err.println("nhập đúng định dạng (dd/MM/yyyy)");
            }
        }
        while (true) {
            try {
                System.out.println("nhập ngày kết thúc dự án:");
                project.setEndDate(LocalDate.parse(InputMethods.getString(), dtf));
                break;
            } catch (DateTimeException e) {
                System.err.println("nhập đúng định dạng (dd/MM/yyyy)");
            }
        }
        System.out.println("chọn status (1:đang thực hiện / 2: đã hoàn thành )");
        int statusChoice = InputMethods.getInteger();
        switch (statusChoice) {
            case 1:
                project.setStatus(true);
                break;
            case 2:
                project.setStatus(false);
                break;
            default:
                System.out.println("mặc định chọn (đang thực hiện)");
                project.setStatus(false);
                break;
        }
        System.out.println("chọn công nghệ thực hiện: ");
        project.setTechnology(InputMethods.getString().toUpperCase());


        return project;
    }

    private int getNewId() {
        int max = projectList.stream().map(Project::getProjectId).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }
}
