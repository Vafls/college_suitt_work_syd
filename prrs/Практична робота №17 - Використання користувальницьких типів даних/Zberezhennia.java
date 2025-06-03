import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.Scanner;

public class Zberezhennia {
    private static final String nazvaFaylu = "stats.txt";

    public static void zberehtyStatystyku(Statystyka stat) {
        try (PrintWriter zapis = new PrintWriter(new FileWriter(nazvaFaylu, true))) {
            String chasStr = stat.pochatoK.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String rezultat = (stat.znakPeremozhtsya != ' ')
                ? stat.znakPeremozhtsya + ":" + stat.imyaPeremozhtsya
                : stat.imyaPeremozhtsya;

            zapis.println(chasStr + ";" +
                          stat.rozmirPolya + "x" + stat.rozmirPolya + ";" +
                          stat.imGrav1 + " проти " + stat.imGrav2 + ";" +
                          rezultat);
        } catch (IOException e) {
            System.out.println("Не вдалося зберегти статистику.");
        }
    }

    public static void pokazatyStatystyku() {
        System.out.println("|--------СТАТИСТИКА--------|");
        System.out.println("| ДАТА       | РОЗМIР | ГРАВЦI           | РЕЗУЛЬТАТ   |");

        try (Scanner fSkan = new Scanner(new File(nazvaFaylu))) {
            while (fSkan.hasNextLine()) {
                String[] chasti = fSkan.nextLine().split(";");
                if (chasti.length >= 4) {
                    System.out.printf("| %s | %5s | %-15s | %-11s |\n", chasti[0], chasti[1], chasti[2], chasti[3]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайден.");
        }

        System.out.println("|---------------------------|");
    }
}
