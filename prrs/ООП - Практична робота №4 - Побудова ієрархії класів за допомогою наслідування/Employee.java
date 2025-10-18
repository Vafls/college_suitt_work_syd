public class Employee extends Person {
    protected int experienceYears;
    protected String shift;
    
    public Employee(String name, int age, int experienceYears, String shift) {
        super(name, age);
        this.experienceYears = experienceYears;
        this.shift = shift;
    }
    
    public void work() {
        System.out.println(name + " працює.");
    }
    
    public void changeShift(String newShift) {
        this.shift = newShift;
        System.out.println(name + " змінив зміну на: " + newShift);
    }
    
    protected boolean isExperienced() {
        return experienceYears > 2;
    }
    
    @Override
    public String toString() {
        return "Співробітник [ім'я=" + name + ", вік=" + age + 
               ", досвід=" + experienceYears + " років, зміна=" + shift + "]";
    }
}