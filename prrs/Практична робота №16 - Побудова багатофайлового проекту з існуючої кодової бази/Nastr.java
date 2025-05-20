import java.util.Scanner;
import java.io.*;

public class Nastr {
    public static String imGrav1 = "Gravets 1";
    public static String imGrav2 = "Gravets 2";
    public static int rozmirPolya = 3;
    private static final String nazvaConfig = "config.txt";

    public static void pokazatyNalashtuvannya(Scanner skan) {
        System.out.println("|-----Nalashtuvannya-----|");
        System.out.println("| 1. Розмiр поля         |");
        System.out.println("| 2. ім'я гравця X       |");
        System.out.println("| 3. ім'я гравця O       |");
        System.out.println("| 4. Зберегти            |");
        System.out.println("| 5. Назад               |");
        System.out.println("|------------------------|");
        System.out.print("Введiть цифру: ");

        if (skan.hasNextInt()) {
            int vibor = skan.nextInt();
            skan.nextLine();

            switch (vibor) {
                case 1:
                    rozmirPolya = zminytyRozmir(skan);
                    break;
                case 2:
                    System.out.print("Нове ім'я для X: ");
                    imGrav1 = skan.nextLine();
                    break;
                case 3:
                    System.out.print("Нове ім'я для O: ");
                    imGrav2 = skan.nextLine();
                    break;
                case 4:
                    zberehtyNastr();
                    System.out.println("Збережено.");
                    break;
            }
        } else {
            System.out.println("Необхiдно ввести цифру.");
            skan.next();
        }
    }

    private static int zminytyRozmir(Scanner skan) {
        System.out.print("Введiть Розмiр доски (непарне числo 3-9): ");
        if (skan.hasNextInt()) {
            int r = skan.nextInt();
            if (r >= 3 && r <= 9 && r % 2 == 1) return r;
        } else {
            skan.next();
        }
        System.out.println("Ви ввели некоректне число. Виставлен стандарт 3x3.");
        return 3;
    }

    public static void zavantazhytyNastr() {
        try (Scanner fSkan = new Scanner(new File(nazvaConfig))) {
            if (fSkan.hasNextInt()) {
                rozmirPolya = fSkan.nextInt();
                fSkan.nextLine();
            }
            if (fSkan.hasNextLine()) imGrav1 = fSkan.nextLine();
            if (fSkan.hasNextLine()) imGrav2 = fSkan.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Конфiг не знайден.");
        }
    }

    private static void zberehtyNastr() {
        try (PrintWriter zapysuvach = new PrintWriter(new FileWriter(nazvaConfig))) {
            zapysuvach.println(rozmirPolya);
            zapysuvach.println(imGrav1);
            zapysuvach.println(imGrav2);
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }
}
