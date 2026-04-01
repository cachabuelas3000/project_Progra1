package co.edu.uptc.Orders.model;

// Clase asociada por composición dentro de Order
public class PaymentDetail {
    private String method; // método de pago
    private String cardNumber; // opcional si es tarjeta
    private String bank;       // opcional

    public PaymentDetail(String method, String cardNumber, String bank) {
        this.method = method;
        this.cardNumber = cardNumber;
        this.bank = bank;
    }

    public String getMethod() { return method; }
    public String getCardNumber() { return cardNumber; }
    public String getBank() { return bank; }

    public void setMethod(String method) { this.method = method; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public void setBank(String bank) { this.bank = bank; }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "method='" + method + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}