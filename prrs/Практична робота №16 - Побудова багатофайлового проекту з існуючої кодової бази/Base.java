import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        Nastr.zavantazhytyNastr();

        while (true) {
            pokazatyMenyu();
            int vibor = otrymatyVibir(skan);

            switch (vibor) {
                case 1:
                    Gra.pochatuGrata(Nastr.imGrav1, Nastr.imGrav2, Nastr.rozmirPolya, skan);
                    break;
                case 2:
                    Nastr.pokazatyNalashtuvannya(skan);
                    break;
                case 3:
                    Zberezhennia.pokazatyStatystyku();
                    break;
                case 4:
                    System.out.println("Вихiд...");
                    return;
                default:
                    System.out.println("Виберiть правильне число.");
            }
        }
    }

    private static void pokazatyMenyu() {
        System.out.println("|--------МЕНЮ---------|");
        System.out.println("| 1. Грати            |");
        System.out.println("| 2. Налаштування     |");
        System.out.println("| 3. Статистика       |");
        System.out.println("| 4. Вихiд            |");
        System.out.println("|---------------------|");
        System.out.print("Введiть цифру: ");
    }

    private static int otrymatyVibir(Scanner skan) {
        if (skan.hasNextInt()) {
            return skan.nextInt();
        } else {
            skan.next();
            return -1;
        }
    }
}
