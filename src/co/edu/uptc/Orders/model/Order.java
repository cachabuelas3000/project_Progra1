package co.edu.uptc.Orders.model;

import javax.swing.JOptionPane;

public abstract class Order {

    protected int numberOfOrders;
    protected String customerName;
    protected String productName;
    protected int quantity;
    protected double price;
    protected String paymentMethod;


    protected Order(int numberOfOrders, String customerName, String productName, int quantity, double price, String paymentMethod) {
        this.numberOfOrders = numberOfOrders;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.paymentMethod = paymentMethod;
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