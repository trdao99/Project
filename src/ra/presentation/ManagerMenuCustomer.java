package ra.presentation;

import ra.business.design.Imanager_CUSTOMER;
import ra.business.ipl.ManagerIplCustomer;
import ra.utils.InputMethods;
import java.io.Serializable;

public class ManagerMenuCustomer implements Serializable{
    public void EmployeeMenu_CUSTOMER() {
        Imanager_CUSTOMER imanager_customer = new ManagerIplCustomer();
        out:
        do {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║              Chào mừng đến trang quản lý         ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║                   MENU QUẢN LÝ KHÁCH HÀNG        ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Thêm mới khách hàng                          ║");
            System.out.println("║  2. Xem danh sách khách hàng                     ║");
            System.out.println("║  3. Cập nhật thông tin khách hàng                ║");
            System.out.println("║  4. Xóa khách hàng                               ║");
            System.out.println("║  5. Tìm kiếm theo tên                            ║");
            System.out.println("║  6. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    imanager_customer.addData();
                    break;
                case 2:
                    imanager_customer.displayData();
                    break;
                case 3:
                    imanager_customer.updateData();
                    break;
                case 4:
                    imanager_customer.delData();
                    break;
                case 5:
                    imanager_customer.searchData();
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
