public class Cook {
    private String cookName;
    private String specialization;

    public Cook(String cookName, String specialization) {
        this.cookName = cookName;
        this.specialization = specialization;
    }

    public void doAction() {
        System.out.println(cookName + " is cooking a " + specialization + " dish.");
    }

    @Override
    public String toString() {
        return "Cook [ cookName=" + cookName + ", specialization=" + specialization + " ]";
    }
}
