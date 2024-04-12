package ra.presentation;

import ra.business.design.IUser_ACCOUNT;
import ra.business.ipl.UserAccountManagerIpL;
import ra.utils.InputMethods;

public class MenuUserAccount {
    void MenuUser_ACCOUNT() {
        IUser_ACCOUNT iUser_account = new UserAccountManagerIpL();
        out:
        while (true) {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║             Chào mừng đến với trang người dùng   ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Xem thông tin cá nhân                        ║");
            System.out.println("║  2. Xem thông tin tài khoản                      ║");
            System.out.println("║  3. Đổi mật khẩu                                 ║");
            System.out.println("║  4. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    iUser_account.displayIn4();
                    break;
                case 2:
                    iUser_account.displayAccount();
                    break;
                case 3:
                    iUser_account.changePassword();
                    break;
                case 4:
                    break out;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
                    break;
            }
        }
    }
}
