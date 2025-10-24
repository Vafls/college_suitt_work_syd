public class RestaurantObject {
    protected String name;
    protected int id;
    
    public RestaurantObject(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public void use() {
        System.out.println("Використовуємо об'єкт: " + name);
    }
    
    protected boolean isValid() {
        return id > 0 && name != null && !name.isEmpty();
    }
    
    public static String getObjectTypeDescription() {
        return "RestaurantObject - базовий клас для всіх об'єктів ресторану";
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Об'єкт ресторану [назва=" + name + ", id=" + id + "]";
    }
}