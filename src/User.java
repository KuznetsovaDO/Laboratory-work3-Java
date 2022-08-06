public class User {
    private String lastname;
    private String name;
    private int id;
    private String pin;
    private PaymentScore cashAccount;

    public User(String lastname, String name, int id, String pin, PaymentScore cashAccount){
        this.lastname = lastname;
        this.name = name;
        this.id = id;
        this.cashAccount = cashAccount;
        this.pin = pin;
    }

    public User(String lastname, String name, int id, String pin){
        this.lastname = lastname;
        this.name = name;
        this.id = id;
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public PaymentScore getPaymentScore() {
        return cashAccount;
    }

    public void setPaymentScore(PaymentScore paymentScore){
        cashAccount = paymentScore;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
