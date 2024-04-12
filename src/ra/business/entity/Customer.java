package ra.business.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private int customerPhone;
    private String customerEmail;
    private String note;
    private String priority;
    private LocalDate birthDay;
    private int AccountID;
    private boolean sex;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, int customerPhone, String customerEmail, String note, String priority, LocalDate birthDay,int accountID, boolean sex) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.note = note;
        this.priority = priority;
        this.birthDay = birthDay;
        this.AccountID = accountID;
        this.sex = sex;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("ID : %d | Name : %s | Phone : %d | email : %s | adress : %s | birthday : %s | Note : %s | sex : %s | priority : %s | account_ID : %d",
                customerId, customerName, customerPhone, customerEmail, customerAddress, birthDay, note,
                sex ? "Nam" : "Nữ", getPriorityDescription(), AccountID);
    }

    private String getPriorityDescription() {
        switch (priority) {
            case "Khách hàng VIP":
                return "\u001B[34mKhách hàng VIP\u001B[0m";
            case "Khách hàng Tiềm năng":
                return "\u001B[33mKhách hàng Tiềm năng\u001B[0m";
            case "Khách hàng Bình thường":
                return "Khách hàng Bình thường";
            default:
                return "Không xác định";
        }
    }
}
