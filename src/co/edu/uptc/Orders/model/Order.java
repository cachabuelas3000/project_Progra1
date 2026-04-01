package co.edu.uptc.Orders.model;

import javax.swing.JOptionPane;

public abstract class Order {

    protected int numberOfOrders;
    protected String customerName;
    protected String productName;
    protected int quantity;
    protected double price;
    protected String paymentMethod;

    protected Order(int numberOfOrders, String customerName, String productName, int quantity, double price,
            String paymentMethod) {
        this.numberOfOrders = ++numberOfOrders;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    // Método para mostrar los detalles de la orden
    public void displayOrderDetails() {
        JOptionPane.showMessageDialog(null, "Numero de Orden: " + numberOfOrders + "\nNombre del Cliente: "
                + customerName + "\nProducto: " + productName + "\nCantidad: " + quantity + "\nPrecio: $" + price
                + "\nMetodo de Pago: "
                + paymentMethod);
    }

    // Método para calcular el precio total de la orden
    public abstract void calculateTotalPrice();

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}