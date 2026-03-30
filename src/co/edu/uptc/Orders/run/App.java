package co.edu.uptc.Orders.run;

import co.edu.uptc.Orders.model.Order;
import co.edu.uptc.Orders.model.OrderByApp;

public class App {
    public static void main(String[] args) throws Exception {

        Order order1 = new OrderByApp(1, "John Doe", "Laptop", 2, 999.99, "Credit Card");
        order1.displayOrderDetails();
        System.out.println("Total Price: $" + order1.calculateTotalPrice());

       
    }
}
