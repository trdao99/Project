package ra.business.ipl;

import ra.business.design.IUser_PROJECT;
import ra.business.entity.Contract;
import ra.utils.IOFile;

import java.util.List;

import static ra.presentation.Main.Login;

public class UserProjectManagerIpL implements IUser_PROJECT {
    List<Contract> contractList = IOFile.readFromFile(IOFile.CONTRACT_PATH);
    @Override
    public void displayContract() {
        for (Contract contract : contractList) {
            if(Login.get(0).getId() == contract.getCustomerId()){
                System.out.println(contract);
            }
        }
    }

    @Override
    public void displayProject() {

    }
}
