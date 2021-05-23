package unit04.aggregation_and_composition.task05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TravelAgent {
    private ArrayList<Voucher> vouchers;
    private ArrayList<Customer> customers;

    public TravelAgent() {
        this.vouchers = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addVoucher(Voucher voucher){
        vouchers.add(voucher);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public ArrayList<Voucher> getProperVoucher(TypeOfVoucher type, Transport transport, TypeOfFood food, int numberOfDays){
        return (ArrayList<Voucher>) vouchers.stream()
                .filter(v -> v.getType().equals(type) && v.getTransport().equals(transport) && v.getFood().equals(food) && v.getNumberOfDays() == numberOfDays)
                .collect(Collectors.toList());
    }

    public ArrayList<Voucher> getProperVoucher(Transport transport){
        return (ArrayList<Voucher>) vouchers.stream()
                .filter(v -> v.getTransport().equals(transport)).collect(Collectors.toList());
    }

    public ArrayList<Voucher> getProperVoucher(TypeOfFood food){
        return (ArrayList<Voucher>) vouchers.stream()
                .filter(v -> v.getFood().equals(food)).collect(Collectors.toList());
    }

    public ArrayList<Voucher> getProperVoucher(int numberOfDays){
        return (ArrayList<Voucher>) vouchers.stream()
                .filter(v -> v.getNumberOfDays() == numberOfDays).collect(Collectors.toList());
    }

    public void printVouchers(ArrayList<Voucher> vouchers){
        StringBuilder stringVouchers = new StringBuilder();
        for (Voucher voucher: vouchers){
            stringVouchers.append(voucher).append("\n");
        }
        System.out.println(stringVouchers.toString());
    }

    public ArrayList<Voucher> sortByFood(ArrayList<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getFood));
        return vouchers;
    }

    public ArrayList<Voucher> sortByTransport(ArrayList<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getTransport));
        return vouchers;
    }

    public ArrayList<Voucher> sortByType(ArrayList<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getType));
        return vouchers;
    }

    public ArrayList<Voucher> sortByPrice(ArrayList<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getPrice));
        return vouchers;
    }

}
