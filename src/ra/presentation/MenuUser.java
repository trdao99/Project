package ra.presentation;


import ra.utils.IOFile;
import ra.utils.InputMethods;

import static ra.presentation.Main.Login;

public class MenuUser {
    public void displayMenuUser() {
        MenuUserProject menuP = new MenuUserProject();
        MenuUserAccount account = new MenuUserAccount();
       out: while (true) {
           System.out.println("╔══════════════════════════════════════════════════╗");
           System.out.println("║           Chào mừng đến với trang người dùng     ║");
           System.out.println("╠══════════════════════════════════════════════════╣");
           System.out.println("║  1. Quản lý tài khoản                            ║");
           System.out.println("║  2. Quản lý hợp đồng                             ║");
           System.out.println("║  3. Logout                                       ║");
           System.out.println("╚══════════════════════════════════════════════════╝");
           System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    account.MenuUser_ACCOUNT();
                    break;
                case 2:
                    menuP.MenuUser_PROJECT();
                    break;
                case 3:
                    Login.clear();
                    IOFile.writeToFile(IOFile.LOGINUSER_PATH, Login);
                    break out;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
                    break;
            }
        }
    }
}