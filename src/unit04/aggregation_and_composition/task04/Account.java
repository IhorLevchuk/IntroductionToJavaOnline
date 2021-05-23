package unit04.aggregation_and_composition.task04;


public class Account implements Comparable<Account> {
    private final long bankAccountNumber;
    private double balance;
    private boolean accessibility;
    private int id;

    public Account(int id, long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        this.id = id;
        this.accessibility = true;
        this.balance = 0;
    }

    @Override
    public String toString() {
        return  bankAccountNumber + " Balance: " + balance + " Accessibility: " + accessibility + " ID: " + id;
    }

    @Override
    public int compareTo(Account o) {
        if (this.balance == o.balance) {
            return 0;
        } else if (this.balance < o.balance) {
            return -1;
        } else {
            return 1;
        }
    }

    public void changeOfAccountAmount(double amount){
        if(accessibility == true){
            balance += amount;
        }
    }

    public void accountLock(){
        accessibility = false;
    }

    public void accountUnlocking(){
        accessibility = true;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
