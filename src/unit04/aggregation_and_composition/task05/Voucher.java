package unit04.aggregation_and_composition.task05;

public class Voucher{
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


    @Override
    public String toString() {
        return "Voucher(" + idOfVoucher + "):\n" +
                "Type: " + type + "\n" +
                "Transport: " + transport + "\n" +
                "Food: " + food + "\n" +
                "Number of days: " + numberOfDays + "\n" +
                "Price: " + price + "\n";
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
}
