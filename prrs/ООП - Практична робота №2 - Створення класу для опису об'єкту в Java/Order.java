public class Order {
    private int orderId;
    private String orderDetails;

    public Order(int orderId, String orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public void doAction() {
        // Action implementation placeholder
    }

    @Override
    public String toString() {
        return "Order [ orderId=" + orderId + ", orderDetails=" + orderDetails + " ]";
    }
}
