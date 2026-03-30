package co.edu.uptc.Orders.model;

public class Delivery {

    private int id;
    private String name;
    private String vehicle;
    private String phone;
    private String zone;

    public Delivery(int id, String name, String vehicle, String phone, String zone) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.phone = phone;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }
}
    
