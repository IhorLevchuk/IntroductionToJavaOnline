package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task08.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = -7715782061593037365L;

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String creditCardNumber;
    private String bankAccountNumber;


    public Customer(int id, String name, String surname, String patronymic, String address, String creditCardNumber, String bankAccountNumber) {
        setId(id);
        setName(name);
        setSurname(surname);
        setPatronymic(patronymic);
        setAddress(address);
        setCreditCardNumber(creditCardNumber);
        setBankAccountNumber(bankAccountNumber);
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(patronymic, customer.patronymic) && Objects.equals(address, customer.address) && Objects.equals(creditCardNumber, customer.creditCardNumber) && Objects.equals(bankAccountNumber, customer.bankAccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, address, creditCardNumber, bankAccountNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }
}
