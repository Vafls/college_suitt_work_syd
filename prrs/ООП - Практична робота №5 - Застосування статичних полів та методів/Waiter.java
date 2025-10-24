public class Waiter extends Employee {
    private int tablesServed;
    private double tips;
    
    public Waiter(Person.NameInfo nameInfo, int age, int experienceYears) {
        super(nameInfo, age, experienceYears, "Зал");
        this.tablesServed = 0;
        this.tips = 0.0;
    }
    
    @Override
    public void work() {
        System.out.println(nameInfo.getFullName() + " працює офіціантом, обслуговує клієнтів.");
    }
    
    public void serveTable(Table table) {
        if (!table.isOccupied()) {
            System.out.println(nameInfo.getFullName() + " не може обслуговувати вільний стіл");
            return;
        }
        tablesServed++;
        System.out.println(nameInfo.getFullName() + " обслуговує стіл");
    }
    
    public void receiveTip(double amount) {
        tips += amount;
        System.out.println(nameInfo.getFullName() + " отримав чайові: " + amount);
    }
    
    void takeOrder(Order order, String item, double price) {
        order.addItem(item, price);
    }
    
    @Override
    protected boolean isExperienced() {
        System.out.println("Перевірка досвіду офіціанта " + nameInfo.getFullName());
        return experienceYears > 2;
    }
    
    public static String getServiceStandards() {
        return "Стандарти обслуговування: ввічливість, оперативність, увага до деталей";
    }
    
    public double getTotalTips() {
        return tips;
    }
    
    @Override
    public String toString() {
        return "Офіціант [ім'я=" + nameInfo.getFullName() + ", досвід=" + experienceYears + 
               " років, обслужено столів=" + tablesServed + ", чайові=" + tips + "]";
    }
}