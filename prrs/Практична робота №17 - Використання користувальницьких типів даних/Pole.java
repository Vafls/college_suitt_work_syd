public class Pole {
    public char[][] dani;
    public int rozmir;

    public Pole(int rozmir) {
        this.rozmir = rozmir;
        this.dani = new char[2 * rozmir + 1][2 * rozmir + 1];

        for (int i = 0; i < dani.length; i++) {
            for (int j = 0; j < dani[i].length; j++) {
                dani[i][j] = (i % 2 == 0) ? ((j % 2 == 0) ? ' ' : '|') : ((j % 2 == 0) ? '-' : '+');
            }
        }

        for (int i = 1; i <= rozmir; i++) {
            dani[0][2 * i] = dani[2 * i][0] = (char) ('0' + i);
        }
    }
}
