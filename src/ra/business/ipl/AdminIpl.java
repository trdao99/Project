package ra.business.ipl;

import ra.business.design.IAdmin;
import ra.business.design.IAuthication;
import ra.business.entity.Enum;
import ra.business.entity.User;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.io.Serializable;
import java.util.ArrayList;
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
        for (User user : userList) {
            System.out.println(user);
        }
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
}
