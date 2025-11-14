public class CashDesk extends RestaurantObject {
    private double balance;
    private int transactionCount;
    
    public CashDesk(int cashDeskId, double initialBalance) {
        super("Каса", cashDeskId);
        this.balance = initialBalance;
        this.transactionCount = 0;
    }
    
    @Override
    public void use() {
        System.out.println("Використовуємо касу " + id + " для фінансових операцій");
    }
    
    @Override
    public boolean isValid() {
        return id > 0 && balance >= 0;
    }
    
    @Override
    public String getDescription() {
        return "Каса номер " + id + " з балансом: " + balance;
    }
    
    @Override
    public void maintain() {
        System.out.println("Виконується обслуговування каси " + id + ": перевірка готівки та звітності");
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionCount++;
            System.out.println("Внесено: " + amount + ". Новий баланс: " + balance);
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionCount++;
            System.out.println("Видано: " + amount + ". Залишок: " + balance);
            return true;
        }
        System.out.println("Недостатньо коштів для зняття: " + amount);
        return false;
    }
    
    void processPayment(double amount) {
        if (withdraw(amount)) {
            System.out.println("Платіж успішно оброблено");
        }
    }
    
    protected int getTransactionCount() {
        System.out.println("Отримання кількості транзакцій для каси " + id);
        return transactionCount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    @Override
    public String toString() {
        return "Каса [номер=" + id + ", баланс=" + balance + ", транзакції=" + transactionCount + "]";
    }
}