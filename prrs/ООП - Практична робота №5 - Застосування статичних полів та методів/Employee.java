public class Employee extends Person {
    protected int experienceYears;
    protected String shift;
    
    public Employee(NameInfo nameInfo, int age, int experienceYears, String shift) {
        super(nameInfo, age);
        this.experienceYears = experienceYears;
        this.shift = shift;
    }
    
    public void work() {
        System.out.println(nameInfo.getFullName() + " працює.");
    }
    
    public void changeShift(String newShift) {
        this.shift = newShift;
        System.out.println(nameInfo.getFullName() + " змінив зміну на: " + newShift);
    }
    
    protected boolean isExperienced() {
        return experienceYears > 2;
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