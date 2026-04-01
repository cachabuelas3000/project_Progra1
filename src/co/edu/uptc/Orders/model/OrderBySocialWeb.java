package co.edu.uptc.Orders.model;

import javax.swing.*;
import java.awt.*;

public class OrderBySocialWeb extends Order {

    private String webPlatform;
    private String deliveryMethod;

    public OrderBySocialWeb(int numberOfOrders, String customerName, String productName, int quantity, double price,
            String paymentMethod) {
        super(numberOfOrders, customerName, productName, quantity, price, paymentMethod);
        this.webPlatform = webPlatform;
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public void displayOrderDetails() {
        // hago un nuevo contenedor que guarde la selección del ComboBox
        String[] selectedWeb = { null };

        // hago la ventana modal para seleccionar la plataforma web
        JDialog dialog = new JDialog((JFrame) null, "Seleccionar Nombre de la Plataforma Web", true);
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(null);

        // hago un panel principal con diseño vertical
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // hago una etiqueta
        JLabel label = new JLabel("Desde que red social nos visitas: ");
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));

        // hago el ComboBox con las opciones de redes sociales
        String[] socialWepOptions = { "Facebook", "Instagram", "YouTube", "TikTok", "X" };
        JComboBox<String> socialWebComboBox = new JComboBox<>(socialWepOptions);
        panel.add(socialWebComboBox);
        panel.add(Box.createVerticalStrut(10));

        // panel para botones
        JPanel buttonPanel = new JPanel();
        JButton aceptarBtn = new JButton("Aceptar");
        aceptarBtn.addActionListener(k -> {
            selectedWeb[0] = (String) socialWebComboBox.getSelectedItem();
            dialog.dispose();
        });
        buttonPanel.add(aceptarBtn);
        panel.add(buttonPanel);

        dialog.add(panel);
        dialog.setVisible(true);

        // preparamos todos los datos y los mostramos en el metodo de calcular precio
        String detailOrder = "Numero de Orden: " + numberOfOrders + "\nNombre del Cliente: " + customerName
                + "\nProducto: " + productName + "\nCantidad: " + quantity + "\nPrecio: $" + price
                + "\nMetodo de Pago: " + paymentMethod + "\nAplicación: " + selectedWeb[0];

    }

    @Override
    public void calculateTotalPrice() {
        // ComboBox para seleccionar método de entrega
        String[] deliveryOptions = { "Recoger pedido", "Entrega a domicilio" };
        JComboBox<String> deliveryComboBox = new JComboBox<>(deliveryOptions);

        int option = JOptionPane.showConfirmDialog(
                null,
                deliveryComboBox,
                "Selecciona el método de entrega",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String selectedDelivery = (String) deliveryComboBox.getSelectedItem();
            double subtotal = quantity * price;
            double deliveryFee = 6000;
            double totalPrice;
            String message;

            if (selectedDelivery.equals("Recoger pedido")) {
                totalPrice = subtotal;
                message = "Numero de Orden: " + numberOfOrders +
                        "\nNombre del Cliente: " + customerName +
                        "\nProducto: " + productName +
                        "\nCantidad: " + quantity +
                        "\nPrecio unitario: $" + price +
                        "\nMétodo de Pago: " + paymentMethod +
                        "\nMétodo de Entrega: " + selectedDelivery +
                        "\n\n=== CÁLCULO ===" +
                        "\nPrecio Total: $" + totalPrice;
            } else { // Entrega a domicilio
                totalPrice = subtotal + deliveryFee;
                message = "Numero de Orden: " + numberOfOrders +
                        "\nNombre del Cliente: " + customerName +
                        "\nProducto: " + productName +
                        "\nCantidad: " + quantity +
                        "\nPrecio unitario: $" + price +
                        "\nMétodo de Pago: " + paymentMethod +
                        "\nMétodo de Entrega: " + selectedDelivery +
                        "\n\n=== CÁLCULO ===" +
                        "\nPrecio: $" + subtotal +
                        "\nValor del domicilio: $" + deliveryFee +
                        "\nPrecio Total: $" + totalPrice;
            }

            JOptionPane.showMessageDialog(null, message, "Resumen de la Orden", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String getWebPlatform() {
        return webPlatform;
    }

    public void setWebPlatform(String webPlatform) {
        this.webPlatform = webPlatform;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

}
