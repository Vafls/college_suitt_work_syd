public class Administrator {
    private String adminName;
    private String shift;
    private int accessLevel;

    public Administrator(String adminName, String shift, int accessLevel) {
        this.adminName = adminName;
        this.shift = shift;
        this.accessLevel = accessLevel;
    }

    public void performDuty() {
        System.out.println(adminName + " виконує обов'язки під час " + shift + " зміни.");
    }

    public String getAdminName() {
        return adminName;
    }

    void changeShift(String newShift) {
        this.shift = newShift;
        System.out.println("Зміну змінено на: " + newShift);
    }

    protected boolean hasAccess(int requiredLevel) {
        return this.accessLevel >= requiredLevel;
    }

    private void logAction(String action) {
        System.out.println("ADMIN LOG: " + action + " - " + adminName);
    }

    @Override
    public String toString() {
        return "Адміністратор [ім'я=" + adminName + ", зміна=" + shift + ", рівень доступу=" + accessLevel + "]";
    }
}