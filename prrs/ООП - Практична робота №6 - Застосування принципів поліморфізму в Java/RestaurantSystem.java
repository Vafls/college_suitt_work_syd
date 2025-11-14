public class RestaurantSystem extends RestaurantObject {
    private String version;
    private int activeUsers;
    private boolean isOperational;

    public RestaurantSystem(String systemName, String version) {
        super(systemName, 0);
        this.version = version;
        this.activeUsers = 0;
        this.isOperational = true;
    }
    
    @Override
    public void use() {
        System.out.println("Використовуємо систему " + name + " для управління рестораном");
    }
    
    @Override
    public boolean isValid() {
        return name != null && !name.isEmpty() && version != null && !version.isEmpty();
    }
    
    @Override
    public String getDescription() {
        return "Система '" + name + "' версії " + version + ", активних користувачів: " + activeUsers;
    }
    
    @Override
    public void maintain() {
        System.out.println("Виконується технічне обслуговування системи " + name);
    }

    public void startSystem() {
        isOperational = true;
        System.out.println("Систему " + name + " запущено");
    }

    public void shutdownSystem() {
        isOperational = false;
        System.out.println("Систему " + name + " вимкнено");
    }

    public void addUser() {
        activeUsers++;
        System.out.println("Користувача додано. Активних користувачів: " + activeUsers);
    }

    void performMaintenance() {
        System.out.println("Виконується технічне обслуговування системи");
    }

    protected boolean canHandleMoreUsers() {
        System.out.println("Перевірка можливості додавання користувачів до системи " + name);
        return activeUsers < 50;
    }

    public boolean isOperational() {
        return isOperational;
    }

    @Override
    public String toString() {
        return "Система ресторану [назва=" + name + ", версія=" + version + 
               ", активні користувачі=" + activeUsers + ", працює=" + isOperational + "]";
    }
}