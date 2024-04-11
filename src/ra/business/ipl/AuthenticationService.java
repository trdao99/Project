package ra.business.ipl;


import org.mindrot.jbcrypt.BCrypt;
import ra.business.design.IAuthication;
import ra.business.entity.Enum;
import ra.business.entity.User;
import ra.utils.IOFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ra.business.entity.Enum.ADMIN;
import static ra.presentation.Main.Login;
import static ra.utils.IOFile.USER_PATH;


public class AuthenticationService implements IAuthication, Serializable {
    private static List<User> userList ;

    static {
//        User admin = new User(0, "Admin123", "admin123", ADMIN, true);
//        admin.setPassword(BCrypt.hashpw(admin.getPassword(),BCrypt.gensalt(5)));
        userList = IOFile.readFromFile(USER_PATH);
//        userList.add(admin);
//        IOFile.writeToFile(IOFile.USER_PATH,userList);
    }
    @Override
    public User login(String username, String password) {
        User userLogin  = getUserFromUsername(username);
        if (userLogin==null){
            return null;
        }
        boolean checkLogin = BCrypt.checkpw(password, userLogin.getPassword()); // kiem tra mat khau khop hay khong
        if (checkLogin){
            Login.add(userLogin);
            return userLogin;
        }
        return null;
    }

    @Override
    public void register(User user, Enum enums) {
        user.setId(getNewId());
        user.setRole(enums);
        user.setStatus(true);
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(5)));
        userList.add(user);
        System.out.println(userList.size());
        IOFile.writeToFile(USER_PATH,userList);
    }
    private User getUserFromUsername(String username){
        return userList.stream().filter(user->user.getUsername().equals(username)).findFirst().orElse(null);
    }
    private int getNewId(){
        int max = userList.stream().map(User::getId).max(Comparator.naturalOrder()).orElse(0);
        return max+1;
    }
}