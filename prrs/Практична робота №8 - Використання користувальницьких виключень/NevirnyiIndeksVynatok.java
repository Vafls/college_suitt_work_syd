public class NevirnyiIndeksVynatok extends RuntimeException {
    private int indeks;
    private int rozmir;

    public NevirnyiIndeksVynatok(int indeks, int rozmir) {
        super("Неприпустимий індекс: " + indeks + ". Поточний розмір вектора: " + rozmir);
        this.indeks = indeks;
        this.rozmir = rozmir;
    }

    public int otrymatyIndeks() { return indeks; }
    public int otrymatyRozmir() { return rozmir; }
}
