package co.edu.uptc.Orders.model;

import javax.swing.*;

public class OrderByApp extends Order {

    private String appName;
    private String userAppId;

    public OrderByApp(String customerName, String customerCC,
                      String food, int qtyFood, int foodPrice,
                      String drink, int qtyDrink, int drinkPrice,
                      int total,
                      String deliveryType, String deliveryAddress, String deliveryZone,
                      Delivery deliveryAssigned, PaymentDetail payment,
                      String appName, String userAppId) {

        super(customerName, customerCC, food, qtyFood, foodPrice,
              drink, qtyDrink, drinkPrice, total,
              deliveryType, deliveryAddress, deliveryZone, deliveryAssigned, payment);

        this.appName = appName;
        this.userAppId = userAppId;
    }

    @Override
    public void displayOrderDetails() {

        String msg =
                "===== FACTURA =====\n" +
                "Pedido por App: " + appName +

                "\n\nCliente: " + customerName +
                "\nCédula: " + customerCC +

                "\n\nCOMIDA:\n" +
                food + " = " + foodPrice +
                "\nCantidad: " + qtyFood +
                "\nSubtotal: " + (foodPrice * qtyFood) +

                "\n\nBEBIDA:\n" +
                drink + " = " + drinkPrice +
                "\nCantidad: " + qtyDrink +
                "\nSubtotal: " + (drinkPrice * qtyDrink) +

                "\n\nMÉTODO DE PAGO: " + payment.getMethod() +
(payment.getMethod().equals("Tarjeta") ? "\nTarjeta: " + payment.getCardNumber() : "") +
(payment.getMethod().equals("Transferencia") ? "\nBanco: " + payment.getBank() : "") +

"\n\nTOTAL: $" + total;

        JOptionPane.showMessageDialog(null, msg);
    }
}