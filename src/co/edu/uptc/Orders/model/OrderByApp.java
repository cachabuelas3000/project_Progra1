package co.edu.uptc.Orders.model;

import javax.swing.*;
import java.awt.*;

public class OrderByApp extends Order {

    private String appName;
    private String userAppId;
    private String deliveryTime;
    private String deliveryAddress;
    private String detalles;
    //preguntar si puedo agregar un jComboBox con la calificación del cliente 

<<<<<<< Updated upstream
   public OrderByApp(int numberOfOrders, String customerName, String productName,
                  int quantity, double price, String paymentMethod,
                  Delivery delivery, PaymentDetail paymentDetail) {
=======


    public OrderByApp(int numberOfOrders, String customerName, String productName, int quantity, double price, String paymentMethod, String appName, String userAppId) {
        super(numberOfOrders, customerName, productName, quantity, price, paymentMethod);
        this.appName = appName;
        this.userAppId = userAppId;
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;

    }
>>>>>>> Stashed changes

    super(numberOfOrders, customerName, productName, quantity, price, paymentMethod, delivery, paymentDetail);
}
    @Override
    public void displayOrderDetails() {
        // Contenedor para guardar la selección del ComboBox
        String[] selectedApp = {null};

        // Ventana modal para seleccionar la aplicación
        JDialog dialog = new JDialog((JFrame) null, "Seleccionar Aplicación", true);
        dialog.setSize(400, 150);
        dialog.setLocationRelativeTo(null);

        // Panel principal con diseño vertical
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiqueta
        JLabel label = new JLabel("Selecciona la aplicación de entrega:");
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));

        // ComboBox con opciones de apps
        String[] appOptions = {"Rappi", "Domicilios", "Uber Eats"};
        JComboBox<String> appComboBox = new JComboBox<>(appOptions);
        panel.add(appComboBox);
        panel.add(Box.createVerticalStrut(10));

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        JButton aceptarBtn = new JButton("Aceptar");
        aceptarBtn.addActionListener(e -> {
            selectedApp[0] = (String) appComboBox.getSelectedItem();
            dialog.dispose();
        });
        buttonPanel.add(aceptarBtn);
        panel.add(buttonPanel);

        dialog.add(panel);
        dialog.setVisible(true);

        // Obtener el ID de usuario
        String userAppId = JOptionPane.showInputDialog("Ingresar ID de usuario de la app:");
        
        // Mostrar todos los detalles en un solo mensaje
        detalles = "Numero de Orden: " + numberOfOrders + "\nNombre del Cliente: " + customerName 
                + "\nProducto: " + productName + "\nCantidad: " + quantity + "\nPrecio: $" + price 
                + "\nMetodo de Pago: " + paymentMethod + "\nAplicación: " + selectedApp[0] 
                + "\nID de Usuario: " + userAppId;
    }

    // Método para calcular el precio total de la orden
    @Override
    public void calculateTotalPrice() {
        double totalPrice = quantity * price;
        JOptionPane.showMessageDialog(null, detalles + "\n" +"Precio Total: $" + totalPrice);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUserAppId() {
        return userAppId;
    }

    public void setUserAppId(String userAppId) {
        this.userAppId = userAppId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }



}