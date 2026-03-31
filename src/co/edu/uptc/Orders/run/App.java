package co.edu.uptc.Orders.run;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import co.edu.uptc.Orders.model.*;

public class App {

<<<<<<< Updated upstream
    static ArrayList<Order> orders = new ArrayList<>();
=======
        OrderByApp order1 = new OrderByApp(1, "Juan Perez", "Pizza", 2, 15.99, "Tarjeta de Crédito", "Rappi", "juan123");
        order1.displayOrderDetails();
        order1.calculateTotalPrice();
>>>>>>> Stashed changes

    public static void main(String[] args) {

        int option = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "===== MENÚ =====\n" +
                    "1. Crear Orden\n" +
                    "2. Consultar Orden\n" +
                    "3. Actualizar Orden\n" +
                    "4. Eliminar Orden\n" +
                    "5. Salir"));

            switch (option) {

                case 1:
                    createOrder();
                    break;

                case 2:
                    readOrder();
                    break;

                case 3:
                    updateOrder();
                    break;

                case 4:
                    deleteOrder();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (option != 5);
    }

    //  CREAR ORDEN
    public static void createOrder() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID:"));
        String name = JOptionPane.showInputDialog("Ingrese nombre del cliente:");
        String product = JOptionPane.showInputDialog("Ingrese producto:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad:"));
        double price = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio:"));

        // 🔹 AGREGACIÓN
        Delivery delivery = new Delivery(
                1,
                JOptionPane.showInputDialog("Nombre repartidor:"),
                JOptionPane.showInputDialog("Vehículo:"),
                JOptionPane.showInputDialog("Teléfono:"),
                JOptionPane.showInputDialog("Zona:")
        );

        // 🔹 COMPOSICIÓN
        PaymentDetail payment = new PaymentDetail(
                JOptionPane.showInputDialog("Número de tarjeta:"),
                name,
                JOptionPane.showInputDialog("Fecha expiración:"),
                JOptionPane.showInputDialog("CVV:"),
                JOptionPane.showInputDialog("Banco:")
        );

        Order order = new OrderByApp(id, name, product, quantity, price, "Tarjeta", delivery, payment);

        orders.add(order);

        JOptionPane.showMessageDialog(null, "Orden creada correctamente");
    }

    //  CONSULTAR ORDEN
    public static void readOrder() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID a buscar:"));

        for (Order o : orders) {
           if (o.getNumberOfOrders() == id){
                o.displayOrderDetails();
                JOptionPane.showMessageDialog(null, "Total: $" + o.calculateTotalPrice());
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Orden no encontrada");
    }

    //  ACTUALIZAR ORDEN
    public static void updateOrder() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID a actualizar:"));

        for (Order o : orders) {
            if (o.getNumberOfOrders() == id) {

             o.setCustomerName(JOptionPane.showInputDialog("Nuevo nombre:"));
             o.setProductName(JOptionPane.showInputDialog("Nuevo producto:"));
             o.setQuantity(Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad:")));
             o.setPrice(Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:")));

          JOptionPane.showMessageDialog(null, "Orden actualizada");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Orden no encontrada");
    }

    //  ELIMINAR ORDEN
    public static void deleteOrder() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID a eliminar:"));

        for (int i = 0; i < orders.size(); i++) {
           if (orders.get(i).getNumberOfOrders() == id){
                orders.remove(i);
                JOptionPane.showMessageDialog(null, "Orden eliminada");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Orden no encontrada");
    }
}