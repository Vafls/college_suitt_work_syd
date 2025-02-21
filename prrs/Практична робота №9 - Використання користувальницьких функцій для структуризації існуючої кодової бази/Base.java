import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        char[][] doska;
        int rozmir_doski = 3;
        Scanner scn = new Scanner(System.in);
        int vibor = 0;

        while (true) {
            rnMenu();
            vibor = gInput(scn);

            if (vibor == 1) {
                doska = intDoska(rozmir_doski);
                char gravec = 'X';
                int hid = 0;
                boolean peremoga = false;

                while (!peremoga && hid < rozmir_doski * rozmir_doski) {
                    rnDoska(doska);

                    int horse = gCoords(scn, "рядка", gravec, rozmir_doski);
                    if (horse == 88) break;

                    int cow = gCoords(scn, "стовпця", gravec, rozmir_doski);
                    if (cow == 88) break;

                    if (doska[2 * horse][2 * cow] == ' ') {
                        doska[2 * horse][2 * cow] = gravec;
                        hid++;
                    } else {
                        System.out.println("Ця клiтинка вже зайнята, виберiть iншу.");
                        continue;
                    }

                    peremoga = ifPeremoga(doska, gravec, horse, cow, rozmir_doski);

                    if (peremoga) {
                        rnDoska(doska);
                        System.out.println("Гравець " + gravec + " Виграв!");
                    } else if (hid == rozmir_doski * rozmir_doski) {
                        System.out.println("Нiчия!");
                    } else {
                        gravec = (gravec == 'X') ? 'O' : 'X';
                    }
                }
            } else if (vibor == 2) {
                rozmir_doski = izmNastroiky(scn);
            } else if (vibor == 3) {
                break;
            }
        }
    }

    private static void rnMenu() {
        System.out.println("|-----------------|");
        System.out.println("| Меню:           |");
        System.out.println("| 1. Грати        |");
        System.out.println("| 2. Налаштування |");
        System.out.println("| 3. Вихід        |");
        System.out.println("|---------------- |");
        System.out.print("Введіть пункт: ");
    }

    private static int gInput(Scanner scn) {
        int vibor = 0;
        if (scn.hasNextInt()) {
            vibor = scn.nextInt();
        } else {
            System.out.println("Потрiбно ввести цифру");
            scn.next();
        }
        return vibor;
    }

    private static char[][] intDoska(int rozmir_doski) {
        char[][] doska = new char[2 * rozmir_doski + 1][2 * rozmir_doski + 1];
        for (int i = 0; i < doska.length; i++) {
            for (int j = 0; j < doska[i].length; j++) {
                doska[i][j] = (i % 2 == 0) ? ((j % 2 == 0) ? ' ' : '|') : ((j % 2 == 0) ? '-' : '+');
            }
        }
        for (int i = 1; i <= rozmir_doski; i++) {
            doska[0][2 * i] = doska[2 * i][0] = (char) ('0' + i);
        }
        return doska;
    }

    private static void rnDoska(char[][] doska) {
        for (char[] row : doska) {
            System.out.println(row);
        }
    }

    private static int gCoords(Scanner scn, String type, char gravec, int rozmir_doski) {
        int coord = -1;
        while (coord < 1 || coord > rozmir_doski) {
            System.out.print("Гравець " + gravec + ", Введiть номер " + type + " (чи '88' для вихода в головне меню): ");
            if (scn.hasNextInt()) {
                coord = scn.nextInt();
                if (coord == 88) break;
            } else {
                System.out.println("Потрiбно ввести цифру");
                scn.next();
            }
        }
        return coord;
    }

    private static boolean ifPeremoga(char[][] doska, char gravec, int horse, int cow, int rozmir_doski) {
        int[][] drcts = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
        for (int[] drct : drcts) {
            int shetchik = 1;
            for (int znak = -1; znak <= 1; znak += 2) {
                for (int i = 1; i < 3; i++) {
                    int nn = horse + drct[0] * i * znak, ny = cow + drct[1] * i * znak;
                    if (nn < 1 || ny < 1 || nn > rozmir_doski || ny > rozmir_doski || doska[2 * nn][2 * ny] != gravec) {
                        break;
                    }
                    shetchik++;
                }
            }
            if (shetchik >= 3) {
                return true;
            }
        }
        return false;
    }

    private static int izmNastroiky(Scanner scn) {
        System.out.println("|-----Налаштування--------|");
        System.out.println("| 1. Змінити поле на 3x3  |");
        System.out.println("| 2. Змінити поле на 5x5  |");
        System.out.println("| 3. Змінити поле на 7x7  |");
        System.out.println("| 4. Змінити поле на 9x9  |");
        System.out.println("| 5. Вихід в головне меню |");
        System.out.println("|-------------------------|");
        System.out.print("Введіть пункт: ");
        int rozmir_doski = 3;
        if (scn.hasNextInt()) {
            int vtoroyvibor = scn.nextInt();
            if (vtoroyvibor >= 1 && vtoroyvibor <= 4) {
                rozmir_doski = 3 + 2 * (vtoroyvibor - 1);
            }
        } else {
            System.out.println("Потрiбно ввести цифру");
            scn.next();
        }
        return rozmir_doski;
    }
}
