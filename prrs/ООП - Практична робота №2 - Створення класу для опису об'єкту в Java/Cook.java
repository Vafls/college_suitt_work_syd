public class Cook {
    private String cookName;
    private String specialization;

    public Cook(String cookName, String specialization) {
        this.cookName = cookName;
        this.specialization = specialization;
    }

    public void doAction() {
        System.out.println(cookName + " готує страву спеціалізації: " + specialization + ".");
    }

    @Override
    public String toString() {
        return "Кухар [ ім'я=" + cookName + ", спеціалізація=" + specialization + " ]";
    }
}
