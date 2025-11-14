public class Person extends AbstractPerson {
    
    public Person(NameInfo nameInfo, int age) {
        super(nameInfo, age);
    }
    
    @Override
    public void introduce() {
        System.out.println("Привіт, я " + nameInfo.getFullName() + ", мені " + age + " років.");
    }
    
    @Override
    public boolean isAdult() {
        return age >= 18;
    }
    
    @Override
    public String getRole() {
        return "Клієнт";
    }
    
    @Override
    public void performAction() {
        System.out.println(nameInfo.getFullName() + " виконує базові дії");
    }
}