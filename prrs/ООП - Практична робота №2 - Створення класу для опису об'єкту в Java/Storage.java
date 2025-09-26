public class Storage {
    private String storageName;
    private int capacityKg;

    public Storage(String storageName, int capacityKg) {
        this.storageName = storageName;
        this.capacityKg = capacityKg;
    }

    public void doAction() {
        // Action implementation placeholder
    }

    @Override
    public String toString() {
        return "Storage [ storageName=" + storageName + ", capacityKg=" + capacityKg + " ]";
    }
}
