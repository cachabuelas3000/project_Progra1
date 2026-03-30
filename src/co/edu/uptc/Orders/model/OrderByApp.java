package co.edu.uptc.Orders.model;

public class OrderByApp extends Order {

    private String appName;

    public OrderByApp(int numberOfOrders, String customerName, String paymentMethod, String productName, int quantity, double price) {
        super(numberOfOrders, customerName, paymentMethod, productName, quantity, price);
    }

    @Override
    public double calculateTotalPrice() {
        return quantity * price;
    }



}
