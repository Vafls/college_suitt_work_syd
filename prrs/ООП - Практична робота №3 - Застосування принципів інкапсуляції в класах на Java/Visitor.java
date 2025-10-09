public class Visitor {
    private String visitorName;
    private String visitorGoal;
    private int visitorAge;
    private double budget;

    public Visitor(String visitorName, String visitorGoal, int visitorAge, double budget) {
        this.visitorName = visitorName;
        this.visitorGoal = visitorGoal;
        this.visitorAge = visitorAge;
        this.budget = budget;
    }

    public void makeReservation(Table table, int guests) {
        if (table.occupyTable(guests)) {
            System.out.println(visitorName + " забронював стіл для " + guests + " гостей");
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

    protected boolean isAdult() {
        return visitorAge >= 18;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Відвідувач [ім'я=" + visitorName + ", мета=" + visitorGoal + 
               ", вік=" + visitorAge + ", бюджет=" + budget + "]";
    }
}