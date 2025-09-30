public class Storage {
    private String storageName;
    private int capacityKg;

    public Storage(String storageName, int capacityKg) {
        this.storageName = storageName;
        this.capacityKg = capacityKg;
    }

    public void doAction() {
        System.out.println("Виконується дія для складу: " + storageName);
    }

    @Override
    public String toString() {
        return "Склад [ назва=" + storageName + ", місткість(кг)=" + capacityKg + " ]";
    }
}
