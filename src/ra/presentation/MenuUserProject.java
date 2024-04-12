package ra.presentation;

import ra.business.design.IUser_PROJECT;
import ra.business.ipl.UserProjectManagerIpL;
import ra.utils.InputMethods;

public class MenuUserProject {
    public void MenuUser_PROJECT() {
        IUser_PROJECT userProject = new UserProjectManagerIpL();
        out:
        while (true) {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║          Chào mừng đến với trang người dùng      ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Xem hợp đồng                                 ║");
            System.out.println("║  2. Xem dự án                                    ║");
            System.out.println("║  3. Exit                                         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    userProject.displayContract();
                    break;
                case 2:
                    userProject.displayProject();
                    break;
                case 3:
                    break out;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
                    break;
            }
        }
    }
}
