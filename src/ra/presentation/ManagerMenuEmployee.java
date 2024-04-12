package ra.presentation;

import ra.business.design.Imanager_EMPLOYEE;
import ra.business.ipl.ManagerIplEmployee;
import ra.utils.InputMethods;

public class ManagerMenuEmployee {
    public void EmployeeMenu_EMPLOYEE() {
        Imanager_EMPLOYEE imanager_employee = new ManagerIplEmployee();
        out:
        do {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║              Chào mừng đến trang quản lý         ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║                   MENU QUẢN LÝ EMPLOYEE          ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Thêm mới employee                            ║");
            System.out.println("║  2. Xem danh sách employee                       ║");
            System.out.println("║  3. Cập nhật thông tin employee                  ║");
            System.out.println("║  4. Xóa employee                                 ║");
            System.out.println("║  5. Tìm kiếm theo tên                            ║");
            System.out.println("║  6. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("Nhap chuc nang");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    imanager_employee.addData();
                    break;
                case 2:
                    imanager_employee.displayData();
                    break;
                case 3:
                    imanager_employee.updateData();
                    break;
                case 4:
                    imanager_employee.delData();
                    break;
                case 5:
                    imanager_employee.searchData();
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
