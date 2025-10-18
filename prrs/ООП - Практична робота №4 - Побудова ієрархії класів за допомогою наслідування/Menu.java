import java.util.ArrayList;
import java.util.List;

public class Menu extends RestaurantObject {
    private List<String> dishes;
    private double averagePrice;
    private boolean isSeasonal;

    public Menu(String menuName, boolean isSeasonal) {
        super(menuName, 0);
        this.dishes = new ArrayList<>();
        this.isSeasonal = isSeasonal;
        this.averagePrice = 0.0;
    }
    
    @Override
    public void use() {
        System.out.println("Використовуємо меню " + name + " для вибору страв");
    }

    public void addDish(String dishName, double price) {
        dishes.add(dishName);
        updateAveragePrice(price);
        System.out.println("Страву додано до меню: " + dishName);
    }

    public void removeDish(String dishName) {
        if (dishes.remove(dishName)) {
            System.out.println("Страву видалено з меню: " + dishName);
        }
    }

    void updateAveragePrice(double newPrice) {
        this.averagePrice = (this.averagePrice + newPrice) / 2;
    }

    @Override
    protected boolean isSeasonalMenu() {
        System.out.println("Перевірка сезонності меню " + name);
        return isSeasonal;
    }

    private void calculateExactAverage() {
        if (dishes.isEmpty()) {
            averagePrice = 0.0;
            return;
        }
    }

    public List<String> getAvailableDishes() {
        return new ArrayList<>(dishes);
    }

    @Override
    public String toString() {
        return "Меню [назва=" + name + ", страви=" + dishes + 
               ", середня ціна=" + averagePrice + ", сезонне=" + isSeasonal + "]";
    }
}