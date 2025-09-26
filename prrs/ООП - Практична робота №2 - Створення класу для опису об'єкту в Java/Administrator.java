public class Administrator {
    private String adminName;
    private String shift;

    public Administrator(String adminName, String shift) {
        this.adminName = adminName;
        this.shift = shift;
    }

    public void doAction() {
        System.out.println(adminName + " is performing an action during " + shift + " shift.");
    }

    @Override
    public String toString() {
        return "Administrator [ adminName=" + adminName + ", shift=" + shift + " ]";
    }
}
