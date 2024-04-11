package ra.presentation;


import ra.business.ipl.ManagerIpLProject;
import ra.utils.InputMethods;

import java.io.Serializable;

public class ManagerMenu implements Serializable {
    public void displayMenuManagerment() {
        ManagerMenuEmployee imanager_e = new ManagerMenuEmployee();
        ManagerMenuCustomer imanager_c = new ManagerMenuCustomer();
        ManagerMenuDepartment imanager_d = new ManagerMenuDepartment();
        ManagerMenuContract imanager_con = new ManagerMenuContract();
        ManagerMenuProject imanager_p = new ManagerMenuProject();
        out:
        do {
            System.out.println("===================Managerment=================\n" +
                    "1.Manager_Employee\n" +
                    "2.Manager_Customer\n" +
                    "3.Manager_Department\n" +
                    "4.Manager_Contract\n" +
                    "5.Manager_Project\n" +
                    "6.exit\n");
            System.out.println("Nhap chuc nang");
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
                    break out;
                default:
                    System.err.println("khon hop le");
            }
        } while (true);
    }
}
