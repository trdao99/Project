package ra.presentation;

import ra.business.design.Imanager_PROJECT;
import ra.business.ipl.ManagerIpLProject;
import ra.utils.InputMethods;

import java.awt.event.ActionListener;

public class ManagerMenuProject {
    public void ManagerMenuProject() {
        Imanager_PROJECT ipl = new ManagerIpLProject();
        while(true){
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║              Chào mừng đến trang quản lý         ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║                   MENU QUẢN LÝ DỰ ÁN             ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Thêm mới dự án                               ║");
            System.out.println("║  2. Xem danh sách dự án                          ║");
            System.out.println("║  3. Cập nhật thông tin dự án                     ║");
            System.out.println("║  4. Cập nhật trạng thái                          ║");
            System.out.println("║  0. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    ipl.addData();
                    break;
                case 2:
                    ipl.displayData();
                    break;
                case 3:
                    ipl.updateData();
                    break;
                case 4:
                    ipl.changeStatus();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
            }
        }
    }
}
