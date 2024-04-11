package ra.presentation;

import ra.business.design.Imanager_CUSTOMER;
import ra.business.ipl.ManagerIpl_CUSTOMER;
import ra.utils.InputMethods;
import java.io.Serializable;

public class ManagerMenu_CUSTOMER implements Serializable{
    public void EmployeeMenu_CUSTOMER() {
        Imanager_CUSTOMER imanager_customer = new ManagerIpl_CUSTOMER();
        out:
        do {
            System.out.println("chao mung toi trang quản lý");
            System.out.println("1.Thêm mới customer\n" +
                    "2.Xem danh sách customer\n" +
                    "3.Cập nhật thông tin customer\n" +
                    "4.Xóa customer\n" +
                    "5.Tìm kiếm theo tên\n" +
                    "6.exit");
            System.out.println("Nhap chuc nang");
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
                    System.err.println("Lua chon khong hop le");
                    break;
            }
        } while (true);
    }
}
