import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                    vykonatyChytannyaDiapozon(vvedenyjVibir);
                    break;
                case 4:
                    vykonatyVstavku(vvedenyjVibir);
                    break;
                case 5:
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
        System.out.println("\nВиберiть операцiю:");
        System.out.println("1. Дописати до файлу");
        System.out.println("2. Вивести вмiст файлу");
        System.out.println("3. Вивести дiапазон рядкiв з файлу");
        System.out.println("4. Вставити текст у певний рядок");
        System.out.println("5. Вихiд");
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

        try (BufferedWriter fajlovyjPysar = new BufferedWriter(new FileWriter(shlyahFajlu, rezhym == 2))) {
            System.out.println("Введiть строку. Нажмiть enter пiсля кожного рядка. Введiть '!!!' для зупинки.");
            int nomerRyadka = 1;
            if (rezhym == 2) {
                try (BufferedReader lichylnyk = new BufferedReader(new FileReader(shlyahFajlu))) {
                    while (lichylnyk.readLine() != null) {
                        nomerRyadka++;
                    }
                } catch (IOException e) {
                    // Файл не існує, починаємо з 1
                }
            }

            while (true) {
                String ryadok = skaner.nextLine();
                if (ryadok.equals("!!!")) break;
                fajlovyjPysar.write(nomerRyadka + ". " + ryadok + "\n");
                nomerRyadka++;
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
            System.out.println("\nЗмiст файлу '" + shlyahFajlu + "':");
            String ryadok;
            while ((ryadok = fajlovyjChytach.readLine()) != null) {
                System.out.println(ryadok);
            }
        } catch (IOException pomylka) {
            System.out.println("Помилка зчитання файлу: " + pomylka.getMessage());
        }
    }

    private static void vykonatyChytannyaDiapozon(Scanner skaner) {
        skaner.nextLine();
        System.out.print("Введiть шлях до файлу: ");
        String shlyahFajlu = skaner.nextLine();

        System.out.print("Введiть початковий номер рядка: ");
        int pochatkovyj = skaner.nextInt();
        System.out.print("Введiть кiнцевий номер рядка: ");
        int kintsevyj = skaner.nextInt();

        try (BufferedReader fajlovyjChytach = new BufferedReader(new FileReader(shlyahFajlu))) {
            System.out.println("\nЗмiст файлу '" + shlyahFajlu + "' (рядки " + pochatkovyj + "-" + kintsevyj + "):");
            String ryadok;
            int potochnyjRyadok = 1;
            while ((ryadok = fajlovyjChytach.readLine()) != null) {
                if (potochnyjRyadok >= pochatkovyj && potochnyjRyadok <= kintsevyj) {
                    System.out.println(ryadok);
                }
                potochnyjRyadok++;
                if (potochnyjRyadok > kintsevyj) break;
            }
        } catch (IOException pomylka) {
            System.out.println("Помилка зчитання файлу: " + pomylka.getMessage());
        }
    }

    private static void vykonatyVstavku(Scanner skaner) {
        skaner.nextLine();
        System.out.print("Введiть шлях до файлу: ");
        String shlyahFajlu = skaner.nextLine();

        System.out.print("Введiть номер рядка для вставки: ");
        int ryadokDlyaVstavky = skaner.nextInt();
        skaner.nextLine();

        // Читаємо всі рядки у масив
        String[] vsiRyadky = new String[1000];
        int kilkistRyadkiv = 0;

        try (BufferedReader fajlovyjChytach = new BufferedReader(new FileReader(shlyahFajlu))) {
            String ryadok;
            while ((ryadok = fajlovyjChytach.readLine()) != null && kilkistRyadkiv < vsiRyadky.length) {
                vsiRyadky[kilkistRyadkiv++] = ryadok;
            }
        } catch (IOException pomylka) {
            System.out.println("Помилка зчитання файлу: " + pomylka.getMessage());
            return;
        }

        System.out.println("Введiть текст для вставки (кiлька рядкiв). Натиснiть enter пiсля кожного рядка. Введiть '!!!' для зупинки.");
        String[] noviRyadky = new String[100];
        int kilkistNovyhRyadkiv = 0;
        while (true) {
            String ryadok = skaner.nextLine();
            if (ryadok.equals("!!!")) break;
            if (kilkistNovyhRyadkiv < noviRyadky.length) {
                noviRyadky[kilkistNovyhRyadkiv++] = ryadok;
            }
        }

        // Перевіряємо коректність номеру рядка
        if (ryadokDlyaVstavky < 1 || ryadokDlyaVstavky > kilkistRyadkiv + 1) {
            System.out.println("Невiрний номер рядка");
            return;
        }

        // Створюємо новий масив з вставленими рядками
        String[] rezultat = new String[kilkistRyadkiv + kilkistNovyhRyadkiv];
        int indeksRezultatu = 0;

        // Копіюємо рядки до місця вставки
        for (int i = 0; i < ryadokDlyaVstavky - 1; i++) {
            rezultat[indeksRezultatu++] = vsiRyadky[i];
        }

        // Додаємо нові рядки з правильними номерами
        for (int i = 0; i < kilkistNovyhRyadkiv; i++) {
            rezultat[indeksRezultatu++] = (ryadokDlyaVstavky + i) + ". " + noviRyadky[i];
        }

        // Оновлюємо номери для решти рядків
        for (int i = ryadokDlyaVstavky - 1; i < kilkistRyadkiv; i++) {
            String staryjRyadok = vsiRyadky[i];
            // Витягуємо текст без номера рядка
            String tekst = staryjRyadok.substring(staryjRyadok.indexOf(". ") + 2);
            rezultat[indeksRezultatu++] = (ryadokDlyaVstavky + kilkistNovyhRyadkiv + (i - (ryadokDlyaVstavky - 1))) + ". " + tekst;
        }

        // Записуємо все назад у файл
        try (BufferedWriter fajlovyjPysar = new BufferedWriter(new FileWriter(shlyahFajlu))) {
            for (String ryadok : rezultat) {
                fajlovyjPysar.write(ryadok + "\n");
            }
            System.out.println("Данi успiшно вставлено.");
        } catch (IOException pomylka) {
            System.out.println("Помилка запису у файл: " + pomylka.getMessage());
        }
    }
}