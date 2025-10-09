public class Waiter {
    private String waiterName;
    private int experienceYears;
    private int tablesServed;
    private double tips;

    public Waiter(String waiterName, int experienceYears) {
        this.waiterName = waiterName;
        this.experienceYears = experienceYears;
        this.tablesServed = 0;
        this.tips = 0.0;
    }

    public void serveTable(Table table) {
        if (!table.isOccupied()) {
            System.out.println(waiterName + " не може обслуговувати вільний стіл");
            return;
        }
        tablesServed++;
        System.out.println(waiterName + " обслуговує стіл");
    }

    public void receiveTip(double amount) {
        tips += amount;
        System.out.println(waiterName + " отримав чайові: " + amount);
    }

    void takeOrder(Order order, String item, double price) {
        order.addItem(item, price);
    }

    protected boolean isExperienced() {
        return experienceYears > 2;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public double getTotalTips() {
        return tips;
    }

    @Override
    public String toString() {
        return "Офіціант [ім'я=" + waiterName + ", досвід=" + experienceYears + 
               " років, обслужено столів=" + tablesServed + ", чайові=" + tips + "]";
    }
}