package ra.presentation;


import ra.business.design.IAuthication;
import ra.business.entity.User;
import ra.business.ipl.AuthenticationService;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.util.ArrayList;
import java.util.List;

import static ra.business.entity.Enum.*;


public class Main {

    private static final MenuUser menuUser = new MenuUser();
    private static final ManagerMenu managerMenu = new ManagerMenu();
    private static final IAuthication authication = new AuthenticationService();
    public static User user = null;
    public static List<User> Login = IOFile.readFromFile(IOFile.LOGINUSER_PATH);

    public static void main(String[] args) {

        while (true) {
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("                    MENU                        ");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("  1. Đăng nhập                                  ");
            System.out.println("  2. Thoát                                      ");
            System.out.println("                                                ");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Thoát");
                    break;
                default:
                    System.err.println("⚠ Lựa chọn không hợp lệ");
            }
            if (choice == 2) {
                break;
            }
        }
    }

    public static void login() {
        String username ;
        String password ;
        if (Login.isEmpty()) {
            System.out.println("═════════════════════════ Đăng nhập ════════════════════════");
            System.out.print("\tNhập username: ");
            username = InputMethods.getString();
            System.out.print("\tNhập password: ");
            password = InputMethods.getString();
        }
        else{
            username = Login.get(0).getUsername();
            password = Login.get(0).getPassword();
        }
        User userLogin;

        userLogin = authication.login(username, password);

        if (userLogin == null) {
            System.err.println("⚠ Tài khoản hoặc mật khẩu không chính xác");
            System.out.println("1. Tiếp tục đăng nhập");
            System.out.println("2. Thoát");
            System.out.println("------ Nhập lựa chọn ------");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    return;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
            }
        } else {
            if (userLogin.getRole().equals(ADMIN)) {
                user = userLogin;
                MenuAdmin.getInstance().displayMenuAdmin();
            } else if (userLogin.getRole().equals(USER)) {
                if (!userLogin.getStatus()) {
                    System.err.println("⚠ Tài khoản đã bị khóa, vui lòng liên hệ admin (01234568988)");
                } else {
                    user = userLogin;
                    menuUser.displayMenuUser();
                }
            } else if (userLogin.getRole().equals(MANAGERMENT)) {
                if (!userLogin.getStatus()) {
                    System.err.println("⚠ Tài khoản đã bị khóa, vui lòng liên hệ admin (01234568988)");
                } else {
                    user = userLogin;
                    managerMenu.displayMenuManagerment();
                }
            } else {
                System.err.println("⚠ Không có quyền truy cập");
            }
        }
    }
}
