import java.util.Scanner;
import java.time.LocalDateTime;

public class Gra {
    public static void pochatuGrata(Nalashtuvannya nalash, Scanner skan) {
        Pole pole = Doska.stvorytyDosku(nalash.rozmirPolya);
        char znakGrav = 'X';
        int hidiv = 0;
        boolean yePeremoga = false;
        LocalDateTime pochav = LocalDateTime.now();

        while (!yePeremoga && hidiv < nalash.rozmirPolya * nalash.rozmirPolya) {
            Doska.pokazatyDosku(pole);

            int ryad = Doska.vvestyKoordynatu(skan, "рядка", znakGrav, nalash.rozmirPolya);
            if (ryad == 88) return;

            int stovp = Doska.vvestyKoordynatu(skan, "стовпця", znakGrav, nalash.rozmirPolya);
            if (stovp == 88) return;

            if (pole.dani[2 * ryad][2 * stovp] == ' ') {
                pole.dani[2 * ryad][2 * stovp] = znakGrav;
                hidiv++;
            } else {
                System.out.println("Це поле вже занято.");
                continue;
            }

            yePeremoga = Doska.perevirytyPeremogu(pole, znakGrav, ryad, stovp);

            if (yePeremoga) {
                Doska.pokazatyDosku(pole);
                String imaPerem = (znakGrav == 'X') ? nalash.imGrav1 : nalash.imGrav2;
                System.out.println("Гравець " + imaPerem + " (" + znakGrav + ") Виграв!");
                Zberezhennia.zberehtyStatystyku(new Statystyka(imaPerem, znakGrav, pochav, nalash));
            } else if (hidiv == nalash.rozmirPolya * nalash.rozmirPolya) {
                System.out.println("Нiчия!");
                Zberezhennia.zberehtyStatystyku(new Statystyka("Нiчия", ' ', pochav, nalash));
            } else {
                znakGrav = (znakGrav == 'X') ? 'O' : 'X';
            }
        }
    }
}
