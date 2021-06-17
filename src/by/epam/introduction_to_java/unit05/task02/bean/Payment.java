package by.epam.introduction_to_java.unit05.task02.bean;


import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = -5744030154398027503L;

    private List<Purchase> purchases;
    private double totalPrice;

    public Payment() {
        purchases = new ArrayList<>();
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.totalPrice, totalPrice) == 0 && Objects.equals(purchases, payment.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchases, totalPrice);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "purchases=" + purchases +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static class Purchase implements Serializable{
        @Serial
        private static final long serialVersionUID = -9312065840037052L;

        private Product product;
        private int quantity;
        private double pricePurchase;

        public Purchase(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
            pricePurchase = product.getPrice()*quantity;
        }

        public Purchase() {
        }

        public double getPricePurchase() {
            return pricePurchase;
        }

        @Override
        public String toString() {
            return product + "\n" +
                    product.getPrice() + "x" + quantity + "=" + pricePurchase;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Purchase purchase = (Purchase) o;
            return quantity == purchase.quantity && Double.compare(purchase.pricePurchase, pricePurchase) == 0 && Objects.equals(product, purchase.product);
        }

        @Override
        public int hashCode() {
            return Objects.hash(product, quantity, pricePurchase);
        }
    }
}
