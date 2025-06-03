import java.util.Scanner;

public class Doska {

    public static Pole stvorytyDosku(int rozmir) {
        return new Pole(rozmir);
    }

    public static void pokazatyDosku(Pole pole) {
        for (char[] ryad : pole.dani) {
            System.out.println(ryad);
        }
    }

    public static int vvestyKoordynatu(Scanner skan, String tip, char znak, int rozmir) {
        int koord = -1;
        while (koord < 1 || koord > rozmir) {
            System.out.print("Гравець " + znak + ", введiть номер " + tip + " (88 - вихiд): ");
            if (skan.hasNextInt()) {
                koord = skan.nextInt();
                if (koord == 88) break;
            } else {
                System.out.println("Необхiдно ввести цифру.");
                skan.next();
            }
        }
        return koord;
    }

    public static boolean perevirytyPeremogu(Pole pole, char znak, int ryad, int stovp) {
        int rozmir = pole.rozmir;
        char[][] doska = pole.dani;
        int[][] napr = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

        for (int[] dir : napr) {
            int kilkist = 1;
            for (int zn = -1; zn <= 1; zn += 2) {
                for (int k = 1; k < 3; k++) {
                    int novR = ryad + dir[0] * k * zn;
                    int novS = stovp + dir[1] * k * zn;
                    if (novR < 1 || novS < 1 || novR > rozmir || novS > rozmir || doska[2 * novR][2 * novS] != znak) {
                        break;
                    }
                    kilkist++;
                }
            }
            if (kilkist >= 3) return true;
        }
        return false;
    }
}
