package unit05.task02;

import java.util.ArrayList;

public class Payment {
    private double totalPrice;
    private Receipt receipt;

    public Payment() {
        receipt = new Receipt();
    }
    public void pay(){
        System.out.println(receipt.toString());
    }

    public void addPurchases(Product product, int quantity){
        receipt.addPurchases(product,quantity);
    }

    class Receipt {
        private ArrayList<Purchase> purchases;

        Receipt() {
            purchases = new ArrayList<>();
        }

        void addPurchases(Product product, int quantity){
            Purchase purchase = new Purchase(product,quantity);
            totalPrice += purchase.pricePurchase;
            purchases.add(purchase);
        }

        @Override
        public String toString() {
            StringBuilder receipt = new StringBuilder();
            receipt.append("Receipt").append("\n");
            for(Purchase purchase: purchases){
                receipt.append(purchase).append("\n").append("\n");
            }
            receipt.append("Total price: ").append(totalPrice).append("\n");
            return receipt.toString();
        }

        class Purchase{
            private final Product product;
            private final int quantity;
            private final double pricePurchase;

            public Purchase(Product product, int quantity) {
                this.product = product;
                this.quantity = quantity;
                pricePurchase = product.getPrice()*quantity;
            }

            @Override
            public String toString() {
                return product + "\n" +
                        product.getPrice() + "x" + quantity + "=" + pricePurchase;
            }
        }

    }

}
