public class Visitor {
    private String visitorName;
    private String visitorGoal;
    private int visitorAge;

    public Visitor(String visitorName, String visitorGoal, int visitorAge) {
        this.visitorName = visitorName;
        this.visitorGoal = visitorGoal;
        this.visitorAge = visitorAge;
    }

    public void doAction() {
        System.out.println("Відвідувач " + visitorName + " виконує дію з метою: " + visitorGoal);
    }

    @Override
    public String toString() {
        return "Відвідувач [ ім'я=" + visitorName + ", мета=" + visitorGoal + ", вік=" + visitorAge + " ]";
    }
}
