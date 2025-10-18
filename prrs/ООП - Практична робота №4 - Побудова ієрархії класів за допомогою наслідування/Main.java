public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ НАСЛІДУВАННЯ ===");
        
        Person visitor = new Visitor("Андрій", "Пообідати", 25, 500.0);
        Employee waiter = new Waiter("Іван", 5);
        Employee cook = new Cook("Петро", "Італійська кухня", 8);
        Employee admin = new Administrator("Марія", "Денна", 3);
        
        RestaurantObject table = new Table(10, 4);
        RestaurantObject storage = new Storage("Головний склад", 500, "Підвал");
        RestaurantObject cashDesk = new CashDesk(1, 15000.75);
        RestaurantObject menu = new Menu("Основне меню", false);
        RestaurantObject order = new Order(1);
        RestaurantObject system = new RestaurantSystem("РесторанПро", "1.0");

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ПОЛІМОРФІЗМУ ДЛЯ PERSON ===");
        Person[] people = {visitor, waiter, cook, admin};
        for (Person person : people) {
            person.introduce();
            System.out.println("Дорослий: " + person.isAdult());
        }

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ПОЛІМОРФІЗМУ ДЛЯ EMPLOYEE ===");
        Employee[] employees = {(Employee)waiter, (Employee)cook, (Employee)admin};
        for (Employee employee : employees) {
            employee.work();
            employee.changeShift("Нова зміна");
        }

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ПОЛІМОРФІЗМУ ДЛЯ RESTAURANT OBJECT ===");
        RestaurantObject[] objects = {table, storage, cashDesk, menu, order, system};
        for (RestaurantObject obj : objects) {
            obj.use();
            System.out.println("Валідний: " + obj.isValid());
        }

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ПЕРЕВИЗНАЧЕНИХ PROTECTED МЕТОДІВ ===");
        ((Visitor)visitor).isAdult();
        ((Waiter)waiter).isExperienced();
        ((Cook)cook).canPrepareComplexDish();
        ((Administrator)admin).hasAccess(2);
        ((Table)table).isSuitableForGroup(3);
        ((Storage)storage).needsRestock();
        ((CashDesk)cashDesk).getTransactionCount();
        ((Menu)menu).isSeasonalMenu();
        ((Order)order).canBeModified();
        ((RestaurantSystem)system).canHandleMoreUsers();

        System.out.println("\n=== ДЕМОНСТРАЦІЯ РОБОТИ ЗАСТОСУНКУ ===");
        ((Visitor)visitor).makeReservation((Table)table, 3);
        ((Menu)menu).addDish("Піца Маргарита", 250.0);
        ((Menu)menu).addDish("Салат Цезар", 180.0);
        
        ((Visitor)visitor).makeOrder((Order)order, "Піца Маргарита", 250.0);
        ((Visitor)visitor).makeOrder((Order)order, "Салат Цезар", 180.0);
        
        ((Waiter)waiter).serveTable((Table)table);
        ((Waiter)waiter).receiveTip(50.0);
        
        ((Cook)cook).prepareDish("Піца Маргарита");
        
        ((CashDesk)cashDesk).deposit(1000.0);
        ((CashDesk)cashDesk).withdraw(500.0);
        
        ((Storage)storage).addProduct(100);
        ((Storage)storage).removeProduct(50);
        
        ((RestaurantSystem)system).startSystem();
        ((RestaurantSystem)system).addUser();

        System.out.println("\n=== ІНФОРМАЦІЯ ПРО ВСІ ОБ'ЄКТИ ===");
        for (Person person : people) {
            System.out.println(person);
        }
        for (RestaurantObject obj : objects) {
            System.out.println(obj);
        }

        System.out.println("\n=== ДЕМОНСТРАЦІЯ СПЕЦИФІЧНИХ МЕТОДІВ ===");
        ((Administrator)admin).changeShift("Нічна");
        ((CashDesk)cashDesk).processPayment(300.0);
        ((Cook)cook).changeSpecialization("Французька кухня");
    }
}