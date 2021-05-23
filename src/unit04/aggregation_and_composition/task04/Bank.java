package unit04.aggregation_and_composition.task04;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;

    public Bank() {
        this.customers = new ArrayList<>();
        this.accounts =new ArrayList<>();
    }

    public void addCustomer(int id, String name, String surname, String patronymic, String address){
        Customer newCustomer = new Customer(id, name, surname, patronymic, address);
        for(Customer customer: customers){
            if(customer.equals(newCustomer)){
                System.out.println("Аккаунт с такими данными уже существует");
                return;
            }
        }
        customers.add(newCustomer);
    }

    public void addAccount(int id, long bankAccountNumber){
        accounts.add(new Account(id, bankAccountNumber));
    }

    public void changeOfAccountAmount( long bankAccountNumber, double amount){
        findingAccount( bankAccountNumber).changeOfAccountAmount(amount);
    }

    public void accountLock( long bankAccountNumber){
        findingAccount( bankAccountNumber).accountLock();
    }

    public void accountUnlocking( long bankAccountNumber){
        findingAccount( bankAccountNumber).accountUnlocking();
    }

    public Account findingAccount( long bankAccountNumber){
        for(Account account: accounts){
            if( account.getBankAccountNumber() == bankAccountNumber){
                return account;
            }
        }
        return null;
    }

    public int getBalance(){
        int balance = 0;
        for(Account account: accounts){
            balance += account.getBalance();
        }
        return balance;
    }

    public int getPositiveBalance(){
        int balance = 0;
        for(Account account: accounts){
            if( account.getBalance() > 0){
                balance += account.getBalance();
            }
        }
        return balance;
    }

    public int getNegativeBalance(){
        int balance = 0;
        for(Account account: accounts){
            if( account.getBalance() < 0){
                balance += account.getBalance();
            }
        }
        return balance;
    }

    public String printAccounts(){
        StringBuilder allAccounts = new StringBuilder();
        for(Account account: accounts){
            allAccounts.append(account).append("\n");
        }
        return allAccounts.toString();
    }

    public void sortAccounts(){
        accounts.sort(Account::compareTo);
    }

    public ArrayList<Account> searchAccounts(int id){
        ArrayList<Account> accountArrayList = new ArrayList<>();
        for(Account account: accounts){
            if( account.getId() == id){
                accountArrayList.add(account);
            }
        }
        return accountArrayList;
    }

    public void printAccounts(ArrayList<Account> accounts){
        StringBuilder allAccounts = new StringBuilder();
        for(Account account: accounts){
            allAccounts.append(account).append("\n");
        }
        System.out.println(allAccounts.toString());
    }


    @Override
    public String toString() {
        StringBuilder allCustomer = new StringBuilder();
        for(Customer customer: customers){
            allCustomer.append(customer).append("Accounts: ").append("\n");
            for (Account account: accounts){
                if(customer.getId() == account.getId()){
                    allCustomer.append(account).append("\n");
                }
            }
            allCustomer.append("\n");
        }
        return allCustomer.toString();
    }


}
