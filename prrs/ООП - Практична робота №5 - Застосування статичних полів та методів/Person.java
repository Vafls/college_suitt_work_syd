public class Person {
    public static class NameInfo {
        private String firstName;
        private String lastName;
        
        public NameInfo(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        
        public String getFullName() {
            return firstName + " " + lastName;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public String getLastName() {
            return lastName;
        }
        
        @Override
        public String toString() {
            return getFullName();
        }
    }
    
    protected NameInfo nameInfo;
    protected int age;
    
    public Person(NameInfo nameInfo, int age) {
        this.nameInfo = nameInfo;
        this.age = age;
    }
    
    public void introduce() {
        System.out.println("Привіт, я " + nameInfo.getFullName() + ", мені " + age + " років.");
    }
    
    protected boolean isAdult() {
        return age >= 18;
    }
    
    public static String getSpeciesDescription() {
        return "Людина (Homo sapiens) - розумна істота з здатністю до абстрактного мислення.";
    }
    
    public String getName() {
        return nameInfo.getFullName();
    }
    
    @Override
    public String toString() {
        return "Людина [ім'я=" + nameInfo.getFullName() + ", вік=" + age + "]";
    }
}