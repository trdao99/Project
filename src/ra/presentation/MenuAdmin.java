package ra.presentation;

import ra.business.design.IAdmin;
import ra.business.ipl.AdminIpl;
import ra.utils.InputMethods;

public class MenuAdmin {
    private static MenuAdmin menuAdmin = new MenuAdmin();

    // Singleton
    public static MenuAdmin getInstance() {
        return menuAdmin;
    }

    private MenuAdmin() {
    }

    public void displayMenuAdmin() {
        out:
        do {
            IAdmin admin = new AdminIpl();
            System.out.println("chao mung toi trang quan tri");
            System.out.println("1.thêm tài khoản\n" +
                    "2.Xem danh sách tài khoản\n" +
                    "3.Khóa mở tài khoản\n " +
                    "4.exit");
            System.out.println("Nhap chuc nang");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    admin.addData();
                    break;
                case 2:
                    admin.displayData();
                    break;
                case 3:
                    admin.blockAcc();
                    break;
                case 4:
                    break out;
                default:
                    System.err.println("Lua chon khong hop le");
                    break;
            }
        }
        while (true);
    }
}