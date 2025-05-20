import java.util.Scanner;
import java.time.LocalDateTime;

public class Gra {
    public static void pochatuGrata(String im1, String im2, int rozmir, Scanner skan) {
        char[][] pole = Doska.stvorytyDosku(rozmir);
        char znakGrav = 'X';
        int hidiv = 0;
        boolean yePeremoga = false;
        LocalDateTime pochav = LocalDateTime.now();

        while (!yePeremoga && hidiv < rozmir * rozmir) {
            Doska.pokazatyDosku(pole);

            int ryad = Doska.vvestyKoordynatu(skan, "рядка", znakGrav, rozmir);
            if (ryad == 88) return;

            int stovp = Doska.vvestyKoordynatu(skan, "стовпця", znakGrav, rozmir);
            if (stovp == 88) return;

            if (pole[2 * ryad][2 * stovp] == ' ') {
                pole[2 * ryad][2 * stovp] = znakGrav;
                hidiv++;
            } else {
                System.out.println("Це поле вже занято.");
                continue;
            }

            yePeremoga = Doska.perevirytyPeremogu(pole, znakGrav, ryad, stovp, rozmir);

            if (yePeremoga) {
                Doska.pokazatyDosku(pole);
                String imaPerem = (znakGrav == 'X') ? im1 : im2;
                System.out.println("Гравець " + imaPerem + " (" + znakGrav + ") Виграв!");
                Zberezhennia.zberehtyStatystyku(imaPerem, znakGrav, pochav, rozmir, im1, im2);
            } else if (hidiv == rozmir * rozmir) {
                System.out.println("Нiчия!");
                Zberezhennia.zberehtyStatystyku("Нiчия", ' ', pochav, rozmir, im1, im2);
            } else {
                znakGrav = (znakGrav == 'X') ? 'O' : 'X';
            }
        }
    }
}
