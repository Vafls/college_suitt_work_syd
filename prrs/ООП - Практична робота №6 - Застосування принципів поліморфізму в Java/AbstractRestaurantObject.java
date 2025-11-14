public abstract class AbstractRestaurantObject {
    protected String name;
    protected int id;
    
    public AbstractRestaurantObject(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public abstract void use();
    public abstract boolean isValid();
    public abstract String getDescription();
    public abstract void maintain();
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public static String getObjectTypeDescription() {
        return "AbstractRestaurantObject - базовий клас для всіх об'єктів ресторану";
    }
    
    @Override
    public String toString() {
        return "Об'єкт ресторану [назва=" + name + ", id=" + id + "]";
    }
}