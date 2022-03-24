package Lohnverwaltung;

import java.util.ArrayList;
import java.util.List;

public class SalesRepresentative extends Worker {
    double commission, earnings;
    List<Contract> contractList = new ArrayList<>();
    public SalesRepresentative(String firstname, String lastname, double salary, double commission) {
        super(firstname, lastname, salary);
        this.commission = commission;
    }

    void addContract(){
        Contract temp = new Contract();
        temp.getConctractInformation();
        contractList.add(temp);
        FileHandler.write(temp, "file.jh");

    }

     double calculateEarnings(double salary, double commission){
        earnings =  contractList.size() * ((salary * commission)/100) + salary;
        return earnings;
    }

}
