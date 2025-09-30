public class RestaurantSystem {
    private String systemName;
    private String version;

    public RestaurantSystem(String systemName, String version) {
        this.systemName = systemName;
        this.version = version;
    }

    public void doAction() {
        System.out.println("Виконується дія в системі ресторану...");
    }

    @Override
    public String toString() {
        return "Система ресторану [ назва=" + systemName + ", версія=" + version + " ]";
    }
}
