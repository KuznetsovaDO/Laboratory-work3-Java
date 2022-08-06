// интерфейс БАНКОМАТ
public interface ATM {
    double checkBalance(User user);
    void addMoney(User user, double amount);
    void takeMoney(User user, double amount);
    void transferMoney(User user1, double amount, User user2);
}
