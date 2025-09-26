public class RestaurantSystem {
    private String systemName;
    private String version;

    public RestaurantSystem(String systemName, String version) {
        this.systemName = systemName;
        this.version = version;
    }

    public void doAction() {
        // Action implementation goes here
    }

    @Override
    public String toString() {
        return "RestaurantSystem [ systemName=" + systemName + ", version=" + version + " ]";
    }
}
