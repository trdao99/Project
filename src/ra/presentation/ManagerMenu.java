package ra.presentation;


import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.io.Serializable;
import java.util.List;

import static ra.presentation.Main.Login;

public class ManagerMenu implements Serializable {
    public void displayMenuManagerment() {
        ManagerMenuEmployee imanager_e = new ManagerMenuEmployee();
        ManagerMenuCustomer imanager_c = new ManagerMenuCustomer();
        ManagerMenuDepartment imanager_d = new ManagerMenuDepartment();
        ManagerMenuContract imanager_con = new ManagerMenuContract();
        ManagerMenuProject imanager_p = new ManagerMenuProject();
        out:
        do {
            System.out.println("""
                    ╔═══════════════════ Management ═══════════════════╗
                    ║                                                  ║
                    ║           1. Employee Management                 ║
                    ║           2. Customer Management                 ║
                    ║           3. Department Management               ║
                    ║           4. Contract Management                 ║
                    ║           5. Project Management                  ║
                    ║           6. logout                              ║
                    ║                                                  ║
                    ╚══════════════════════════════════════════════════╝""");
            System.out.println("\t\t═════════nhập chức năng═════════");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    imanager_e.EmployeeMenu_EMPLOYEE();
                    break;
                case 2:
                    imanager_c.EmployeeMenu_CUSTOMER();
                    break;
                case 3:
                    imanager_d.ManagerMenu_DEPARTMENT();
                    break;
                case 4:
                    imanager_con.ManagerMenu_CONTRACT();
                    break;
                case 5:
                    imanager_p.ManagerMenuProject();
                    break;
                case 6:
                    Login.clear();
                    IOFile.writeToFile(IOFile.LOGINUSER_PATH, Login);
                    break out;
                default:
                    System.err.println("⚠ Nhập lựa chọn không chính xác");
            }
        } while (true);
    }
}
