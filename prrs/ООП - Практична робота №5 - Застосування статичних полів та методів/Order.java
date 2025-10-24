import java.util.ArrayList;
import java.util.List;

public class Order extends RestaurantObject {
    private List<String> items;
    private double totalAmount;
    private String status;

    public Order(int orderId) {
        super("Замовлення", orderId);
        this.items = new ArrayList<>();
        this.status = "Нове";
        this.totalAmount = 0.0;
    }
    
    @Override
    public void use() {
        System.out.println("Використовуємо замовлення " + id + " для обробки");
    }

    public void addItem(String item, double price) {
        items.add(item);
        totalAmount += price;
        System.out.println("Додано до замовлення: " + item + " - " + price);
    }

    public void completeOrder() {
        this.status = "Виконано";
        System.out.println("Замовлення " + id + " виконано");
    }

    void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    protected boolean canBeModified() {
        System.out.println("Перевірка можливості зміни замовлення " + id);
        return !status.equals("Виконано");
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Замовлення [id=" + id + ", позиції=" + items + 
               ", сума=" + totalAmount + ", статус=" + status + "]";
    }
}