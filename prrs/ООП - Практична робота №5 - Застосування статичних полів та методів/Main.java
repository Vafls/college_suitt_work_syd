public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ СТАТИЧНИХ МЕТОДІВ ===");
        System.out.println("Опис класу Person: " + Person.getSpeciesDescription());
        System.out.println("Опис класу Employee: " + Employee.getProfessionDescription());
        System.out.println("Поради кухаря: " + Cook.getCookingTips());
        System.out.println("Стандарти обслуговування: " + Waiter.getServiceStandards());
        System.out.println("Обов'язки адміністратора: " + Administrator.getAdminResponsibilities());
        System.out.println("Права відвідувача: " + Visitor.getVisitorRights());
        System.out.println("Опис RestaurantObject: " + RestaurantObject.getObjectTypeDescription());
        
        System.out.println("\n=== ДЕМОНСТРАЦІЯ OBJECT FACTORY ===");
        
        Visitor visitor = ObjectFactory.createVisitor("Андрій", "Шевченко", 25, "Пообідати", 500.0);
        Waiter waiter = ObjectFactory.createWaiter("Іван", "Петренко", 30, 5);
        Cook cook = ObjectFactory.createCook("Петро", "Іваненко", 35, "Італійська кухня", 8);
        Administrator admin = ObjectFactory.createAdministrator("Марія", "Сидоренко", 28, "Денна", 3);
        
        Table table = ObjectFactory.createTable(10, 4);
        Storage storage = ObjectFactory.createStorage("Головний склад", 500, "Підвал");
        CashDesk cashDesk = ObjectFactory.createCashDesk(1, 15000.75);
        Menu menu = ObjectFactory.createMenu("Основне меню", false);
        Order order = ObjectFactory.createOrder(1);
        RestaurantSystem system = ObjectFactory.createRestaurantSystem("РесторанПро", "1.0");

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ПОЛІМОРФІЗМУ ДЛЯ PERSON ===");
        Person[] people = {visitor, waiter, cook, admin};
        for (Person person : people) {
            person.introduce();
            System.out.println("Дорослий: " + person.isAdult());
        }

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ПОЛІМОРФІЗМУ ДЛЯ EMPLOYEE ===");
        Employee[] employees = {waiter, cook, admin};
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
        visitor.isAdult();
        waiter.isExperienced();
        cook.canPrepareComplexDish();
        admin.hasAccess(2);
        table.isSuitableForGroup(3);
        storage.needsRestock();
        cashDesk.getTransactionCount();
        menu.isSeasonalMenu();
        order.canBeModified();
        system.canHandleMoreUsers();

        System.out.println("\n=== ДЕМОНСТРАЦІЯ РОБОТИ ЗАСТОСУНКУ ===");
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

        System.out.println("\n=== ІНФОРМАЦІЯ ПРО ВСІ ОБ'ЄКТИ ===");
        for (Person person : people) {
            System.out.println(person);
        }
        for (RestaurantObject obj : objects) {
            System.out.println(obj);
        }

        System.out.println("\n=== ДЕМОНСТРАЦІЯ СПЕЦИФІЧНИХ МЕТОДІВ ===");
        admin.changeShift("Нічна");
        cashDesk.processPayment(300.0);
        cook.changeSpecialization("Французька кухня");
        
        System.out.println("\n=== ІНФОРМАЦІЯ ПРО СХОВИЩЕ ===");
        RestaurantStorage.displayStorageInfo();
        
        System.out.println("\n=== ІНФОРМАЦІЯ ПРО FACTORY ===");
        ObjectFactory.displayFactoryInfo();
    }
}