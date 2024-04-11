package ra.presentation;

import ra.business.design.IContract;
import ra.business.ipl.ManagerIpl_CONTRACT;
import ra.utils.InputMethods;

public class ManagerMenu_CONTRACT {
    public void ManagerMenu_CONTRACT(){
        IContract contract = new ManagerIpl_CONTRACT();
        out:
        do {
            System.out.println("chao mung toi trang quản lý");
            System.out.println("1.Thêm mới hợp đồng \n" +
                    "2.Xem danh sách hợp đồng\n" +
                    "3.Cập nhật thông tin hợp đồng\n" +
                    "4.Xóa hợp đồng\n" +
                    "5.Tìm kiếm theo tên\n" +
                    "6.exit");
            System.out.println("Nhap chuc nang");
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
                    contract.delData();
                    break;
                case 5:
                    contract.searchData();
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

