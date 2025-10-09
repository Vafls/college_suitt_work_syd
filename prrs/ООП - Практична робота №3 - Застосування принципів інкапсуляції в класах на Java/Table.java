public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isOccupied;
    private int currentGuests;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false;
        this.currentGuests = 0;
    }

    public boolean occupyTable(int guests) {
        if (!isOccupied && guests <= capacity) {
            isOccupied = true;
            currentGuests = guests;
            System.out.println("Стіл " + tableNumber + " зайнято (" + guests + " гостей)");
            return true;
        }
        System.out.println("Неможливо зайняти стіл " + tableNumber);
        return false;
    }

    public void freeTable() {
        isOccupied = false;
        currentGuests = 0;
        System.out.println("Стіл " + tableNumber + " звільнено");
    }

    boolean canReserve(int guests) {
        return !isOccupied && guests <= capacity;
    }

    protected boolean isSuitableForGroup(int groupSize) {
        return groupSize <= capacity && groupSize >= capacity - 2;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public String toString() {
        return "Стіл [номер=" + tableNumber + ", місткість=" + capacity + 
               ", зайнятий=" + isOccupied + ", гостей=" + currentGuests + "]";
    }
}