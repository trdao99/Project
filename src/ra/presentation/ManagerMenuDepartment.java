package ra.presentation;

import ra.business.design.IDepartment;
import ra.business.ipl.ManagerIPLDepartment;
import ra.utils.InputMethods;

public class ManagerMenuDepartment {
    public void ManagerMenu_DEPARTMENT(){
        IDepartment dept = new ManagerIPLDepartment();
        out:
        do {
            System.out.println("chao mung toi trang quản lý");
            System.out.println("1.Thêm mới phòng ban\n" +
                    "2.Xem danh sách phòng ban\n" +
                    "3.Cập nhật thông tin phòng ban\n" +
                    "4.Xóa phòng ban \n" +
                    "5.Tìm kiếm theo tên\n" +
                    "6.exit");
            System.out.println("Nhap chuc nang");
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
                    System.err.println("Lua chon khong hop le");
                    break;
            }
        } while (true);
    }
}
