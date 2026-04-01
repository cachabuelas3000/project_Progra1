package co.edu.uptc.Orders.model;

import javax.swing.*;

public class OrderBySocialWeb extends Order {

    private String socialPlatform;

    public OrderBySocialWeb(String customerName, String customerCC,
                            String food, int qtyFood, int foodPrice,
                            String drink, int qtyDrink, int drinkPrice,
                            int total,
                            String deliveryType, String deliveryAddress, String deliveryZone,
                            Delivery deliveryAssigned, PaymentDetail payment,
                            String socialPlatform) {

        super(customerName, customerCC, food, qtyFood, foodPrice,
              drink, qtyDrink, drinkPrice, total,
              deliveryType, deliveryAddress, deliveryZone, deliveryAssigned, payment);

        this.socialPlatform = socialPlatform;
    }

    @Override
    public void displayOrderDetails() {

        String msg =
                "===== FACTURA =====\n" +
                "Pedido por: " + socialPlatform +

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