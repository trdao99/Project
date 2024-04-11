package ra.business.ipl;

import ra.business.design.IAdmin;
import ra.business.design.IAuthication;
import ra.business.entity.*;
import ra.business.entity.Enum;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;


import static ra.utils.IOFile.USER_PATH;


public class AdminIpl implements IAdmin, Serializable {

    private static IAuthication authic = new AuthenticationService();
    Scanner sc = new Scanner(System.in);

    @Override
    public void blockAcc() {
        System.out.println("chọn ID tài khoản để block hoặc unblock");
        List<User> userList = IOFile.readFromFile(USER_PATH);
        displayData();
        int choose = InputMethods.getInteger();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == choose) {
                userList.get(i).setStatus(!userList.get(i).getStatus());
            }
        }
        IOFile.writeToFile(USER_PATH, userList);
        displayData();
    }

    @Override
    public void displayData() {
        List<User> userList = IOFile.readFromFile(USER_PATH);
        userList.stream().filter(v -> v.getRole().equals(Enum.MANAGERMENT) || v.getRole().equals(Enum.USER)).forEach(System.out::println);
    }

    @Override
    public void addData() {

        out:
        while (true) {
            System.out.println("1. thêm tài khoản Manager\n" +
                    "2.thêm tài khoản User\n" +
                    "3.exit");
            System.out.print("chọn chức năng: ");
            int choose = InputMethods.getInteger();
            switch (choose) {
                case 1:
                    inputManagerAcc(sc);
                    break;
                case 2:
                    inputUserAcc(sc);
                    break;
                case 3:
                    break out;
                default:
                    System.out.println("chỉ chọn 1 hoặc 2");
                    break;
            }
        }
    }

    public void inputManagerAcc(Scanner sc) {
        User user = new User();
        List<User> userList = IOFile.readFromFile(USER_PATH);
        System.out.println("--------------Dang ky----------------");
        while (true) {
            System.out.println("Nhap ten dang nhap");
            String userName = InputMethods.getString();
            boolean check = true;
            if (userName.length() > 6) {
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getUsername().equals(userName)) {
                        System.err.println("tên đăng nhập đã tồn tại");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    user.setUsername(userName);
                    break;
                }
            } else {
                System.err.println("tên đăng nhập phải có ít nhất 6 kí tự");

            }
        }
        while (true) {
            System.out.println("Nhap mat khau");
            String userPass = InputMethods.getString();
            String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
            if (userPass.matches(passwordRegex)) {
                user.setPassword(userPass);
                break;
            } else {
                System.err.println("mật khẩu phải có ít nhất 8 kí tự, tồn tại kí tự và số");
            }
        }
        authic.register(user, Enum.MANAGERMENT);
        System.out.println("Dang ki thanh cong");
    }

    public void inputUserAcc(Scanner sc) {
        User user = new User();
        List<User> userList = IOFile.readFromFile(USER_PATH);
        System.out.println("--------------Dang ky----------------");
        while (true) {
            System.out.println("Nhap ten dang nhap");
            String userName = InputMethods.getString();
            boolean check = true;
            if (userName.length() > 6) {
                if (!userList.isEmpty()) {
                    for (int i = 0; i < userList.size(); i++) {
                        if (userList.get(i).getUsername().equals(userName)) {
                            System.err.println("tên đăng nhập đã tồn tại");
                            check = false;
                            break;
                        }
                    }
                }
                if (check) {
                    user.setUsername(userName);
                    break;
                }
            } else {
                System.err.println("tên đăng nhập phải có ít nhất 6 kí tự");
            }
        }
        while (true) {
            System.out.println("Nhap mat khau");
            String userPass = InputMethods.getString();
            String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
            if (userPass.matches(passwordRegex)) {
                user.setPassword(userPass);
                break;
            } else {
                System.err.println("mật khẩu phải có ít nhất 8 kí tự, tồn tại kí tự và số");
            }
        }
        authic.register(user, Enum.USER);
        System.out.println("Dang ki thanh cong");
    }

    @Override
    public void statistical() {
        List<Contract> contractList = IOFile.readFromFile(IOFile.CONTRACT_PATH);
        List<Project> projectList = IOFile.readFromFile(IOFile.PROJECT_PATH);
        out:
        while (true) {
            System.out.println("1.Thống kê số lượng (khách hàng, hợp đồng, dự án)\n" +
                    "2.Xem danh sách dự án theo hợp đồng\n" +
                    "3.exit\n");
            System.out.println("chọn chức năng");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    System.out.printf("số lượng khách hàng: %d\n" +
                            "số lượng hợp đồng : %d\n" +
                            "số lượng dự án : %d\n");
                    break;
                case 2:
                    System.out.println("chọn hợp đồng muốn xem:");
                    for(Contract contract : contractList) {
                        System.out.println(contract);
                    }
                    byte choose = InputMethods.getByte();
                    for(Project project : projectList) {
                        if(choose == project.getContractId()){
                            System.out.println(project);
                        }
                    }
                    break;
                case 3:
                    break out;
            }
        }
    }
}
