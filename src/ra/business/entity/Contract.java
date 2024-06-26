package ra.business.entity;

import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Contract implements Serializable {
    private int contractId;
    private String contractName;
    private int employeeID;
    private int customerId;
    private LocalDate createdDate;
    private LocalDate expiryDate;
    private float totalAmount;
    private String description;
    private int priority;
    private boolean status;

    public Contract() {
    }

    public Contract(int contractId, String contractName, int employeeID, int customerId, LocalDate createdDate, LocalDate expiryDate, float totalAmount, String description, int priority, boolean status) {
        this.contractId = contractId;
        this.contractName = contractName;
        this.employeeID = employeeID;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.expiryDate = expiryDate;
        this.totalAmount = totalAmount;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void inputContractId() {
        List<Contract> contractList = IOFile.readFromFile(IOFile.CONTRACT_PATH);
        boolean checkID = true;
        while (true) {
            System.out.println("Nhập mã hợp đồng:");
            Byte newID = InputMethods.getByte();
            if (contractList != null) {
                for (Contract contract : contractList) {
                    if (contract.getContractId() == contractId) {
                        checkID = false;
                        System.err.println("ID đã tồn tại");
                    }
                }
                if (checkID) {
                    this.contractId = newID;
                    break;
                }
            }
            else{
                this.contractId = newID;
                break;
            }
        }
    }

    public void inputContractName() {
        System.out.println("Nhập tên hợp đồng:");
        this.contractName = InputMethods.getString();
    }

    // Hàm để nhập mã nhân viên từ danh sách nhân viên
    public void inputEmployeeId(List<Employee> employees) {
        // Hiển thị danh sách nhân viên
        System.out.println("chọn nhân viên phụ trách theo ID:");
        for (Employee e : employees) {
            System.out.println(e);
        }
        // Nhận lựa chọn từ người dùng
        int choice = InputMethods.getInteger();
        // Đặt mã nhân viên dựa trên lựa chọn của người dùng
        for (Employee employee : employees) {
            if (employee.getEmployeeid() == choice) {
                this.employeeID = employee.getEmployeeid();
            }
        }
    }

    // Hàm để nhập mã khách hàng từ danh sách khách hàng
    public void inputCustomerId(List<Customer> customers) {
        System.out.println("chọn khách hàng theo ID:");
        for (Customer c : customers) {
            System.out.println(c);
        }
        // Nhận lựa chọn từ người dùng
        int choice = InputMethods.getInteger();
        // Đặt khách hàng dựa trên lựa chọn của người dùng
        for (Customer customer : customers) {
            if (customer.getCustomerId() == choice) {
                this.customerId = customer.getCustomerId();
            }
        }
    }

    public void inputCreatedDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.println("Nhập ngày kí (dd/MM/yyyy):");
                this.setCreatedDate(LocalDate.parse(InputMethods.getString(), dtf));
                break;
            } catch (DateTimeException e) {
                System.err.println("Nhập đúng định dạng (dd/MM/yyyy)");
            }
        }
    }


    public void inputExpiryDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.println("Nhập ngày hết hạn (dd/MM/yyyy):");
                this.setExpiryDate(LocalDate.parse(InputMethods.getString(), dtf));
                break;
            } catch (DateTimeException e) {
                System.err.println("Nhập đúng định dạng (dd/MM/yyyy)");
            }
        }
    }

    public void inputTotalAmount() {
        System.out.println("Nhập tổng tiền:");
        this.totalAmount = InputMethods.getFloat();
    }

    public void inputDescription() {
        System.out.println("Nhập mô tả:");
        this.description = InputMethods.getString();
    }

    public void inputPriority() {
        System.out.println("Chọn độ ưu tiên:");
        System.out.println("1. Hight");
        System.out.println("2. Medium");
        System.out.println("3. Low");
        int priorityChoice = InputMethods.getInteger();

        switch (priorityChoice) {
            case 1:
                this.priority = 1;
                break;
            case 2:
                this.priority = 2;
                break;
            case 3:
                this.priority = 3;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Độ ưu tiên mặc định là bình thường.");
                this.priority = 3;
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("Mã hợp đồng: %d | Tên hợp đồng: %s | Nhân viên phụ trách: %d | Khách hàng: %d - %s | Ngày kí: %s | Ngày hết hạn: %s | Tổng tiền: %.2f | Mô tả: %s | Độ ưu tiên: %d | trạng thái : %s | Loại hợp đồng: %s\n",
                contractId, contractName, employeeID, customerId,
                getCustomerName(),
                createdDate,
                expiryDate,
                totalAmount,
                description,
                priority, status ? "đang thực hiện" : "đã hoàn thành", getPriorityDescription());
    }

    private String getPriorityDescription() {
        switch (priority) {
            case 1:
                return "\u001B[34mHigh\u001B[0m";
            case 2:
                return "\u001B[33mMedium\u001B[0m";
            case 3:
                return "Low";
            default:
                return "Không xác định";
        }
    }

    public boolean InputStatus() {
        System.out.println("chọn status (1:đang thực hiện / 2: đã hoàn thành )");
        int statusChoice = InputMethods.getInteger();
        return switch (statusChoice) {
            case 1 -> this.status = true;
            case 2 -> this.status = false;
            default -> {
                System.out.println("mặc định chọn (đang thực hiện)");
                yield this.status = false;
            }
        };
    }

    private String getCustomerName() {
        List<Customer> managerCustomer = IOFile.readFromFile(IOFile.CUSTOMER_PATH);
        for (Customer c : managerCustomer) {
            if (c.getCustomerId() == customerId) {
                return c.getCustomerName();
            }
        }
        return null;
    }
}