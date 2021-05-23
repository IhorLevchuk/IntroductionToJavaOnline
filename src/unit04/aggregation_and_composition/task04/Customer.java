package unit04.aggregation_and_composition.task04;

import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(patronymic, customer.patronymic) && Objects.equals(address, customer.address);
    }


    public Customer(int id ,String name, String surname, String patronymic, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder customer = new StringBuilder();
        customer.append("Customer: ").append(surname).append(" ").append(name).append(" ").append(patronymic)
                .append("\n").append("ID: ").append(id).append("\n");
        return customer.toString();
    }

    public int getId() {
        return id;
    }

}
