package ra.business.ipl;

import org.mindrot.jbcrypt.BCrypt;
import ra.business.design.IUser_ACCOUNT;
import ra.business.entity.Customer;
import ra.business.entity.User;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.util.List;

import static ra.presentation.Main.Login;
import static ra.utils.IOFile.USER_PATH;

public class UserAccountManagerIpL implements IUser_ACCOUNT {
    List<User> userList = IOFile.readFromFile(USER_PATH);
    List<Customer> managerCustomer = IOFile.readFromFile(IOFile.CUSTOMER_PATH);

    @Override
    public void changePassword() {
        for (User user : userList) {
            if (Login.get(0).getId() == user.getId()) {
                System.out.println("nhập mật khẩu mới");
                String newPass = InputMethods.getString();
                user.setPassword(BCrypt.hashpw(newPass, BCrypt.gensalt(5)));
                System.out.println(BCrypt.hashpw(newPass, BCrypt.gensalt(5)));
                IOFile.writeToFile(USER_PATH, userList);
                break;
            }
        }
    }

    @Override
    public void displayIn4() {
        for (Customer customer : managerCustomer) {
            if (customer.getAccountID() == Login.get(0).getId()) {
                System.out.println(customer);
                break;
            }
        }
    }

    @Override
    public void displayAccount() {
        System.out.println(Login.get(0));
    }
}
