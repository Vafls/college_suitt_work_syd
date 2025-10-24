public class ObjectFactory {
    
    public static Person createPerson(String firstName, String lastName, int age) {
        Person.NameInfo nameInfo = new Person.NameInfo(firstName, lastName);
        return new Person(nameInfo, age);
    }
    
    public static Visitor createVisitor(String firstName, String lastName, int age, String goal, double budget) {
        Person.NameInfo nameInfo = new Person.NameInfo(firstName, lastName);
        Visitor visitor = new Visitor(nameInfo, goal, age, budget);
        RestaurantStorage.addPerson(visitor);
        return visitor;
    }
    
    public static Waiter createWaiter(String firstName, String lastName, int age, int experienceYears) {
        Person.NameInfo nameInfo = new Person.NameInfo(firstName, lastName);
        Waiter waiter = new Waiter(nameInfo, age, experienceYears);
        RestaurantStorage.addEmployee(waiter);
        return waiter;
    }
    
    public static Cook createCook(String firstName, String lastName, int age, String specialization, int experienceYears) {
        Person.NameInfo nameInfo = new Person.NameInfo(firstName, lastName);
        Cook cook = new Cook(nameInfo, age, specialization, experienceYears);
        RestaurantStorage.addEmployee(cook);
        return cook;
    }
    
    public static Administrator createAdministrator(String firstName, String lastName, int age, String shift, int accessLevel) {
        Person.NameInfo nameInfo = new Person.NameInfo(firstName, lastName);
        Administrator admin = new Administrator(nameInfo, age, shift, accessLevel);
        RestaurantStorage.addEmployee(admin);
        return admin;
    }
    
    public static Table createTable(int tableNumber, int capacity) {
        Table table = new Table(tableNumber, capacity);
        RestaurantStorage.addRestaurantObject(table);
        return table;
    }
    
    public static Storage createStorage(String storageName, int capacityKg, String location) {
        Storage storage = new Storage(storageName, capacityKg, location);
        RestaurantStorage.addRestaurantObject(storage);
        return storage;
    }
    
    public static CashDesk createCashDesk(int cashDeskId, double initialBalance) {
        CashDesk cashDesk = new CashDesk(cashDeskId, initialBalance);
        RestaurantStorage.addRestaurantObject(cashDesk);
        return cashDesk;
    }
    
    public static Menu createMenu(String menuName, boolean isSeasonal) {
        Menu menu = new Menu(menuName, isSeasonal);
        RestaurantStorage.addRestaurantObject(menu);
        return menu;
    }
    
    public static Order createOrder(int orderId) {
        Order order = new Order(orderId);
        RestaurantStorage.addRestaurantObject(order);
        return order;
    }
    
    public static RestaurantSystem createRestaurantSystem(String systemName, String version) {
        RestaurantSystem system = new RestaurantSystem(systemName, version);
        RestaurantStorage.addRestaurantObject(system);
        return system;
    }
    
    public static void displayFactoryInfo() {
        System.out.println("ObjectFactory: Створено " + RestaurantStorage.getTotalObjectsCount() + " об'єктів");
    }
}