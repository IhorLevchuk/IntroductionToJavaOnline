package by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.service;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Account;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Bank;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Customer;

import java.util.ArrayList;

public class BankAction {

    public void addCustomer(Bank bank, int id, String name, String surname, String patronymic, String address){
        Customer newCustomer = new Customer(id, name, surname, patronymic, address);
        for(Customer customer: bank.getCustomers()){
            if(customer.equals(newCustomer)){
                return;
            }
        }
        bank.getCustomers().add(newCustomer);
    }

    public void addAccount(Bank bank, int id, long bankAccountNumber){
        bank.getAccounts().add(new Account(id, bankAccountNumber));
    }

    public void changeOfAccountAmount(Bank bank, long bankAccountNumber, double amount){
        AccountAction.changeOfAccountAmount(findingAccount(bank, bankAccountNumber), amount);
    }

    public void accountLock(Bank bank, long bankAccountNumber){
        AccountAction.accountLock(findingAccount(bank, bankAccountNumber));
    }

    public void accountUnlocking(Bank bank, long bankAccountNumber){
        AccountAction.accountUnlocking(findingAccount(bank, bankAccountNumber));
    }

    public Account findingAccount(Bank bank, long bankAccountNumber){
        for(Account account: bank.getAccounts()){
            if( account.getBankAccountNumber() == bankAccountNumber){
                return account;
            }
        }
        return new Account();
    }

    public int getBalance(Bank bank){
        int balance = 0;
        for(Account account: bank.getAccounts()){
            balance += account.getBalance();
        }
        return balance;
    }

    public int getPositiveBalance(Bank bank){
        int balance = 0;
        for(Account account: bank.getAccounts()){
            if( account.getBalance() > 0){
                balance += account.getBalance();
            }
        }
        return balance;
    }

    public int getNegativeBalance(Bank bank){
        int balance = 0;
        for(Account account: bank.getAccounts()){
            if( account.getBalance() < 0){
                balance += account.getBalance();
            }
        }
        return balance;
    }

    public ArrayList<Account> searchAccounts(Bank bank, int id){
        ArrayList<Account> accountArrayList = new ArrayList<>();
        for(Account account: bank.getAccounts()){
            if( account.getId() == id){
                accountArrayList.add(account);
            }
        }
        return accountArrayList;
    }

    public void sortAccounts(Bank bank){
        bank.getAccounts().sort(Account::compareTo);
    }
}
