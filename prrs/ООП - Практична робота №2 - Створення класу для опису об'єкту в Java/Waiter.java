public class Waiter {
    private String waiterName;
    private int experienceYears;

    public Waiter(String waiterName, int experienceYears) {
        this.waiterName = waiterName;
        this.experienceYears = experienceYears;
    }

    public void doAction() {
        System.out.println(waiterName + " is serving a customer.");
    }

    @Override
    public String toString() {
        return "Waiter [ waiterName=" + waiterName + ", experienceYears=" + experienceYears + " ]";
    }
}
