package ra.business.ipl;

import ra.business.design.Imanager_CUSTOMER;
import ra.business.entity.Customer;
import ra.business.entity.User;
import ra.utils.IOFile;
import ra.utils.InputMethods;
import ra.utils.Pagination;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static ra.business.entity.Enum.USER;
import static ra.utils.IOFile.USER_PATH;

public class ManagerIplCustomer implements Imanager_CUSTOMER {
    List<Customer> managerCustomer = IOFile.readFromFile(IOFile.CUSTOMER_PATH);
    List<User> userList = IOFile.readFromFile(USER_PATH);
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;

    @Override
    public void addData() {
        System.out.println("nhấp số lượng muốn thêm:");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            managerCustomer.add(inputData());
            IOFile.writeToFile(IOFile.CUSTOMER_PATH, managerCustomer);
        }
    }

    @Override
    public void displayData() {
        Pagination.pagination(managerCustomer);
    }

    @Override
    public void updateData() {
        System.out.println("nhập ID khách hàng muốn thay đổi");
        int id = InputMethods.getInteger();
        for (int i = 0; i < managerCustomer.size(); i++) {
            if (managerCustomer.get(i).getCustomerId() == id) {
                flag = false;
                managerCustomer.set(i, inputData());
                managerCustomer.get(i).setCustomerId(id);
                IOFile.writeToFile(IOFile.CUSTOMER_PATH, managerCustomer);
                break;
            }
        }
    }

    @Override
    public void delData() {
        System.out.println("nhập ID khách hàng muốn xoa");
        int id = InputMethods.getInteger();
        for (Customer customer : managerCustomer) {
            if (customer.getCustomerId() == id) {
                managerCustomer.remove(customer);
                IOFile.writeToFile(IOFile.CUSTOMER_PATH, managerCustomer);
                break;
            }
        }
    }

    @Override
    public void searchData() {
        System.out.println("nhập tên khách hàng muốn tìm ");
        String nameFind = InputMethods.getString().toLowerCase();
        for (Customer customer : managerCustomer) {
            if (customer.getCustomerName().toLowerCase().equals(nameFind)) {
                System.out.println(customer);
                break;
            }
        }
    }

    Customer inputData() {
        Customer customer = new Customer();
        if (flag) {
            customer.setCustomerId(getNewId());
        }
        System.out.println("nhập tên:");
        customer.setCustomerName(InputMethods.getString());
        System.out.println("nhập địa chỉ:");
        customer.setCustomerAddress(InputMethods.getString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.println("nhập ngày sinh:");
                customer.setBirthDay(LocalDate.parse(InputMethods.getString(), dtf));
                break;
            } catch (DateTimeException e) {
                System.err.println("nhập đúng định dạng (dd/MM/yyyy)");
            }
        }
        System.out.println("sex:");
        customer.setSex(InputMethods.getBoolean());
        System.out.println("Note:");
        customer.setNote(InputMethods.getString());
        while (true) {
            System.out.println("email: ");
            String email = InputMethods.getString();
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

            if (email.matches(emailRegex)) {
                customer.setCustomerEmail(email);
                break;
            } else {
                System.err.println("sai định dạng");
            }
        }
        while (true) {
            System.out.println("phone: ");
            String phone = InputMethods.getString();
            String phoneNumberRegex = "^(\\+?84|0)\\d{9,10}$";
            if (phone.matches(phoneNumberRegex)) {
                try {
                    Integer.parseInt(phone);
                    customer.setCustomerPhone(Integer.parseInt(phone));
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("sai định dạng ");
                }

            } else {
                System.err.println("sai định dạng");
            }
        }
        System.out.println("Chọn độ ưu tiên:");
        System.out.println("1. Khách hàng VIP");
        System.out.println("2. Khách hàng Tiềm năng");
        System.out.println("3. Khách hàng Bình thường");
        int priorityChoice = InputMethods.getInteger();

        switch (priorityChoice) {
            case 1:
                customer.setPriority("Khách hàng VIP");
                break;
            case 2:
                customer.setPriority("Khách hàng Tiềm năng");
                break;
            case 3:
                customer.setPriority("Khách hàng Bình thường");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Độ ưu tiên mặc định là bình thường.");
                customer.setPriority("Khách hàng Bình thường");
                break;
        }
        System.out.println("chọn ID tài khoản liên kết  :");
        boolean checkAcc = true;
        userList.stream().filter(v -> v.getRole().equals(USER)).forEach(System.out::println);
        int choiceAcc = InputMethods.getInteger();
        for (User user : userList) {
            if (user.getId() == choiceAcc) {
                customer.setAccountID(user.getId());
                checkAcc = false;
                break;
            }
        }
        if(checkAcc){
            customer.setAccountID(-1);
        }
        return customer;
    }

    private int getNewId() {
        int max = managerCustomer.stream().map(Customer::getCustomerId).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }
}
