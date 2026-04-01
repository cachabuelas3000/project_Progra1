package co.edu.uptc.Orders.model;

// Clase que representa un repartidor
public class Delivery {
    private String cc; // Cédula del delivery
    private String name;
    private String vehicle;
    private String phone;
    private String zone; // zona asignada

    public Delivery(String cc, String name, String vehicle, String phone, String zone) {
        this.cc = cc;
        this.name = name;
        this.vehicle = vehicle;
        this.phone = phone;
        this.zone = zone;
    }

    // Getters y setters
    public String getCc() { return cc; }
    public String getName() { return name; }
    public String getVehicle() { return vehicle; }
    public String getPhone() { return phone; }
    public String getZone() { return zone; }

    public void setName(String name) { this.name = name; }
    public void setVehicle(String vehicle) { this.vehicle = vehicle; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setZone(String zone) { this.zone = zone; }

    @Override
    public String toString() {
        return "Delivery{" +
                "cc='" + cc + '\'' +
                ", name='" + name + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", phone='" + phone + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}