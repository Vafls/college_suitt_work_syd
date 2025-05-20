import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.Scanner;

public class Zberezhennia {
    private static final String nazvaFaylu = "stats.txt";

    public static void zberehtyStatystyku(String peremozhets, char znak, LocalDateTime chas, int rozmir, String im1, String im2) {
        try (PrintWriter zapis = new PrintWriter(new FileWriter(nazvaFaylu, true))) {
            String chasStr = chas.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            zapis.println(chasStr + ";" + rozmir + "x" + rozmir + ";" + im1 + " проти " + im2 + ";" + 
                          (znak != ' ' ? znak + ":" + peremozhets : peremozhets));
        } catch (IOException e) {
            System.out.println("Не вдалося зберегти статистику.");
        }
    }

    public static void pokazatyStatystyku() {
        System.out.println("|--------СТАТИСТИКА--------|");
        System.out.println("| ДАТА       | РОЗМIР | ГРАВЦI | РЕЗУЛЬТАТ |");

        try (Scanner fSkan = new Scanner(new File(nazvaFaylu))) {
            while (fSkan.hasNextLine()) {
                String[] chasti = fSkan.nextLine().split(";");
                if (chasti.length >= 4) {
                    System.out.printf("| %s | %5s | %-15s | %-9s |\n", chasti[0], chasti[1], chasti[2], chasti[3]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайден.");
        }

        System.out.println("|---------------------------|");
    }
}
