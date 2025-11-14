public abstract class AbstractPerson {
    
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
    
    public AbstractPerson(NameInfo nameInfo, int age) {
        this.nameInfo = nameInfo;
        this.age = age;
    }
    
    public abstract void introduce();
    public abstract boolean isAdult();
    public abstract String getRole();
    public abstract void performAction();
    
    public String getName() {
        return nameInfo.getFullName();
    }
    
    public static String getSpeciesDescription() {
        return "Людина (Homo sapiens) - розумна істота з здатністю до абстрактного мислення.";
    }
    
    @Override
    public String toString() {
        return "Людина [ім'я=" + nameInfo.getFullName() + ", вік=" + age + "]";
    }
}