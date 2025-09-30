public class CashDesk {
    private int cashDeskId;
    private double balance;

    public CashDesk(int cashDeskId, double balance) {
        this.cashDeskId = cashDeskId;
        this.balance = balance;
    }

    public void doAction() {
        System.out.println("Дію виконано. Поточний баланс: " + balance);
    }
    @Override
    public String toString() {
        return "Каса [ номер каси=" + cashDeskId + ", баланс=" + balance + " ]";
    }
}
