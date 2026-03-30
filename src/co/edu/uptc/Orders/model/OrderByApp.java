package co.edu.uptc.Orders.model;

public class OrderByApp extends Order {

    private String appName;

    public OrderByApp(int numberOfOrders, String customerName, String productName, int quantity, double price, String paymentMethod) {
        super(numberOfOrders, customerName, productName, quantity, price, paymentMethod);
    }

    @Override
    public double calculateTotalPrice() {
        return quantity * price;
    }



}
