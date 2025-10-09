import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String menuName;
    private List<String> dishes;
    private double averagePrice;
    private boolean isSeasonal;

    public Menu(String menuName, boolean isSeasonal) {
        this.menuName = menuName;
        this.dishes = new ArrayList<>();
        this.isSeasonal = isSeasonal;
        this.averagePrice = 0.0;
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

    protected boolean isSeasonalMenu() {
        return isSeasonal;
    }

    private void calculateExactAverage() {

        if (dishes.isEmpty()) {
            averagePrice = 0.0;
            return;
        }
        averagePrice = averagePrice;
    }

    public List<String> getAvailableDishes() {
        return new ArrayList<>(dishes);
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public String toString() {
        return "Меню [назва=" + menuName + ", страви=" + dishes + 
               ", середня ціна=" + averagePrice + ", сезонне=" + isSeasonal + "]";
    }
}