public class Main {
    public static void main(String[] args) {
        Visitor visitor = new Visitor("Андрей", "Пообедать", 25);
        Waiter waiter = new Waiter("Иван", 5);
        Cook cook = new Cook("Петр", "Итальянская кухня");
        Menu menu = new Menu("Основное меню", 250.50);
        Order order = new Order(1, "Пицца и салат");
        Table table = new Table(10, 4);
        Administrator admin = new Administrator("Мария", "Дневная");
        Storage storage = new Storage("Главный склад", 500);
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
