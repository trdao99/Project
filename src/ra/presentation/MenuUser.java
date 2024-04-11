package ra.presentation;


import ra.business.ipl.UserProjectManagerIpL;
import ra.utils.InputMethods;

public class MenuUser {
    public void displayMenuUser() {
        MenuUser_PROJECT menuP = new MenuUser_PROJECT();
        MenuUser_ACCOUNT account = new MenuUser_ACCOUNT();
       out: while (true) {
            System.out.println("chao mung toi trang nguoi dung");
            System.out.println("1.Quản lý hợp đồng\n" +
                    "2.Quản lý tài khoản\n" +
                    "3.exit");
            System.out.println("Nhap chuc nang");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    account.MenuUser_ACCOUNT();
                    break;
                case 2:
                    menuP.MenuUser_PROJECT();
                    break;
                case 3:
                    break out;
                default:
                    System.err.println("Lua chon khong hop le");
                    break;
            }
        }
    }
}