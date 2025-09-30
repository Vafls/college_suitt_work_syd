public class Administrator {
    private String adminName;
    private String shift;

    public Administrator(String adminName, String shift) {
        this.adminName = adminName;
        this.shift = shift;
    }

    public void doAction() {
        System.out.println(adminName + " виконує дію під час " + shift + " зміни.");
    }

    @Override
    public String toString() {
        return "Адміністратор [ ім'я адміністратора=" + adminName + ", зміна=" + shift + " ]";
    }
}
