package ra.presentation;

import ra.business.design.IDepartment;
import ra.business.ipl.ManagerIPLDepartment;
import ra.utils.InputMethods;

public class ManagerMenuDepartment {
    public void ManagerMenu_DEPARTMENT(){
        IDepartment dept = new ManagerIPLDepartment();
        out:
        do {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║              Chào mừng đến trang quản lý         ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║                   MENU QUẢN LÝ PHÒNG BAN         ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Thêm mới phòng ban                           ║");
            System.out.println("║  2. Xem danh sách phòng ban                      ║");
            System.out.println("║  3. Cập nhật thông tin phòng ban                 ║");
            System.out.println("║  4. Xóa phòng ban                                ║");
            System.out.println("║  5. Tìm kiếm theo tên                            ║");
            System.out.println("║  6. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    dept.addData();
                    break;
                case 2:
                    dept.displayData();
                    break;
                case 3:
                    dept.updateData();
                    break;
                case 4:
                    dept.delData();
                    break;
                case 5:
                    dept.searchData();
                    break;
                case 6:
                    break out;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
                    break;
            }
        } while (true);
    }
}
