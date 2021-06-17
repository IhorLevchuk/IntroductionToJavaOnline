package by.epam.introduction_to_java.unit05.task02.view;

import by.epam.introduction_to_java.unit05.task02.bean.Payment;

public class PaymentView {
        public void printOnConsole(Payment payment) {
            StringBuilder receiptToString = new StringBuilder();
            receiptToString.append("Receipt").append("\n");
            for(Payment.Purchase purchase: payment.getPurchases()){
                receiptToString.append(purchase).append("\n").append("\n");
            }
            receiptToString.append("Total price: ").append(payment.getTotalPrice()).append("\n");
            System.out.println(receiptToString);
        }
}
