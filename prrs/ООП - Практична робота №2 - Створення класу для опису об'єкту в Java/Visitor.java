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
        // Action implementation placeholder
    }

    @Override
    public String toString() {
        return "Visitor [ visitorName=" + visitorName + ", visitorGoal=" + visitorGoal + ", visitorAge=" + visitorAge + " ]";
    }
}
