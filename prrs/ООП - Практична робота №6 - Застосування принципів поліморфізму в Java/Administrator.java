public class Administrator extends Employee {
    private int accessLevel;
    
    public Administrator(NameInfo nameInfo, int age, String shift, int accessLevel) {
        super(nameInfo, age, 0, shift);
        this.accessLevel = accessLevel;
    }
    
    @Override
    public void introduce() {
        System.out.println("Привіт, я адміністратор " + nameInfo.getFullName() + ", рівень доступу: " + accessLevel);
    }
    
    @Override
    public String getRole() {
        return "Адміністратор";
    }
    
    @Override
    public void performAction() {
        System.out.println(nameInfo.getFullName() + " керує персоналом та обслуговує клієнтів");
    }
    
    @Override
    public void work() {
        System.out.println(nameInfo.getFullName() + " виконує обов'язки адміністратора під час " + shift + " зміни.");
    }
    
    @Override
    public boolean isExperienced() {
        return experienceYears > 1;
    }
    
    @Override
    public String getSpecialization() {
        return "Управління персоналом";
    }
    
    public void performDuty() {
        work();
    }
    
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