public class Menu {
    private String menuName;
    private double averagePrice;

    public Menu(String menuName, double averagePrice) {
        this.menuName = menuName;
        this.averagePrice = averagePrice;
    }

    public void doAction() {
        // Action not implemented yet
    }

    @Override
    public String toString() {
        return "Menu [ menuName=" + menuName + ", averagePrice=" + averagePrice + " ]";
    }
}
