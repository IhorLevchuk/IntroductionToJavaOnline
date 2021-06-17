package by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean;


import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Account implements Comparable<Account>, Serializable {
    @Serial
    private static final long serialVersionUID = -2911975688676557527L;

    private long bankAccountNumber;
    private double balance;
    private boolean accessibility;
    private int id;

    public Account(int id, long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        this.id = id;
        this.accessibility = true;
        this.balance = 0;
    }

    public Account() {
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

    public void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isAccessibility() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[bankAccountNumber=" + bankAccountNumber +
                "][balance=" + balance +
                "][accessibility=" + accessibility +
                "][id=" + id + "]";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return bankAccountNumber == account.bankAccountNumber && Double.compare(account.balance, balance) == 0 && accessibility == account.accessibility && id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountNumber, balance, accessibility, id);
    }
}
