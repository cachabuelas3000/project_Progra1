package co.edu.uptc.Orders.run;

import javax.swing.*;
import java.util.ArrayList;
import co.edu.uptc.Orders.model.*;

public class App {

    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Delivery> deliveries = new ArrayList<>();

    public static void main(String[] args) {

        int option;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(
                        "===== MENÚ =====\n" +
                        "1. Crear registro\n" +
                        "2. Consultar registro\n" +
                        "3. Actualizar registro\n" +
                        "4. Eliminar registro\n" +
                        "5. Salir"));
            } catch (Exception e) { option = 0; }

            switch(option) {
                case 1: createRecord(); break;
                case 2: readRecord(); break;
                case 3: updateRecord(); break;
                case 4: deleteRecord(); break;
                case 5: JOptionPane.showMessageDialog(null,"Saliendo..."); break;
                default: JOptionPane.showMessageDialog(null,"Opción inválida");
            }

        } while(option != 5);
    }

    // MÉTODO DE CÁLCULO
    public static int calculateTotal(int foodPrice, int qtyFood, int drinkPrice, int qtyDrink) {
        return (foodPrice * qtyFood) + (drinkPrice * qtyDrink);
    }

    // ================= CREAR =================
    public static void createRecord() {

        String[] options = {"Delivery", "Cliente"};
        String choice = (String) JOptionPane.showInputDialog(null, "Seleccione tipo de registro",
                "Crear Registro", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // ===== DELIVERY =====
        if(choice.equals("Delivery")) {

            String cc = JOptionPane.showInputDialog("Cédula del Delivery:");
            String name = JOptionPane.showInputDialog("Nombre:");

            String[] vehicleOptions = {"Moto","Carro"};
            String vehicle = (String) JOptionPane.showInputDialog(null, "Vehículo",
                    "Seleccione vehículo", JOptionPane.QUESTION_MESSAGE, null, vehicleOptions, vehicleOptions[0]);

            String phone = JOptionPane.showInputDialog("Número de teléfono:");

            String[] zoneOptions = {"Norte","Sur","Este","Oeste","Todas las zonas"};
            String zone = (String) JOptionPane.showInputDialog(null, "Zona",
                    "Zona", JOptionPane.QUESTION_MESSAGE, null, zoneOptions, zoneOptions[0]);

            deliveries.add(new Delivery(cc,name,vehicle,phone,zone));
            JOptionPane.showMessageDialog(null,"Delivery registrado correctamente");

        } else {

            // ===== CLIENTE =====
            String name = JOptionPane.showInputDialog("Nombre del cliente:");
            String cc = JOptionPane.showInputDialog("Cédula del cliente:");

            // COMIDA
            String[] foodOptions = {"Perro Caliente","Pizza","Hamburguesa"};
            String food = (String) JOptionPane.showInputDialog(null,"Seleccione comida",
                    "Comida",JOptionPane.QUESTION_MESSAGE,null,foodOptions,foodOptions[0]);

            int qtyFood = Integer.parseInt(JOptionPane.showInputDialog("Cantidad comida:"));

            int foodPrice = 0;
            switch(food) {
                case "Perro Caliente": foodPrice = 16000; break;
                case "Pizza": foodPrice = 45000; break;
                case "Hamburguesa": foodPrice = 16000; break;
            }

            // BEBIDAS
            String[] drinks = {
                    "CocaCola 1.5L","CocaCola 3L",
                    "Pepsi 1.5L","Pepsi 3L",
                    "Colombiana 1.5L","Colombiana 3L",
                    "Sprite 1.5L","Sprite 3L",
                    "Bretaña 1.5L","Bretaña 3L",
                    "Sin bebida"
            };

            String drink = (String) JOptionPane.showInputDialog(null,"Seleccione bebida",
                    "Bebida",JOptionPane.QUESTION_MESSAGE,null,drinks,drinks[0]);

            int qtyDrink = 0;
            int drinkPrice = 0;

            if(!drink.equals("Sin bebida")) {
                qtyDrink = Integer.parseInt(JOptionPane.showInputDialog("Cantidad bebida:"));
                if(drink.contains("1.5")) drinkPrice = 6000;
                else drinkPrice = 12000;
            }

            int total = calculateTotal(foodPrice, qtyFood, drinkPrice, qtyDrink);

            // FACTURA
            String factura =
                    "===== FACTURA =====\n" +
                    "Cliente: " + name +
                    "\nCédula: " + cc +

                    "\n\nCOMIDA:\n" +
                    food + " = " + foodPrice +
                    "\nCantidad: " + qtyFood +
                    "\nSubtotal: " + (foodPrice * qtyFood) +

                    "\n\nBEBIDA:\n" +
                    drink + " = " + drinkPrice +
                    "\nCantidad: " + qtyDrink +
                    "\nSubtotal: " + (drinkPrice * qtyDrink) +

                    "\n\nTOTAL: $" + total;

            JOptionPane.showMessageDialog(null,factura);

            // TIPO DE PEDIDO
            String[] deliveryTypeOptions = {"Pedido a domicilio","Pasan por el establecimiento"};
            String deliveryType = (String) JOptionPane.showInputDialog(null,"Tipo de pedido",
                    "Tipo",JOptionPane.QUESTION_MESSAGE,null,deliveryTypeOptions,deliveryTypeOptions[0]);

            String address = "";
            String zone = "";
            Delivery assigned = null;

            if(deliveryType.equals("Pedido a domicilio")) {

                address = JOptionPane.showInputDialog("Dirección:");

                String[] zones = {"Norte","Sur","Este","Oeste"};
                zone = (String) JOptionPane.showInputDialog(null,"Zona",
                        "Zona",JOptionPane.QUESTION_MESSAGE,null,zones,zones[0]);

                ArrayList<Delivery> available = new ArrayList<>();

                for(Delivery d : deliveries) {
                    if(d.getZone().equals(zone) || d.getZone().equals("Todas las zonas")) {
                        available.add(d);
                    }
                }

                if(available.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"No hay delivery disponible en su zona");
                    return;
                }

                String[] names = new String[available.size()];
                for(int i=0;i<available.size();i++) names[i] = available.get(i).getName();

                String selected = (String) JOptionPane.showInputDialog(null,"Seleccione delivery",
                        "Delivery",JOptionPane.QUESTION_MESSAGE,null,names,names[0]);

                for(Delivery d : available) {
                    if(d.getName().equals(selected)) assigned = d;
                }
            }

          // MÉTODO DE PAGO REAL
String[] paymentOptions = {"Efectivo","Tarjeta","Transferencia"};
String paymentMethod = (String) JOptionPane.showInputDialog(null,"Seleccione método de pago",
        "Pago",JOptionPane.QUESTION_MESSAGE,null,paymentOptions,paymentOptions[0]);

String cardNumber = "";
String bank = "";

// Si es tarjeta → pide número
if(paymentMethod.equals("Tarjeta")) {
    cardNumber = JOptionPane.showInputDialog("Ingrese número de tarjeta:");
}

// Si es transferencia → pide banco
if(paymentMethod.equals("Transferencia")) {

    String[] banks = {
        "Bancolombia",
        "Banco de Bogotá",
        "Davivienda",
        "BBVA",
        "Banco Popular",
        "Banco AV Villas",
        "Banco Caja Social",
        "Scotiabank Colpatria",
        "Banco Agrario",
        "Itaú"
    };

    bank = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione su banco",
            "Bancos disponibles",
            JOptionPane.QUESTION_MESSAGE,
            null,
            banks,
            banks[0]
    );
}

// Crear objeto composición correctamente
PaymentDetail payment = new PaymentDetail(paymentMethod, cardNumber, bank);
//  TIPO DE PEDIDO 
String[] typeOrderOptions = {"App","Red Social/Web"};
String typeOrder = (String) JOptionPane.showInputDialog(null,"Seleccione tipo de pedido",
        "Tipo de pedido",JOptionPane.QUESTION_MESSAGE,null,typeOrderOptions,typeOrderOptions[0]);

if(typeOrder.equals("App")) {

    String[] apps = {"Rappi","Domicilios","Uber Eats"};
    String appName = (String) JOptionPane.showInputDialog(null,"Seleccione App",
            "App",JOptionPane.QUESTION_MESSAGE,null,apps,apps[0]);

    String userAppId = JOptionPane.showInputDialog("Ingrese ID de usuario App:");

  orders.add(new OrderByApp(
        name, cc,
        food, qtyFood, foodPrice,
        drink, qtyDrink, drinkPrice,
        total,
        deliveryType, address, zone,
        assigned, payment,
        appName, userAppId
));

} else {

    String[] social = {"Facebook","Instagram","YouTube","TikTok","X"};
    String socialPlatform = (String) JOptionPane.showInputDialog(null,"Seleccione Red Social",
            "Red Social/Web",JOptionPane.QUESTION_MESSAGE,null,social,social[0]);

  orders.add(new OrderBySocialWeb(
        name, cc,
        food, qtyFood, foodPrice,
        drink, qtyDrink, drinkPrice,
        total,
        deliveryType, address, zone,
        assigned, payment,
        socialPlatform
));
}

JOptionPane.showMessageDialog(null,"Pedido registrado correctamente");
        }
    }

    // ================= CONSULTAR =================
    public static void readRecord() {

        if(orders.isEmpty() && deliveries.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay registros");
            return;
        }

StringBuilder sb = new StringBuilder("Registros existentes:\n\n");

//  CLIENTES
sb.append("===== CLIENTES =====\n");
for(Order o : orders)
    sb.append(o.getCustomerName()+" - "+o.getCustomerCC()+"\n");

// DELIVERY
sb.append("\n===== DELIVERY =====\n");
for(Delivery d : deliveries)
    sb.append(d.getName()+" - "+d.getCc()+"\n");

        JOptionPane.showMessageDialog(null,sb.toString());

        String[] opt = {"Delivery","Cliente"};
        String choice = (String) JOptionPane.showInputDialog(null,"¿Qué desea consultar?",
                "Consulta",JOptionPane.QUESTION_MESSAGE,null,opt,opt[0]);

        if(choice.equals("Cliente")) {

            String cc = JOptionPane.showInputDialog("Ingrese cédula:");

            for(Order o : orders) {
                if(o.getCustomerCC().equals(cc)) {
                    o.displayOrderDetails();
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,"Cliente no encontrado");

        } else {

            String cc = JOptionPane.showInputDialog("Ingrese cédula:");

            for(Delivery d : deliveries) {
                if(d.getCc().equals(cc)) {
                    JOptionPane.showMessageDialog(null,d.toString());
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,"Delivery no encontrado");
        }
    }

    // ================= ACTUALIZAR =================
    public static void updateRecord() {

        String[] options = {"Pedido","Delivery"};
        String choice = (String) JOptionPane.showInputDialog(null,"¿Qué desea actualizar?",
                "Actualizar",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        if(choice.equals("Pedido")) {

            String cc = JOptionPane.showInputDialog("Cédula cliente:");

            for(Order o : orders) {
                if(o.getCustomerCC().equals(cc)) {

                    String newName = JOptionPane.showInputDialog("Nuevo nombre:");
                    o.setCustomerName(newName);

                    JOptionPane.showMessageDialog(null,"Actualizado");
                    return;
                }
            }

        } else {

            String cc = JOptionPane.showInputDialog("Cédula delivery:");

            for(Delivery d : deliveries) {
                if(d.getCc().equals(cc)) {

                    d.setName(JOptionPane.showInputDialog("Nuevo nombre:"));
                    d.setPhone(JOptionPane.showInputDialog("Nuevo teléfono:"));

                    JOptionPane.showMessageDialog(null,"Actualizado");
                    return;
                }
            }
        }
    }

    // ================= ELIMINAR =================
    public static void deleteRecord() {

        String[] options = {"Pedido","Delivery"};
        String choice = (String) JOptionPane.showInputDialog(null,"¿Qué desea eliminar?",
                "Eliminar",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        if(choice.equals("Pedido")) {

            String cc = JOptionPane.showInputDialog("Cédula cliente:");

            for(int i=0;i<orders.size();i++) {
                if(orders.get(i).getCustomerCC().equals(cc)) {
                    orders.remove(i);
                    JOptionPane.showMessageDialog(null,"Pedido eliminado");
                    return;
                }
            }

        } else {

            String cc = JOptionPane.showInputDialog("Cédula delivery:");

            for(int i=0;i<deliveries.size();i++) {
                if(deliveries.get(i).getCc().equals(cc)) {
                    deliveries.remove(i);
                    JOptionPane.showMessageDialog(null,"Delivery eliminado");
                    return;
                }

                
            }
        }
    }
}