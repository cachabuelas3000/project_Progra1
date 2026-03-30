package co.edu.uptc.Orders.model;

public class PaymentDetail {
        private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;
    private String bank;

    public PaymentDetail(String cardNumber, String cardHolder,
                         String expirationDate, String cvv, String bank) {

        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.bank = bank;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    
}
