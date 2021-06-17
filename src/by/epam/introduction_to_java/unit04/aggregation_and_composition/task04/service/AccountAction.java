package by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.service;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Account;

public class AccountAction {
    public static void changeOfAccountAmount(Account account, double amount){
        if(account.isAccessibility()){
            account.setBalance(account.getBalance()+amount);
        }
    }

    public static void accountLock(Account account){
        account.setAccessibility(false);
    }

    public static void accountUnlocking(Account account){
        account.setAccessibility(true);
    }
}
