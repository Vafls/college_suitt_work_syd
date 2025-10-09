public class Cook {
    private String cookName;
    private String specialization;
    private int experienceYears;
    private boolean isAvailable;

    public Cook(String cookName, String specialization, int experienceYears) {
        this.cookName = cookName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.isAvailable = true;
    }

    public void prepareDish(String dishName) {
        if (isAvailable) {
            System.out.println(cookName + " готує страву: " + dishName + " (" + specialization + ")");
            isAvailable = false;
        } else {
            System.out.println(cookName + " зараз зайнений");
        }
    }

    public void finishCooking() {
        isAvailable = true;
        System.out.println(cookName + " завершив приготування");
    }

    void changeSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
        System.out.println(cookName + " змінив спеціалізацію на: " + newSpecialization);
    }

    protected boolean canPrepareComplexDish() {
        return experienceYears > 3;
    }

    public String getCookName() {
        return cookName;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Кухар [ім'я=" + cookName + ", спеціалізація=" + specialization + 
               ", досвід=" + experienceYears + " років]";
    }
}