public class Cook extends Employee {
    private String specialization;
    private boolean isAvailable;
    
    public Cook(Person.NameInfo nameInfo, int age, String specialization, int experienceYears) {
        super(nameInfo, age, experienceYears, "Кухня");
        this.specialization = specialization;
        this.isAvailable = true;
    }
    
    @Override
    public void work() {
        System.out.println(nameInfo.getFullName() + " працює кухарем на " + specialization + " кухні.");
    }
    
    public void prepareDish(String dishName) {
        if (isAvailable) {
            System.out.println(nameInfo.getFullName() + " готує страву: " + dishName + " (" + specialization + ")");
            isAvailable = false;
        } else {
            System.out.println(nameInfo.getFullName() + " зараз зайнятий");
        }
    }
    
    public void finishCooking() {
        isAvailable = true;
        System.out.println(nameInfo.getFullName() + " завершив приготування");
    }
    
    void changeSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
        System.out.println(nameInfo.getFullName() + " змінив спеціалізацію на: " + newSpecialization);
    }
    
    @Override
    protected boolean canPrepareComplexDish() {
        System.out.println("Перевірка можливості приготування складної страви для " + nameInfo.getFullName());
        return experienceYears > 3;
    }
    
    public static String getCookingTips() {
        return "Секрет хорошої кухні - якісні інгредієнти та любов до справи";
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    @Override
    public String toString() {
        return "Кухар [ім'я=" + nameInfo.getFullName() + ", спеціалізація=" + specialization + 
               ", досвід=" + experienceYears + " років]";
    }
}