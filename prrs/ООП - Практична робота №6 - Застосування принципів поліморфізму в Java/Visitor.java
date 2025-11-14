public class Visitor extends AbstractPerson {
    private String visitorGoal;
    private double budget;
    
    public Visitor(NameInfo nameInfo, String visitorGoal, int age, double budget) {
        super(nameInfo, age);
        this.visitorGoal = visitorGoal;
        this.budget = budget;
    }
    
    @Override
    public void introduce() {
        System.out.println("Привіт, я відвідувач " + nameInfo.getFullName() + ", моя мета: " + visitorGoal);
    }
    
    @Override
    public boolean isAdult() {
        System.out.println("Перевірка віку для відвідувача " + nameInfo.getFullName());
        return age >= 18;
    }
    
    @Override
    public String getRole() {
        return "Відвідувач";
    }
    
    @Override
    public void performAction() {
        System.out.println(nameInfo.getFullName() + " переглядає меню та робить замовлення");
    }
    
    public void makeReservation(Table table, int guests) {
        if (table.occupyTable(guests)) {
            System.out.println(nameInfo.getFullName() + " забронював стіл для " + guests + " гостей");
        }
    }
    
    public void makeOrder(Order order, String item, double price) {
        if (price <= budget) {
            order.addItem(item, price);
            budget -= price;
        } else {
            System.out.println("Недостатньо коштів для: " + item);
        }
    }
    
    void changeGoal(String newGoal) {
        this.visitorGoal = newGoal;
    }
    
    public static String getVisitorRights() {
        return "Відвідувач має право на якісне обслуговування та безпечне перебування";
    }
    
    public double getBudget() {
        return budget;
    }
    
    @Override
    public String toString() {
        return "Відвідувач [ім'я=" + nameInfo.getFullName() + ", мета=" + visitorGoal + 
               ", вік=" + age + ", бюджет=" + budget + "]";
    }
}