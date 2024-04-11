package ra.business.entity;

import ra.utils.InputMethods;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 2L;
    private int id;
    private String username;
    private String password;
    private Enum Role;
    private Boolean status;
    public User() {
    }

    public User(int id, String username, String password, Enum role, Boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        Role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum getRole() {
        return Role;
    }

    public void setRole(Enum role) {
        Role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
//    public void inputUsername(){
//        this.username = InputMethods.getString();
//    }
//    public void inputPassword(){
//        this.password = InputMethods.getString();
//    }
    @Override
    public String toString() {
        return String.format("ID : %d | Username : %s | Role : %s | status :%s", id, username, Role,status?"hoạt động":"bị khóa");
    }
}
