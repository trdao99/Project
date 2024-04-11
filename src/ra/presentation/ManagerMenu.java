package ra.presentation;


import ra.utils.InputMethods;
import java.io.Serializable;

public class ManagerMenu implements Serializable {
    public void displayMenuManagerment() {
        ManagerMenu_EMPLOYEE imanager_e = new ManagerMenu_EMPLOYEE();
        ManagerMenu_CUSTOMER imanager_c = new ManagerMenu_CUSTOMER();
        ManagerMenu_DEPARTMENT imanager_d = new ManagerMenu_DEPARTMENT();
        ManagerMenu_CONTRACT imanager_con = new ManagerMenu_CONTRACT();
        out:
        do {
            System.out.println("===================Managerment=================\n" +
                    "1.Manager_Employee\n" +
                    "2.Manager_Customer\n" +
                    "3.Manager_Department\n"+
                    "4.Manager_Contract\n");
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
                case 6:
                    break out;
                default:
                    System.err.println("khon hop le");
            }
        }while (true) ;
    }
}
