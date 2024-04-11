package ra.business.design;
import ra.business.entity.Enum;
import ra.business.entity.User;
public interface IAuthication {
    User login(String username,String password);
    void register(User user, Enum enums);
}
