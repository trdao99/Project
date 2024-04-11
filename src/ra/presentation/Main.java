package ra.presentation;


import ra.business.design.IAuthication;
import ra.business.entity.User;
import ra.business.ipl.AuthenticationService;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.util.ArrayList;
import java.util.List;

import static ra.business.entity.Enum.*;


public class Main {

    private static final MenuUser menuUser = new MenuUser();
    private static final ManagerMenu managerMenu = new ManagerMenu();
    private static final IAuthication authication = new AuthenticationService();
    public static User user = null;
    public static List<User> Login = new ArrayList<>();
    public static void main(String[] args) {

        while (true){
            System.out.println("++++++++++++++++++++++++MENU+++++++++++++++++++++++");
            System.out.println("1. Dang nhap");
            System.out.println("2. Thoat");
            System.out.println("Nhap chuc nang");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    Login.clear();
                    login();
                    break;
                case 2:
                    System.out.println("Thoat");
                default:
                    System.err.println("Lua chon khong hop le");
            }
            if (choice==2){
                break;
            }
        }
    }
    public static void login(){
        System.out.println("----------Dang nhap--------------");
        System.out.println("Nhap username :");
        String username  = InputMethods.getString();
        System.out.println("Nhap password :");
        String password  = InputMethods.getString();
        User userLogin;

         userLogin =  authication.login(username,password);

        if (userLogin==null){
            System.err.println("Tai khoan hoac mat khau khong chinh xac");
            System.out.println("1. Tiep tuc dang nhap");
            System.out.println("2. Thoat");
            System.out.println("------Nhap lua chon--------");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    login();
                    break;
                case 2:
                    return;
                default:
                    System.err.println("nhap lua chon ko chinh xac");
            }
        }else {
            if (userLogin.getRole().equals(ADMIN)){
                user = userLogin;
                MenuAdmin.getInstance().displayMenuAdmin();
            }else if (userLogin.getRole().equals(USER)){
                if (!userLogin.getStatus()){
                    System.err.println("Tai khoan da bi khoa, vui long lien he admin (01234568988)");
                }else {
                    user = userLogin;
                    menuUser.displayMenuUser();
                }
            }else if (userLogin.getRole().equals(MANAGERMENT)){
                if (!userLogin.getStatus()){
                    System.err.println("Tai khoan da bi khoa, vui long lien he admin (01234568988)");
                }else {
                    user = userLogin;
                    managerMenu.displayMenuManagerment();
                }
            }else {
                System.err.println("khong co quyen truy cap");
            }
        }
    }
}
