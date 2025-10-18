public class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void introduce() {
        System.out.println("Привіт, я " + name + ", мені " + age + " років.");
    }
    
    protected boolean isAdult() {
        return age >= 18;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Людина [ім'я=" + name + ", вік=" + age + "]";
    }
}