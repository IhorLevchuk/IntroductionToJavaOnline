package by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = 428015031728671466L;

    private String name;
    private String surname;
    private int idOfVoucher;

    public Customer(String name, String surname, int idOfVoucher) {
        this.name = name;
        this.surname = surname;
        this.idOfVoucher = idOfVoucher;
    }

    public Customer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return idOfVoucher == customer.idOfVoucher && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, idOfVoucher);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[name='" + name +
                "][surname='" + surname +
                "][idOfVoucher=" + idOfVoucher + "]";
    }
}
