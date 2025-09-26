public class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public void doAction() {
        // Example implementation
        System.out.println("Action performed on table " + tableNumber);
    }
    @Override
    public String toString() {
        return "Table [ tableNumber=" + tableNumber + ", capacity=" + capacity + " ]";
    }
}
