package by.epam.introduction_to_java.unit05.task02.main;

import by.epam.introduction_to_java.unit05.task02.bean.Payment;
import by.epam.introduction_to_java.unit05.task02.bean.Product;
import by.epam.introduction_to_java.unit05.task02.service.PaymentAction;
import by.epam.introduction_to_java.unit05.task02.view.PaymentView;

public class Task02 {
    public static void main(String[] args) {
        /*
        Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
         */
        PaymentView paymentView = new PaymentView();
        PaymentAction paymentAction = new PaymentAction();

        Product product1 = new Product("Phone", 800);
        Product product2 = new Product("Book", 50);
        Product product3 = new Product("Laptop", 1500);

        Payment payment = new Payment();

        paymentAction.addPurchase(payment, product1,2);
        paymentAction.addPurchase(payment, product2,10);
        paymentAction.addPurchase(payment, product3,1);

        paymentView.printOnConsole(payment);

    }
}
