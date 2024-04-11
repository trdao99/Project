package ra.presentation;

import ra.business.design.IUser_ACCOUNT;
import ra.business.ipl.UserAccountManagerIpL;
import ra.utils.InputMethods;

public class MenuUser_ACCOUNT {
    void MenuUser_ACCOUNT() {
        IUser_ACCOUNT iUser_account = new UserAccountManagerIpL();
        out:
        while (true) {
            System.out.println("1.Xem thông tin cá nhân\n" +
                    "2.Xem thông tin tài khoản \n" +
                    "3.Đổi mật khẩu\n" +
                    "4.exit");
            System.out.println("Nhap chuc nang");
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
                    System.err.println("Lua chon khong hop le");
                    break;
            }
        }
    }
}
