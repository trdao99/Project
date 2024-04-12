package ra.presentation;

import ra.business.design.IContract;
import ra.business.ipl.ManagerIplContract;
import ra.utils.InputMethods;

public class ManagerMenuContract {
    public void ManagerMenu_CONTRACT(){
        IContract contract = new ManagerIplContract();
        out:
        do {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║              Chào mừng đến trang quản lý         ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║                   MENU QUẢN LÝ HỢP ĐỒNG          ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Thêm mới hợp đồng                            ║");
            System.out.println("║  2. Xem danh sách hợp đồng                       ║");
            System.out.println("║  3. Cập nhật thông tin hợp đồng                  ║");
            System.out.println("║  4. Cập nhật trạng thái                          ║");
            System.out.println("║  5. Tìm kiếm theo tên                            ║");
            System.out.println("║  6. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    contract.addData();
                    break;
                case 2:
                    contract.displayData();
                    break;
                case 3:
                    contract.updateData();
                    break;
                case 4:
                    contract.changeStatus();
                    break;
                case 5:
                    contract.searchData();
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

