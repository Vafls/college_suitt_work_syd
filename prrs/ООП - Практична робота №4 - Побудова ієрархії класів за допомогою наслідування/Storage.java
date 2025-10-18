public class Storage extends RestaurantObject {
    private int capacityKg;
    private int currentLoad;
    private String location;
    
    public Storage(String storageName, int capacityKg, String location) {
        super(storageName, 0);
        this.capacityKg = capacityKg;
        this.location = location;
        this.currentLoad = 0;
    }
    
    @Override
    public void use() {
        System.out.println("Використовуємо склад " + name + " для зберігання продуктів");
    }
    
    public boolean addProduct(int weight) {
        if (currentLoad + weight <= capacityKg) {
            currentLoad += weight;
            System.out.println("Продукт додано до складу. Поточне завантаження: " + currentLoad + "/" + capacityKg);
            return true;
        }
        System.out.println("Недостатньо місця на складі");
        return false;
    }
    
    public boolean removeProduct(int weight) {
        if (currentLoad - weight >= 0) {
            currentLoad -= weight;
            System.out.println("Продукт видалено зі складу. Поточне завантаження: " + currentLoad + "/" + capacityKg);
            return true;
        }
        System.out.println("Недостатньо продуктів на складі");
        return false;
    }
    
    int getAvailableSpace() {
        return capacityKg - currentLoad;
    }
    
    @Override
    protected boolean needsRestock() {
        System.out.println("Перевірка необхідності поповнення складу " + name);
        return currentLoad < capacityKg * 0.2;
    }
    
    public int getCurrentLoad() {
        return currentLoad;
    }
    
    @Override
    public String toString() {
        return "Склад [назва=" + name + ", місткість=" + capacityKg + 
               "кг, поточне завантаження=" + currentLoad + "кг, локація=" + location + "]";
    }
}