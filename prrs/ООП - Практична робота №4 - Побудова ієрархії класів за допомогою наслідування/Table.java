public class Table extends RestaurantObject {
    private int capacity;
    private boolean isOccupied;
    private int currentGuests;
    
    public Table(int tableNumber, int capacity) {
        super("Стіл", tableNumber);
        this.capacity = capacity;
        this.isOccupied = false;
        this.currentGuests = 0;
    }
    
    @Override
    public void use() {
        System.out.println("Використовуємо стіл " + id + " для " + currentGuests + " гостей");
    }
    
    public boolean occupyTable(int guests) {
        if (!isOccupied && guests <= capacity) {
            isOccupied = true;
            currentGuests = guests;
            System.out.println("Стіл " + id + " зайнято (" + guests + " гостей)");
            return true;
        }
        System.out.println("Неможливо зайняти стіл " + id);
        return false;
    }
    
    public void freeTable() {
        isOccupied = false;
        currentGuests = 0;
        System.out.println("Стіл " + id + " звільнено");
    }
    
    boolean canReserve(int guests) {
        return !isOccupied && guests <= capacity;
    }
    
    @Override
    protected boolean isSuitableForGroup(int groupSize) {
        System.out.println("Перевірка придатності столу " + id + " для групи");
        return groupSize <= capacity && groupSize >= capacity - 2;
    }
    
    public boolean isOccupied() {
        return isOccupied;
    }
    
    @Override
    public String toString() {
        return "Стіл [номер=" + id + ", місткість=" + capacity + 
               ", зайнятий=" + isOccupied + ", гостей=" + currentGuests + "]";
    }
}