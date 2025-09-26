public class CashDesk {
    private int cashDeskId;
    private double balance;

    public CashDesk(int cashDeskId, double balance) {
        this.cashDeskId = cashDeskId;
        this.balance = balance;
    }

    public void doAction() {
        // Example implementation: print current balance
        System.out.println("Action performed. Current balance: " + balance);
    }
    @Override
    public String toString() {
        return "CashDesk [ cashDeskId=" + cashDeskId + ", balance=" + balance + " ]";
    }
}
