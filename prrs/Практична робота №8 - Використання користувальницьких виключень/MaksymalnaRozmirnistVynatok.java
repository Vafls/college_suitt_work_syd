public class MaksymalnaRozmirnistVynatok extends RuntimeException {
    public static final int MAKS_ROZMIR = 1000;

    public MaksymalnaRozmirnistVynatok() {
        super("Вектор досяг максимального розміру: " + MAKS_ROZMIR + " елементів");
    }
}
