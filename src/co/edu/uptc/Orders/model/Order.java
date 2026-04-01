package co.edu.uptc.Orders.model;

// Clase padre Pedido
public abstract class Order {

    protected String customerName;
    protected String customerCC;

    protected String food;
    protected int qtyFood;
    protected int foodPrice;

    protected String drink;
    protected int qtyDrink;
    protected int drinkPrice;

    protected int total;

    protected String deliveryType;
    protected String deliveryAddress;
    protected String deliveryZone;

    protected Delivery deliveryAssigned;
    protected PaymentDetail payment;

    protected Order(String customerName, String customerCC,
                    String food, int qtyFood, int foodPrice,
                    String drink, int qtyDrink, int drinkPrice,
                    int total,
                    String deliveryType, String deliveryAddress, String deliveryZone,
                    Delivery deliveryAssigned, PaymentDetail payment) {

        this.customerName = customerName;
        this.customerCC = customerCC;

        this.food = food;
        this.qtyFood = qtyFood;
        this.foodPrice = foodPrice;

        this.drink = drink;
        this.qtyDrink = qtyDrink;
        this.drinkPrice = drinkPrice;

        this.total = total;

        this.deliveryType = deliveryType;
        this.deliveryAddress = deliveryAddress;
        this.deliveryZone = deliveryZone;
        this.deliveryAssigned = deliveryAssigned;
        this.payment = payment;
    }

    public abstract void displayOrderDetails();

    public int calculateTotalPrice() {
        return total;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCC() { return customerCC; }
    public String getCustomerName() { return customerName; }
}