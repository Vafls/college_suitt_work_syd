public class Nalashtuvannya {
    public String imGrav1;
    public String imGrav2;
    public int rozmirPolya;

    public Nalashtuvannya(String imGrav1, String imGrav2, int rozmirPolya) {
        this.imGrav1 = imGrav1;
        this.imGrav2 = imGrav2;
        this.rozmirPolya = rozmirPolya;
    }

    public Nalashtuvannya() {
        this("Гравець 1", "Гравець 2", 3);
    }
}
