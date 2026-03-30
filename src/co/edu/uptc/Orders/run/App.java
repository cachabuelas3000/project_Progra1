package co.edu.uptc.Orders.run;

import co.edu.uptc.Orders.model.Order;
import co.edu.uptc.Orders.model.OrderByApp;

public class App {
    public static void main(String[] args) throws Exception {

        Order order1 = new Order(1, "John Doe", "Laptop", 2, 1200.00, "Credit Card");
        order1.displayOrderDetails();
       
    }
}
