import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner vvedenyjVibir = new Scanner(System.in);
        boolean prazye = true;

        while (prazye) {
            vyvestyMenu();
            int diya = otrumatyVibirKorystuvacha(vvedenyjVibir);

            switch (diya) {
                case 1:
                    vykonatyZapys(vvedenyjVibir);
                    break;
                case 2:
                    vykonatyChytannya(vvedenyjVibir);
                    break;
                case 3:
                    prazye = false;
                    System.out.println("Вихiд");
                    break;
                default:
                    System.out.println("Невiрний вибiр");
            }
        }
        vvedenyjVibir.close();
    }

    private static void vyvestyMenu() {
        System.out.println("Виберiть операцiю:\n");
        System.out.println("1. Дописати до файлу");
        System.out.println("2. Вивести вмiст файлу");
        System.out.println("3. Вихi");
        System.out.print("Введiть цифру: ");
    }

    private static int otrumatyVibirKorystuvacha(Scanner skaner) {
        while (!skaner.hasNextInt()) {
            System.out.println("Потрiбно ввести число");
            skaner.next();
        }
        return skaner.nextInt();
    }

    private static void vykonatyZapys(Scanner skaner) {
        skaner.nextLine();
        System.out.print("Введiть шлях до файлу: ");
        String shlyahFajlu = skaner.nextLine();

        System.out.print("Оберiть дiю (1 - перезаписати файл, 2 - дописати): ");
        int rezhym = skaner.nextInt();
        skaner.nextLine();

        try (FileWriter fajlovyjPysar = new FileWriter(shlyahFajlu, rezhym == 2)) {
            System.out.println("Введiть строку. Нажмiть enter пiсля кожного рядка. Введiть '!!!' для зупинки.");
            while (true) {
                String ryadok = skaner.nextLine();
                if (ryadok.equals("!!!")) break;
                fajlovyjPysar.write(ryadok + "\n");
            }
            System.out.println("Данi збережно.");
        } catch (IOException pomylka) {
            System.out.println("Виникла помикла пiд час запису: " + pomylka.getMessage());
        }
    }

    private static void vykonatyChytannya(Scanner skaner) {
        skaner.nextLine();
        System.out.print("Введiть шлях до файлу: ");
        String shlyahFajlu = skaner.nextLine();

        try (BufferedReader fajlovyjChytach = new BufferedReader(new FileReader(shlyahFajlu))) {
            System.out.println("Змiст файл:  '" + shlyahFajlu + "':");
            String ryadok;
            while ((ryadok = fajlovyjChytach.readLine()) != null) {
                System.out.println(ryadok);
            }
        } catch (FileNotFoundException pomylka) {
            System.out.println("Файл не знайден: " + pomylka.getMessage());
        } catch (IOException pomylka) {
            System.out.println("Помилка зчитання файлу: " + pomylka.getMessage());
        }
    }
}