package ra.presentation;

import ra.business.design.Imanager_PROJECT;
import ra.business.ipl.ManagerIpLProject;
import ra.utils.InputMethods;

import java.awt.event.ActionListener;

public class ManagerMenuProject {
    public void ManagerMenuProject() {
        Imanager_PROJECT ipl = new ManagerIpLProject();
        while(true){
            System.out.println("=== Quản lý dự án ===");
            System.out.println("1. Thêm mới dự án");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Chỉnh sửa thông tin");
            System.out.println("4. Cập nhật trạng thái");
            System.out.println("0. Thoát");
            System.out.println("====================");
            System.out.print("Nhập lựa chọn của bạn: ");
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
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
