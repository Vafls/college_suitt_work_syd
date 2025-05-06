import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Base {
    private static final String CONFIG_FILE = "config.txt";
    private static final String STATS_FILE = "stats.txt";
    private static String gr1 = "Гравець 1";
    private static String gr2 = "Гравець 2";
    private static int rozmir_doski = 3;
    
    public static void main(String[] args) {
        char[][] doska;
        Scanner scn = new Scanner(System.in);
        int vibor = 0;
        
        loadConfig();

        while (true) {
            rnMenu();
            vibor = gInput(scn);

            if (vibor == 1) {
                doska = intDoska(rozmir_doski);
                char gravec = 'X';
                int hid = 0;
                boolean peremoga = false;
                LocalDateTime startTime = LocalDateTime.now();

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
                        String winnerName = (gravec == 'X') ? gr1 : gr2; 
                        System.out.println("Гравець " + winnerName + " (" + gravec + ") Виграв!");
                        saveStats(winnerName, gravec, startTime);
                    } else if (hid == rozmir_doski * rozmir_doski) {
                        System.out.println("Нiчия!");
                        saveStats("Нічия", ' ', startTime);
                    } else {
                        gravec = (gravec == 'X') ? 'O' : 'X';
                    }
                }
            } else if (vibor == 2) {
                settingsMenu(scn);
            } else if (vibor == 3) {
                showStats();
            } else if (vibor == 4) {
                break;
            }
        }
    }

    private static void rnMenu() {
        System.out.println("|-----------------|");
        System.out.println("| Меню:           |");
        System.out.println("| 1. Грати        |");
        System.out.println("| 2. Налаштування |");
        System.out.println("| 3. Статистика   |");
        System.out.println("| 4. Вихід        |");
        System.out.println("|---------------- |");
        System.out.print("Введіть пункт: ");
    }

    private static void settingsMenu(Scanner scn) {
        System.out.println("|-----Налаштування--------|");
        System.out.println("| 1. Змінити поле        |");
        System.out.println("| 2. Змінити ім'я гравця X|");
        System.out.println("| 3. Змінити ім'я гравця O|");
        System.out.println("| 4. Зберегти налаштування|");
        System.out.println("| 5. Вихід в головне меню |");
        System.out.println("|-------------------------|");
        System.out.print("Введіть пункт: ");
        
        if (scn.hasNextInt()) {
            int choice = scn.nextInt();
            scn.nextLine();
            
            switch (choice) {
                case 1:
                    rozmir_doski = changeBoardSize(scn);
                    break;
                case 2:
                    System.out.print("Введіть нове ім'я для гравця X: ");
                    gr1 = scn.nextLine(); 
                    break;
                case 3:
                    System.out.print("Введіть нове ім'я для гравця O: ");
                    gr2 = scn.nextLine();
                    break;
                case 4:
                    saveConfig();
                    System.out.println("Налаштування збережено.");
                    break;
            }
        } else {
            System.out.println("Потрiбно ввести цифру");
            scn.next();
        }
    }

    private static int changeBoardSize(Scanner scn) {
        System.out.println("|-----Розмір поля--------|");
        System.out.println("| Введіть непарне число  |");
        System.out.println("| від 3 до 9:            |");
        System.out.println("|------------------------|");
        System.out.print("Введіть розмір: ");
        
        if (scn.hasNextInt()) {
            int size = scn.nextInt();
            if (size >= 3 && size <= 9 && size % 2 == 1) {
                return size;
            } else {
                System.out.println("Некоректний розмір. Встановлено 3x3.");
            }
        } else {
            System.out.println("Потрiбно ввести цифру");
            scn.next();
        }
        return 3;
    }

    private static void saveConfig() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CONFIG_FILE))) {
            writer.println(rozmir_doski);
            writer.println(gr1);
            writer.println(gr2);
        } catch (IOException e) {
            System.out.println("Помилка збереження конфігурації: " + e.getMessage());
        }
    }

    private static void loadConfig() {
        try (Scanner fileScanner = new Scanner(new File(CONFIG_FILE))) {
            if (fileScanner.hasNextInt()) {
                rozmir_doski = fileScanner.nextInt();
                fileScanner.nextLine();
            }
            if (fileScanner.hasNextLine()) {
                gr1 = fileScanner.nextLine();
            }
            if (fileScanner.hasNextLine()) {
                gr2 = fileScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл конфігурації був видален!");
        }
    }

    private static void saveStats(String winner, char symbol, LocalDateTime startTime) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STATS_FILE, true))) {
            String time = startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println(time + ";" + rozmir_doski + "x" + rozmir_doski + ";" + 
                           gr1 + " проти " + gr2 + ";" + 
                           (symbol != ' ' ? symbol + ":" + winner : winner));
        } catch (IOException e) {
            System.out.println("Помилка збереження статистики: " + e.getMessage());
        }
    }

    private static void showStats() {
        System.out.println("|--------Статистика--------|");
        System.out.println("| Дата       | Розмір | Гравці | Результат |");
        
        try (Scanner fileScanner = new Scanner(new File(STATS_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(";");
                if (parts.length >= 4) {
                    System.out.printf("| %s | %5s | %-15s | %-9s |\n", 
                                     parts[0], parts[1], parts[2], parts[3]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("| Немає даних про статистику |");
        }
        System.out.println("|---------------------------|");
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
}