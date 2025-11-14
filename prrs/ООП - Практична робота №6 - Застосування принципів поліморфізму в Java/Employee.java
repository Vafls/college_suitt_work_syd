public abstract class Employee extends AbstractPerson {
    protected int experienceYears;
    protected String shift;
    
    public Employee(NameInfo nameInfo, int age, int experienceYears, String shift) {
        super(nameInfo, age);
        this.experienceYears = experienceYears;
        this.shift = shift;
    }
    
    @Override
    public abstract void introduce();
    
    @Override
    public boolean isAdult() {
        return age >= 18;
    }
    
    @Override
    public abstract String getRole();
    
    @Override
    public abstract void performAction();
    
    public abstract void work();
    public abstract boolean isExperienced();
    public abstract String getSpecialization();
    
    public void changeShift(String newShift) {
        this.shift = newShift;
        System.out.println(nameInfo.getFullName() + " змінив зміну на: " + newShift);
    }
    
    public static String getProfessionDescription() {
        return "Співробітник ресторану - особа, що забезпечує роботу закладу";
    }
    
    @Override
    public String toString() {
        return "Співробітник [ім'я=" + nameInfo.getFullName() + ", вік=" + age + 
               ", досвід=" + experienceYears + " років, зміна=" + shift + "]";
    }
}