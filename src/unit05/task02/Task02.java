package unit05.task02;

public class Task02 {
    public static void main(String[] args) {
        /*
        Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
         */
        Product product1 = new Product("Phone", 800);
        Product product2 = new Product("Book", 50);
        Product product3 = new Product("Laptop", 1500);

        Payment payment = new Payment();

        payment.addPurchases(product1,2);
        payment.addPurchases(product2,10);
        payment.addPurchases(product3,1);

        payment.pay();
    }
}
