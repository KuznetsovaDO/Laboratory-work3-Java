import java.util.Scanner;

public class PaymentScore {
    private String numberPaymentScore;
    private String depositeName;
    private double balance;
    private User user;
    String bankName;

    Scanner scan =new Scanner(System.in);

    public PaymentScore(String numberPaymentScore, String depositeName, double balance, User user, String bankName){
        this.numberPaymentScore = numberPaymentScore;
        this.depositeName = depositeName;
        this.balance = balance;
        this.user = user;
        this.bankName = bankName;
    }
    public String getNumber(){return this.numberPaymentScore;}

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public User getUser() {
        return this.user;
    }

    public String getBankName() {
        return bankName;
    }

    public String getDepositeName() {
        return depositeName;
    }

    public boolean checkPin(){
        System.out.println("Введите pin: ");
        String pin = scan.next();
        if (this.getUser().getPin().equals(pin)){
            return true;
        }
        else{
            System.out.println("Неверный pin");
            return false;}
    }
    public  boolean checkBalance(double sum){
        if (this.getBalance()<sum){
            System.out.println("Недостаточно средств");
            return false;
        }
        else {return true;}
    }

    public void addCash(){
        if(this.checkPin()){
            System.out.println("Введите сумму: ");
            double sum = scan.nextDouble();

            this.setBalance(this.getBalance()+sum);
            System.out.println("Cчет пополнен. Текущий баланс: "+this.getBalance());        }
    }

    public void withdrawCash(){
        if(this.checkPin()){
            System.out.println("Введите сумму: ");
            double sum = scan.nextDouble();
            if (this.checkBalance(sum)){
            this.setBalance(this.getBalance()-sum);
            System.out.println("Cчет пополнен. Текущий баланс: "+this.getBalance());}
        }
    }

    public void transferCash(PaymentScore ps){
        if(this.checkPin()){
        System.out.println("Введите сумму: ");
        double sum = scan.nextDouble();
            if (this.checkBalance(sum)){
        this.setBalance(this.getBalance()-sum);
        ps.setBalance(ps.getBalance()+sum);
        System.out.println("Перевод выполнен");
            }
        }
    }
}
