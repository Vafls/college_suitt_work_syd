public class Storage {
    private String storageName;
    private int capacityKg;
    private int currentLoad;
    private String location;

    public Storage(String storageName, int capacityKg, String location) {
        this.storageName = storageName;
        this.capacityKg = capacityKg;
        this.location = location;
        this.currentLoad = 0;
    }

    public boolean addProduct(int weight) {
        if (currentLoad + weight <= capacityKg) {
            currentLoad += weight;
            System.out.println("Продукт додано до складу. Поточне завантаження: " + currentLoad + "/" + capacityKg);
            return true;
        }
        System.out.println("Недостатньо місца на складі");
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

    protected boolean needsRestock() {
        return currentLoad < capacityKg * 0.2;
    }

    public String getStorageName() {
        return storageName;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    @Override
    public String toString() {
        return "Склад [назва=" + storageName + ", місткість=" + capacityKg + 
               "кг, поточне завантаження=" + currentLoad + "кг, локація=" + location + "]";
    }
}