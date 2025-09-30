public class Waiter {
    private String waiterName;
    private int experienceYears;

    public Waiter(String waiterName, int experienceYears) {
        this.waiterName = waiterName;
        this.experienceYears = experienceYears;
    }

    public void doAction() {
        System.out.println(waiterName + " обслуговує клієнта.");
    }

    @Override
    public String toString() {
        return "Офіціант [ ім'я=" + waiterName + ", досвід=" + experienceYears + " років ]";
    }
}
