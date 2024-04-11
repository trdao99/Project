package ra.presentation;

import ra.business.design.IUser_PROJECT;
import ra.business.ipl.UserProjectManagerIpL;
import ra.utils.InputMethods;

public class MenuUser_PROJECT {
    public void MenuUser_PROJECT() {
        IUser_PROJECT userProject = new UserProjectManagerIpL();
        out:
        while (true) {
            System.out.println("1.Xem hợp đồng\n" +
                    "2.Xem dự án \n" +
                    "3.exit");
            System.out.println("Nhap chuc nang");
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
                    System.err.println("Lua chon khong hop le");
                    break;
            }
        }
    }
}
