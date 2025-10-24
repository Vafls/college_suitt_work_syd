public class Administrator extends Employee {
    private int accessLevel;
    
    public Administrator(Person.NameInfo nameInfo, int age, String shift, int accessLevel) {
        super(nameInfo, age, 0, shift);
        this.accessLevel = accessLevel;
    }
    
    @Override
    public void work() {
        System.out.println(nameInfo.getFullName() + " виконує обов'язки адміністратора під час " + shift + " зміни.");
    }
    
    public void performDuty() {
        work();
    }
    
    @Override
    protected boolean hasAccess(int requiredLevel) {
        System.out.println("Перевірка доступу для адміністратора " + nameInfo.getFullName());
        return this.accessLevel >= requiredLevel;
    }
    
    private void logAction(String action) {
        System.out.println("ADMIN LOG: " + action + " - " + nameInfo.getFullName());
    }
    
    public static String getAdminResponsibilities() {
        return "Адміністратор відповідає за управління персоналом та обслуговування клієнтів";
    }
    
    @Override
    public String toString() {
        return "Адміністратор [ім'я=" + nameInfo.getFullName() + ", зміна=" + shift + 
               ", рівень доступу=" + accessLevel + "]";
    }
}