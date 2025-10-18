public class Administrator extends Employee {
    private int accessLevel;
    
    public Administrator(String adminName, String shift, int accessLevel) {
        super(adminName, 30, 0, shift);
        this.accessLevel = accessLevel;
    }
    
    @Override
    public void work() {
        System.out.println(name + " виконує обов'язки адміністратора під час " + shift + " зміни.");
    }
    
    public void performDuty() {
        work();
    }
    
    @Override
    protected boolean hasAccess(int requiredLevel) {
        System.out.println("Перевірка доступу для адміністратора " + name);
        return this.accessLevel >= requiredLevel;
    }
    
    private void logAction(String action) {
        System.out.println("ADMIN LOG: " + action + " - " + name);
    }
    
    @Override
    public String toString() {
        return "Адміністратор [ім'я=" + name + ", зміна=" + shift + 
               ", рівень доступу=" + accessLevel + "]";
    }
}