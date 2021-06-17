package by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.view;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Account;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Bank;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Customer;

public class BankView {
//    public void printAccounts(Bank bank){
//        StringBuilder allAccounts = new StringBuilder();
//        for(Account account: bank.getAccounts()){
//            allAccounts.append(account).append("\n");
//        }
//        System.out.println(allAccounts.toString());
//    }

    public String getCustomers(Bank bank) {
        StringBuilder allCustomer = new StringBuilder();
        for(Customer customer: bank.getCustomers()){
            allCustomer.append(customer).append("Accounts: ").append("\n");
            for (Account account: bank.getAccounts()){
                if(customer.getId() == account.getId()){
                    allCustomer.append(account).append("\n");
                }
            }
            allCustomer.append("\n");
        }
        return allCustomer.toString();
    }

    public String getAccounts(Bank bank){
        StringBuilder allAccounts = new StringBuilder();
        for(Account account: bank.getAccounts()){
            allAccounts.append(account).append("\n");
        }
        return allAccounts.toString();
    }

}
