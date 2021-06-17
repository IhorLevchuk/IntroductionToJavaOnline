package by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TravelAgent implements Serializable {
    @Serial
    private static final long serialVersionUID = -3270225560408182915L;

    private List<Voucher> vouchers;
    private List<Customer> customers;

    public TravelAgent() {
        this.vouchers = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addVoucher(Voucher voucher){
        vouchers.add(voucher);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgent that = (TravelAgent) o;
        return Objects.equals(vouchers, that.vouchers) && Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vouchers, customers);
    }

    @Override
    public String toString() {
        return "TravelAgent{" +
                "vouchers=" + vouchers +
                ", customers=" + customers +
                '}';
    }
}
