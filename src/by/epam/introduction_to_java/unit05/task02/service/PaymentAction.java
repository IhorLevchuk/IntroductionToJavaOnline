package by.epam.introduction_to_java.unit05.task02.service;

import by.epam.introduction_to_java.unit05.task02.bean.Payment;
import by.epam.introduction_to_java.unit05.task02.bean.Product;

public class PaymentAction {
    public void addPurchase(Payment payment, Product product, int quantity){
        Payment.Purchase purchase = new Payment.Purchase(product,quantity);
        payment.setTotalPrice(payment.getTotalPrice()+purchase.getPricePurchase());
        payment.getPurchases().add(purchase);
    }
}
