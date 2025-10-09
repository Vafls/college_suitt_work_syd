import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<String> items;
    private double totalAmount;
    private String status;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = "Нове";
        this.totalAmount = 0.0;
    }

    public void addItem(String item, double price) {
        items.add(item);
        totalAmount += price;
        System.out.println("Додано до замовлення: " + item + " - " + price);
    }

    public void completeOrder() {
        this.status = "Виконано";
        System.out.println("Замовлення " + orderId + " виконано");
    }

    void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    protected boolean canBeModified() {
        return !status.equals("Виконано");
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Замовлення [id=" + orderId + ", позиції=" + items + 
               ", сума=" + totalAmount + ", статус=" + status + "]";
    }
}