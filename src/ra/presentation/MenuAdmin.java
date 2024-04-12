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
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║             Chào mừng đến với trang quản trị     ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Thêm tài khoản                               ║");
            System.out.println("║  2. Xem danh sách tài khoản                      ║");
            System.out.println("║  3. Khóa mở tài khoản                            ║");
            System.out.println("║  4. Thống kê                                     ║");
            System.out.println("║  5. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("\t\t═════════nhập chức năng═════════");
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
                    admin.statistical();
                    break;
                case 5:
                    break out;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
                    break;
            }
        }
        while (true);
    }
}