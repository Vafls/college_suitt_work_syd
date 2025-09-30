public class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public void doAction() {
        System.out.println("Дія виконана над столом " + tableNumber);
    }
    @Override
    public String toString() {
        return "Стіл [ номер столу=" + tableNumber + ", кількість місць=" + capacity + " ]";
    }
}
