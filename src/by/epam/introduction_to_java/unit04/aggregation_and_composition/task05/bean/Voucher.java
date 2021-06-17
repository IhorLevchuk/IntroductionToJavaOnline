package by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.bean;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.enumeration.Transport;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.enumeration.TypeOfFood;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.enumeration.TypeOfVoucher;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Voucher implements Serializable {
    @Serial
    private static final long serialVersionUID = 4617296486891910139L;

    private TypeOfVoucher type;
    private Transport transport;
    private TypeOfFood food;
    private int numberOfDays;
    private double price;
    private int idOfVoucher;

    public Voucher(TypeOfVoucher type, Transport transport, TypeOfFood food, int numberOfDays, double price,int idOfVoucher) {
        this.type = type;
        this.transport = transport;
        this.food = food;
        this.numberOfDays = numberOfDays;
        this.price = price;
        this.idOfVoucher = idOfVoucher;
    }

    public Voucher() {
    }

    public TypeOfVoucher getType() {
        return type;
    }

    public Transport getTransport() {
        return transport;
    }

    public TypeOfFood getFood() {
        return food;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Voucher(" + idOfVoucher + "):\n" +
                "Type: " + type + "\n" +
                "Transport: " + transport + "\n" +
                "Food: " + food + "\n" +
                "Number of days: " + numberOfDays + "\n" +
                "Price: " + price + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return numberOfDays == voucher.numberOfDays && Double.compare(voucher.price, price) == 0 && idOfVoucher == voucher.idOfVoucher && type == voucher.type && transport == voucher.transport && food == voucher.food;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, transport, food, numberOfDays, price, idOfVoucher);
    }
}
