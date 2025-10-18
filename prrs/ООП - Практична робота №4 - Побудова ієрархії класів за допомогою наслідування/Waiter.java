public class Waiter extends Employee {
    private int tablesServed;
    private double tips;
    
    public Waiter(String waiterName, int experienceYears) {
        super(waiterName, 0, experienceYears, "Зал");
        this.tablesServed = 0;
        this.tips = 0.0;
    }
    
    @Override
    public void work() {
        System.out.println(name + " працює офіціантом, обслуговує клієнтів.");
    }
    
    public void serveTable(Table table) {
        if (!table.isOccupied()) {
            System.out.println(name + " не може обслуговувати вільний стіл");
            return;
        }
        tablesServed++;
        System.out.println(name + " обслуговує стіл");
    }
    
    public void receiveTip(double amount) {
        tips += amount;
        System.out.println(name + " отримав чайові: " + amount);
    }
    
    void takeOrder(Order order, String item, double price) {
        order.addItem(item, price);
    }
    
    @Override
    protected boolean isExperienced() {
        System.out.println("Перевірка досвіду офіціанта " + name);
        return experienceYears > 2;
    }
    
    public double getTotalTips() {
        return tips;
    }
    
    @Override
    public String toString() {
        return "Офіціант [ім'я=" + name + ", досвід=" + experienceYears + 
               " років, обслужено столів=" + tablesServed + ", чайові=" + tips + "]";
    }
}