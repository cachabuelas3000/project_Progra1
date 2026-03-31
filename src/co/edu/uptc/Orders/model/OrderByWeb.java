package co.edu.uptc.Orders.model;

public class OrderByWeb extends Order{

    private String webPlatform;
    private String deliveryMethod;
    

    public OrderByWeb(int numberOfOrders, String customerName, String productName, int quantity, double price,
            String paymentMethod) {
        super(numberOfOrders, customerName, productName, quantity, price, paymentMethod);
    }

    @Override
    public void displayOrderDetails() {
    }

    @Override
    public void calculateTotalPrice() {
    }
    

}
