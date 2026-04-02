public class MijVektor {

    private int[] dani;
    private int rozmir;
    private int mistkist;

    public MijVektor() {
        mistkist = 4;
        dani = new int[mistkist];
        rozmir = 0;
    }

    public MijVektor(int pochatkovaMistkist) throws NevirnaPochtkovaRozmirnistVynatok {
        if (pochatkovaMistkist <= 0) {
            throw new NevirnaPochtkovaRozmirnistVynatok(pochatkovaMistkist);
        }
        mistkist = pochatkovaMistkist;
        dani = new int[mistkist];
        rozmir = 0;
    }

    private void rozshyryty() {
        if (mistkist >= MaksymalnaRozmirnistVynatok.MAKS_ROZMIR) {
            throw new MaksymalnaRozmirnistVynatok();
        }
        mistkist = Math.min(mistkist * 2, MaksymalnaRozmirnistVynatok.MAKS_ROZMIR);
        int[] noviDani = new int[mistkist];
        for (int i = 0; i < rozmir; i++) {
            noviDani[i] = dani[i];
        }
        dani = noviDani;
    }

    private void perevirytyIndeks(int indeks) {
        if (rozmir == 0) {
            throw new PorozhnijVektorVynatok();
        }
        if (indeks < 0 || indeks >= rozmir) {
            throw new NevirnyiIndeksVynatok(indeks, rozmir);
        }
    }

    private void perevirytyZnachennia(int znachennia) throws NedopustymeZnachennyaVynatok {
        if (znachennia < 0) {
            throw new NedopustymeZnachennyaVynatok(znachennia);
        }
    }

    public void dodatyVKinez(int znachennia) throws NedopustymeZnachennyaVynatok {
        perevirytyZnachennia(znachennia);
        if (rozmir == mistkist) rozshyryty();
        dani[rozmir] = znachennia;
        rozmir++;
    }

    public void dodatyZaIndeksom(int indeks, int znachennia) throws NedopustymeZnachennyaVynatok {
        perevirytyZnachennia(znachennia);
        if (indeks < 0 || indeks > rozmir) {
            throw new NevirnyiIndeksVynatok(indeks, rozmir);
        }
        if (rozmir == mistkist) rozshyryty();
        for (int i = rozmir; i > indeks; i--) {
            dani[i] = dani[i - 1];
        }
        dani[indeks] = znachennia;
        rozmir++;
    }

    public void dodatyVPochatok(int znachennia) throws NedopustymeZnachennyaVynatok {
        dodatyZaIndeksom(0, znachennia);
    }

    public int otrymaty(int indeks) {
        perevirytyIndeks(indeks);
        return dani[indeks];
    }

    public int rozmir() { return rozmir; }
    public int mistkist() { return mistkist; }

    public void vyluchytyZaIndeksom(int indeks) {
        perevirytyIndeks(indeks);
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
}
