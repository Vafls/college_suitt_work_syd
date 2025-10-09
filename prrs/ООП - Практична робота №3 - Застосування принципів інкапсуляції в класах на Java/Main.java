public class Main {
    public static void main(String[] args) {
        Visitor visitor = new Visitor("Андрій", "Пообідати", 25, 500.0);
        Waiter waiter = new Waiter("Іван", 5);
        Cook cook = new Cook("Петро", "Італійська кухня", 8);
        Menu menu = new Menu("Основне меню", false);
        Order order = new Order(1);
        Table table = new Table(10, 4);
        Administrator admin = new Administrator("Марія", "Денна", 3);
        Storage storage = new Storage("Головний склад", 500, "Підвал");
        CashDesk cashDesk = new CashDesk(1, 15000.75);
        RestaurantSystem system = new RestaurantSystem("РесторанПро", "1.0");

        visitor.makeReservation(table, 3);
        menu.addDish("Піца Маргарита", 250.0);
        menu.addDish("Салат Цезар", 180.0);
        
        visitor.makeOrder(order, "Піца Маргарита", 250.0);
        visitor.makeOrder(order, "Салат Цезар", 180.0);
        
        waiter.serveTable(table);
        waiter.receiveTip(50.0);
        
        cook.prepareDish("Піца Маргарита");
        
        cashDesk.deposit(1000.0);
        cashDesk.withdraw(500.0);
        
        storage.addProduct(100);
        storage.removeProduct(50);
        
        system.startSystem();
        system.addUser();

        System.out.println("\n=== Інформація про всі об'єкти ===");
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

        System.out.println("\n=== Демонстрація методів ===");
        admin.changeShift("Нічна");
        cashDesk.processPayment(300.0);
        cook.changeSpecialization("Французька кухня");
    }
}