package ra.business.ipl;

import ra.business.design.IContract;
import ra.business.entity.Contract;
import ra.business.entity.Customer;
import ra.business.entity.Employee;
import ra.utils.IOFile;
import ra.utils.InputMethods;

import java.util.List;
import java.util.Scanner;

public class ManagerIpl_CONTRACT implements IContract {
    List<Contract> contractList = IOFile.readFromFile(IOFile.CONTRACT_PATH);
    Scanner sc = new Scanner(System.in);
    boolean flag = true;

    @Override
    public void delData() {

    }

    @Override
    public void displayData() {
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void addData() {
        System.out.println("nhấp số lượng muốn thêm:");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            contractList.add(inputData());
            IOFile.writeToFile(IOFile.CONTRACT_PATH, contractList);
        }
    }

    @Override
    public void searchData() {
        System.out.println("nhập ten hợp đồng muốn tìm ");
        String nameFind = InputMethods.getString().toLowerCase();
        for (Contract c : contractList) {
            if (c.getContractName().toLowerCase().equals(nameFind)) {
                System.out.println(c);
                break;
            }
        }
    }

    @Override
    public void updateData() {
        System.out.println("nhập ID hợp đồng muốn thay đổi");
        int id = InputMethods.getInteger();
        for (int i = 0; i < contractList.size(); i++) {
            if (contractList.get(i).getCustomerId() == id) {
                flag = false;
                contractList.set(i, inputData());
                contractList.get(i).setContractId(id);
                IOFile.writeToFile(IOFile.CONTRACT_PATH, contractList);
                break;
            }
        }
    }

    Contract inputData() {
        List<Customer> managerCustomer = IOFile.readFromFile(IOFile.CUSTOMER_PATH);
        List<Employee> managerEmployee = IOFile.readFromFile(IOFile.EMPLOYEE_PATH);
        Contract contract = new Contract();
        contract.inputContractId();
        contract.inputContractName();
        contract.inputCustomerId(managerCustomer);
        contract.inputEmployeeId(managerEmployee);
        contract.inputTotalAmount();
        contract.inputDescription();
        contract.inputCreatedDate();
        contract.inputExpiryDate();
        contract.inputPriority();
        return contract;
    }
}
