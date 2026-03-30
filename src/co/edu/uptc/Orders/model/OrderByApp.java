package co.edu.uptc.Orders.model;

public class OrderByApp extends Order {

    private String appName;

   public OrderByApp(int numberOfOrders, String customerName, String productName,
                  int quantity, double price, String paymentMethod,
                  Delivery delivery, PaymentDetail paymentDetail) {

    super(numberOfOrders, customerName, productName, quantity, price, paymentMethod, delivery, paymentDetail);
}
    @Override
    public double calculateTotalPrice() {
        return quantity * price;
    }



}
