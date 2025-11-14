public class RestaurantObject extends AbstractRestaurantObject {
    
    public RestaurantObject(String name, int id) {
        super(name, id);
    }
    
    @Override
    public void use() {
        System.out.println("Використовуємо об'єкт: " + name);
    }
    
    @Override
    public boolean isValid() {
        return id > 0 && name != null && !name.isEmpty();
    }
    
    @Override
    public String getDescription() {
        return "Базовий об'єкт ресторану: " + name;
    }
    
    @Override
    public void maintain() {
        System.out.println("Виконується базове обслуговування об'єкта: " + name);
    }
}