public class Cook extends Employee {
    private String specialization;
    private boolean isAvailable;
    
    public Cook(String cookName, String specialization, int experienceYears) {
        super(cookName, 0, experienceYears, "Кухня");
        this.specialization = specialization;
        this.isAvailable = true;
    }
    
    @Override
    public void work() {
        System.out.println(name + " працює кухарем на " + specialization + " кухні.");
    }
    
    public void prepareDish(String dishName) {
        if (isAvailable) {
            System.out.println(name + " готує страву: " + dishName + " (" + specialization + ")");
            isAvailable = false;
        } else {
            System.out.println(name + " зараз зайнятий");
        }
    }
    
    public void finishCooking() {
        isAvailable = true;
        System.out.println(name + " завершив приготування");
    }
    
    void changeSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
        System.out.println(name + " змінив спеціалізацію на: " + newSpecialization);
    }
    
    @Override
    protected boolean canPrepareComplexDish() {
        System.out.println("Перевірка можливості приготування складної страви для " + name);
        return experienceYears > 3;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    @Override
    public String toString() {
        return "Кухар [ім'я=" + name + ", спеціалізація=" + specialization + 
               ", досвід=" + experienceYears + " років]";
    }
}