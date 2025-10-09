public class CashDesk {
    private int cashDeskId;
    private double balance;
    private int transactionCount;

    public CashDesk(int cashDeskId, double initialBalance) {
        this.cashDeskId = cashDeskId;
        this.balance = initialBalance;
        this.transactionCount = 0;
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
        return transactionCount;
    }

    public double getBalance() {
        return balance;
    }

    public int getCashDeskId() {
        return cashDeskId;
    }

    @Override
    public String toString() {
        return "Каса [номер=" + cashDeskId + ", баланс=" + balance + ", транзакції=" + transactionCount + "]";
    }
}