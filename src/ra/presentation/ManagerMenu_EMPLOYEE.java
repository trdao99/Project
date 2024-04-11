package ra.presentation;

import ra.business.design.Imanager_EMPLOYEE;
import ra.business.ipl.ManagerIpl_EMPLOYEE;
import ra.utils.InputMethods;

public class ManagerMenu_EMPLOYEE {
    public void EmployeeMenu_EMPLOYEE() {
        Imanager_EMPLOYEE imanager_employee = new ManagerIpl_EMPLOYEE();
        out:
        do {
            System.out.println("chao mung toi trang quản lý");
            System.out.println("1.Thêm mới employee\n" +
                    "2.Xem danh sách employee\n" +
                    "3.Cập nhật thông tin employee\n" +
                    "4.Xóa nhân viên\n" +
                    "5.Tìm kiếm theo tên\n" +
                    "6.exit");
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
                    System.err.println("Lua chon khong hop le");
                    break;
            }
        } while (true);
    }
}
