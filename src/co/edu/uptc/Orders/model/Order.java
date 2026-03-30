package co.edu.uptc.Orders.model;

import javax.swing.JOptionPane;

public abstract class Order {

    protected int numberOfOrders;
    protected String customerName;
    protected String productName;
    protected int quantity;
    protected double price;
    protected String paymentMethod;
    protected Delivery delivery;        // AGREGACIÓN
    protected PaymentDetail paymentDetail; // COMPOSICIÓN

   protected Order(int numberOfOrders, String customerName, String productName,
                int quantity, double price, String paymentMethod,
                Delivery delivery, PaymentDetail paymentDetail) {

    this.numberOfOrders = numberOfOrders;
    this.customerName = customerName;
    this.productName = productName;
    this.quantity = quantity;
    this.price = price;
    this.paymentMethod = paymentMethod;
    this.delivery = delivery;
    this.paymentDetail = paymentDetail;
}

    public int getNumberOfOrders() {
    return numberOfOrders;
}

public String getCustomerName() {
    return customerName;
}

public String getProductName() {
    return productName;
}

public int getQuantity() {
    return quantity;
}

public double getPrice() {
    return price;
}

public void setCustomerName(String customerName) {
    this.customerName = customerName;
}

public void setProductName(String productName) {
    this.productName = productName;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public void setPrice(double price) {
    this.price = price;
}

    public void displayOrderDetails() {
        JOptionPane.showMessageDialog(null, "Numero de Orden: " + numberOfOrders);
        JOptionPane.showMessageDialog(null, "Nombre del Cliente: " + customerName);
        JOptionPane.showMessageDialog(null, "Nombre del Producto: " + productName);
        JOptionPane.showMessageDialog(null, "Cantidad: " + quantity);
        JOptionPane.showMessageDialog(null, "Precio: " + price);
        JOptionPane.showMessageDialog(null, "Metodo de Pago: " + paymentMethod);
    }


    public abstract double calculateTotalPrice();

}