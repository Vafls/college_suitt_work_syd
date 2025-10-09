public class RestaurantSystem {
    private String systemName;
    private String version;
    private int activeUsers;
    private boolean isOperational;

    public RestaurantSystem(String systemName, String version) {
        this.systemName = systemName;
        this.version = version;
        this.activeUsers = 0;
        this.isOperational = true;
    }

    public void startSystem() {
        isOperational = true;
        System.out.println("Систему " + systemName + " запущено");
    }

    public void shutdownSystem() {
        isOperational = false;
        System.out.println("Систему " + systemName + " вимкнено");
    }

    public void addUser() {
        activeUsers++;
        System.out.println("Користувача додано. Активних користувачів: " + activeUsers);
    }

    void performMaintenance() {
        System.out.println("Виконується технічне обслуговування системи");
    }

    protected boolean canHandleMoreUsers() {
        return activeUsers < 50;
    }

    public String getSystemName() {
        return systemName;
    }

    public boolean isOperational() {
        return isOperational;
    }

    @Override
    public String toString() {
        return "Система ресторану [назва=" + systemName + ", версія=" + version + 
               ", активні користувачі=" + activeUsers + ", працює=" + isOperational + "]";
    }
}