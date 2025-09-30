public class Main {
    public static void main(String[] args) {
        Visitor visitor = new Visitor("Андрій", "Пообідати", 25);
        Waiter waiter = new Waiter("Іван", 5);
        Cook cook = new Cook("Петро", "Італійська кухня");
        Menu menu = new Menu("Основне меню", 250.50);
        Order order = new Order(1, "Піца і салат");
        Table table = new Table(10, 4);
        Administrator admin = new Administrator("Марія", "Денна");
        Storage storage = new Storage("Головний склад", 500);
        CashDesk cashDesk = new CashDesk(1, 15000.75);
        RestaurantSystem system = new RestaurantSystem("РесторанПро", "1.0");

        System.out.println(visitor);
        System.out.println(waiter);
        System.out.println(cook);
        System.out.println(menu);
        System.out.println(order);
        System.out.println(table);
        System.out.println(admin);
        System.out.println(storage);
        System.out.println(cashDesk);
        System.out.println(system);
    }
}
