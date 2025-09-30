public class Menu {
    private String menuName;
    private double averagePrice;

    public Menu(String menuName, double averagePrice) {
        this.menuName = menuName;
        this.averagePrice = averagePrice;
    }

    public void doAction() {
        System.out.println("Дія для меню \"" + menuName + "\" з середньою ціною " + averagePrice + " виконана.");
    }

    @Override
    public String toString() {
        return "Меню [ назва меню=" + menuName + ", середня ціна=" + averagePrice + " ]";
    }
}
