package ra.business.ipl;

import ra.business.design.IUser_PROJECT;
import ra.business.entity.Contract;
import ra.business.entity.Customer;
import ra.business.entity.Project;
import ra.utils.IOFile;

import java.io.Serializable;
import java.util.List;

import static ra.presentation.Main.Login;

public class UserProjectManagerIpL implements IUser_PROJECT, Serializable {
    List<Contract> contractList = IOFile.readFromFile(IOFile.CONTRACT_PATH);
    List<Customer> managerCustomer = IOFile.readFromFile(IOFile.CUSTOMER_PATH);
    List<Project> projectList = IOFile.readFromFile(IOFile.PROJECT_PATH);
    @Override
    public void displayContract() {
        for (Customer customer : managerCustomer) {
            if(customer.getAccountID() == Login.get(0).getId()){
                for (Contract contract : contractList) {
                    if(customer.getCustomerId() == contract.getCustomerId()){
                        System.out.println(contract);
                    }
                }
                break;
            }
        }
    }

    @Override
    public void displayProject() {
        for (Customer customer : managerCustomer) {
            if(customer.getAccountID() == Login.get(0).getId()){
                for (Contract contract : contractList) {
                    if(customer.getCustomerId() == contract.getCustomerId()){
                        for (Project project : projectList) {
                            if(project.getContractId() == contract.getContractId()){
                                System.out.println(project);
                            }
                        }
                    }
                }
                break;
            }
        }
    }
}
