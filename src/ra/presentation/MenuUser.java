package ra.presentation;


import ra.utils.InputMethods;

public class MenuUser {
    public void displayMenuUser() {
        MenuUserProject menuP = new MenuUserProject();
        MenuUserAccount account = new MenuUserAccount();
       out: while (true) {
            System.out.println("chao mung toi trang nguoi dung");
            System.out.println("1.Quản lý tài khoản\n" +
                    "2.Quản lý hợp đồng\n" +
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