public class Order {
    private int orderId;
    private String orderDetails;

    public Order(int orderId, String orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public void doAction() {
        System.out.println("Дія над замовленням виконана для orderId: " + orderId);
    }

    @Override
    public String toString() {
        return "Замовлення [ orderId=" + orderId + ", orderDetails=" + orderDetails + " ]";
    }
}
