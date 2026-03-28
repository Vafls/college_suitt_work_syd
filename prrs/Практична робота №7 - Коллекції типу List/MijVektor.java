public class MijVektor {

    private int[] dani;
    private int rozmir;
    private int mistkist;

    public MijVektor() {
        mistkist = 4;
        dani = new int[mistkist];
        rozmir = 0;
    }

    private void rozshyryty() {
        mistkist *= 2;
        int[] noviDani = new int[mistkist];
        for (int i = 0; i < rozmir; i++) {
            noviDani[i] = dani[i];
        }
        dani = noviDani;
    }

    public void dodatyVKinez(int znachennia) {
        if (rozmir == mistkist) rozshyryty();
        dani[rozmir] = znachennia;
        rozmir++;
    }

    public void dodatyZaIndeksom(int indeks, int znachennia) {
        if (indeks < 0 || indeks > rozmir) throw new IndexOutOfBoundsException("Indeks: " + indeks);
        if (rozmir == mistkist) rozshyryty();
        for (int i = rozmir; i > indeks; i--) {
            dani[i] = dani[i - 1];
        }
        dani[indeks] = znachennia;
        rozmir++;
    }

    public void dodatyVPochatok(int znachennia) {
        dodatyZaIndeksom(0, znachennia);
    }

    public int otrymaty(int indeks) {
        if (indeks < 0 || indeks >= rozmir) throw new IndexOutOfBoundsException("Indeks: " + indeks);
        return dani[indeks];
    }

    public int rozmir() {
        return rozmir;
    }

    public int mistkist() {
        return mistkist;
    }

    public void vyluchytyZaIndeksom(int indeks) {
        if (indeks < 0 || indeks >= rozmir) throw new IndexOutOfBoundsException("Indeks: " + indeks);
        for (int i = indeks; i < rozmir - 1; i++) {
            dani[i] = dani[i + 1];
        }
        rozmir--;
    }

    public void ochystyty() {
        dani = new int[mistkist];
        rozmir = 0;
    }

    @Override
    public String toString() {
        StringBuilder rezultat = new StringBuilder("[");
        for (int i = 0; i < rozmir; i++) {
            rezultat.append(dani[i]);
            if (i < rozmir - 1) rezultat.append(", ");
        }
        rezultat.append("]");
        return rezultat.toString();
    }

    public static void main(String[] args) {
        MijVektor v = new MijVektor();

        v.dodatyVKinez(10);
        v.dodatyVKinez(20);
        v.dodatyVKinez(30);
        System.out.println("Після dodatyVKinez: " + v);

        v.dodatyVPochatok(5);
        System.out.println("Після dodatyVPochatok(5): " + v);

        v.dodatyZaIndeksom(2, 15);
        System.out.println("Після dodatyZaIndeksom(2, 15): " + v);

        System.out.println("otrymaty(2) = " + v.otrymaty(2));

        System.out.println("rozmir = " + v.rozmir() + ", mistkist = " + v.mistkist());

        v.vyluchytyZaIndeksom(1);
        System.out.println("Після vyluchytyZaIndeksom(1): " + v);

        v.ochystyty();
        System.out.println("Після ochystyty(): " + v);
        System.out.println("rozmir = " + v.rozmir() + ", mistkist = " + v.mistkist());
    }
}
