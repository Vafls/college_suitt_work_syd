import java.util.ArrayList;
import java.util.List;

public class RestaurantStorage {
    private static List<Person> allPersons = new ArrayList<>();
    private static List<Employee> allEmployees = new ArrayList<>();
    private static List<Visitor> allVisitors = new ArrayList<>();
    private static List<RestaurantObject> allRestaurantObjects = new ArrayList<>();
    
    public static void addPerson(Person person) {
        allPersons.add(person);
        System.out.println("Додано особу до сховища: " + person.getName());
    }
    
    public static void addEmployee(Employee employee) {
        allEmployees.add(employee);
        addPerson(employee);
    }
    
    public static void addVisitor(Visitor visitor) {
        allVisitors.add(visitor);
        addPerson(visitor);
    }
    
    public static void addRestaurantObject(RestaurantObject obj) {
        allRestaurantObjects.add(obj);
        System.out.println("Додано об'єкт ресторану до сховища: " + obj.getName());
    }
    
    public static List<Person> getAllPersons() {
        return new ArrayList<>(allPersons);
    }
    
    public static List<Employee> getAllEmployees() {
        return new ArrayList<>(allEmployees);
    }
    
    public static List<Visitor> getAllVisitors() {
        return new ArrayList<>(allVisitors);
    }
    
    public static List<RestaurantObject> getAllRestaurantObjects() {
        return new ArrayList<>(allRestaurantObjects);
    }
    
    public static int getTotalObjectsCount() {
        return allPersons.size() + allRestaurantObjects.size();
    }
    
    public static void displayStorageInfo() {
        System.out.println("=== ІНФОРМАЦІЯ ПРО СХОВИЩЕ ===");
        System.out.println("Осіб: " + allPersons.size());
        System.out.println("Співробітників: " + allEmployees.size());
        System.out.println("Відвідувачів: " + allVisitors.size());
        System.out.println("Об'єктів ресторану: " + allRestaurantObjects.size());
        System.out.println("Загальна кількість: " + getTotalObjectsCount());
    }
}