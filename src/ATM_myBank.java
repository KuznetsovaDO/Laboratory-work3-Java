import java.util.Scanner;

//класс "банкомат банка myBank", реализующий интерфейс Банкомат
public class ATM_myBank implements ATM {

    Scanner in = new Scanner(System.in);

    @Override
    public double checkBalance(User user) {
        System.out.println("Введите pin: ");
        if (isPin(user, in.next())) {
            return user.getPaymentScore().getBalance();
        } else {
            System.out.println("Неверный pin");
            return 0;
        }
    }

    @Override
    public void addMoney(User user, double amount) {
        System.out.println("Введите pin: ");
        if (isPin(user, in.next())) {
            user.getPaymentScore().setBalance(user.getPaymentScore().getBalance() + amount);
            System.out.println("Счет пополнен");
        } else {
            System.out.println("Неверный pin. Операция не выполнена. ");
        }
    }

    @Override
    public void takeMoney(User user, double amount) {
        System.out.println("Введите pin: ");
        if (isPin(user, in.next())) {
            //проверяем, хватает ли суммы на счете
            if (user.getPaymentScore().getBalance() >= amount) {
                //проверяем, является ли пользователем клиентом банка MyBank
                if (user.getPaymentScore().bankName.equals("MyBank")) {
                    //вычитаем сумму со счета
                    user.getPaymentScore().setBalance(user.getPaymentScore().getBalance() - amount);
                    System.out.println("Деньги сняты со счета");
                } else {
                    user.getPaymentScore().setBalance(user.getPaymentScore().getBalance() - (amount + amount * 0.02));
                    System.out.println("Деньги сняты со счета с комиссией 2%");
                }
            } else {
                System.out.println("Операция не выполнена. Недостаточно средств на счете");
            }
        } else {
            System.out.println("Операция не выполнена. Неверный pin.");
        }
    }

    @Override
    public void transferMoney(User user1, double amount, User user2) {
        System.out.println("Введите pin:");
        if (isPin(user1, in.next())){
            double currentBalance1 = user1.getPaymentScore().getBalance();
            double currentBalance2 = user2.getPaymentScore().getBalance();
            if (currentBalance1>=amount){
                user2.getPaymentScore().setBalance(currentBalance2+amount);
                user1.getPaymentScore().setBalance(currentBalance1-amount);
                System.out.println(String.format("Операция выполнена. Сумма %s р. переведена на счет %s",
                        amount, user2.getPaymentScore().getDepositeName()));
            }
            else {System.out.println("Операция невыполнена. Недостаточно денег на счете.");}
        }
        else {System.out.println("Операция не выполнена");}

    }

    private boolean isPin(User user, String pin) {
        if (pin.equals(user.getPin())) {
            return true;
        }
        else return false;
    }
}
