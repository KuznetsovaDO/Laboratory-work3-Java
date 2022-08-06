import java.util.Scanner;
public class Program2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        User user1 = new User("Иванов", "Иван", 1, "4545");
        PaymentScore ps1 = new PaymentScore("111", "Deposit Ivanov Ivan", 0, user1, "myBank");
        user1.setPaymentScore(ps1);

        User user2 = new User("Сергеева", "Софья", 2, "9801");
        PaymentScore ps2 = new PaymentScore("112", "Deposit Sergeeva Sofya", 1500, user2, "Sberbank");
        user2.setPaymentScore(ps2);

        User[] users = new User[]{user1, user2};
        PaymentScore[] paymentScores = new PaymentScore[]{ps1, ps2};

        ATM_myBank myBank = new ATM_myBank();

        String ans = "Да";

        do{
        System.out.println("Введите номер счета: ");
        String numberPS = scan.next();
        PaymentScore ps = null;
        for (int i = 0; i < paymentScores.length; i++) {
            if (paymentScores[i].getNumber().equals(numberPS)) {
                ps = paymentScores[i];
            }
        }
        if (ps == null) {
            System.out.println("Такого счета не существует");
        } else {
            System.out.println("Введите pin: ");
            if (ps.getUser().getPin().equals(scan.next())) {
                System.out.println("1 - Проверить баланс\n 2 - Пополнить счет\n 3 - Снять деньги со счета \n 4 - Перевести деньги на другой счет\n 0-Выйти\n" +
                        "Введите номер операции, которую вы хотите выполнить: ");
                int operation = scan.nextInt();
                switch (operation) {
                    case 1:
                        if (ps.checkPin()) {
                            System.out.println("Текущий баланс: " + ps.getBalance());
                        }
                        break;
                    case 2:
                        ps.addCash();
                        break;
                    case 3:
                        ps.withdrawCash();
                        break;
                    case 4:
                        System.out.println("Введите номер счета: ");
                        numberPS = scan.next();
                        PaymentScore PS = null;
                        for (int i = 0; i < paymentScores.length; i++) {
                            if (paymentScores[i].getNumber().equals(numberPS)) {
                                PS = paymentScores[i];
                            }
                        }
                        if (PS == null) {
                            System.out.println("Такого счета не существует");
                        } else {
                            ps.transferCash(PS);
                        }
                        break;
                    case 0:
                        ans = "no";
                }
            } else {
                System.out.println("Неверный pin");
            }
        }
        }
        while (ans.equals("Да"));
    }
}
