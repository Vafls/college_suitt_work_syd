import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    private static final int MAX_ZAPYSIV = 50;
    private static String[] daty = new String[MAX_ZAPYSIV];
    private static String[] zapysy = new String[MAX_ZAPYSIV];
    private static int kilkistZapysiv = 0;
    private static Scanner vvid = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nМій щоденник");
            System.out.println("1. Додати запис");
            System.out.println("2. Видалити записи за датою");
            System.out.println("3. Переглянути всі записи");
            System.out.println("4. Вийти");
            System.out.print("Оберіть дію: ");
            String vybir = vvid.nextLine();

            switch (vybir) {
                case "1":
                    dodatyZapys();
                    break;
                case "2":
                    vydalytyZaDatoiu();
                    break;
                case "3":
                    pokazatyVsiZapysy();
                    break;
                case "4":
                    vvid.close();
                    return;
                default:
                    System.out.println("Невірний вибір!");
            }
        }
    }

    private static void dodatyZapys() {
        if (kilkistZapysiv >= MAX_ZAPYSIV) {
            System.out.println("Щоденник заповнений!");
            return;
        }

        String data = otrymatyKorektnuDatu();
        if (data == null) return;

        System.out.println("Введіть текст запису (пустий рядок для завершення):");
        String tekst = zbyrayTekst();

        daty[kilkistZapysiv] = data;
        zapysy[kilkistZapysiv] = tekst;
        kilkistZapysiv++;
        System.out.println("Запис додано успішно!");
    }

    private static String otrymatyKorektnuDatu() {
        while (true) {
            System.out.print("Введіть дату (дд.мм.рррр): ");
            String data = vvid.nextLine();
            if (chyDataKorektna(data)) {
                return data;
            }
            System.out.println("Некоректна дата! Спробуйте ще раз.");
        }
    }

    private static boolean chyDataKorektna(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static String zbyrayTekst() {
        String tekst = "";
        while (true) {
            String ryadok = vvid.nextLine();
            if (ryadok.isEmpty()) {
                if (tekst.isEmpty()) {
                    System.out.println("Запис не може бути порожнім!");
                    continue;
                }
                break;
            }
            tekst += (tekst.isEmpty() ? "" : "\n") + ryadok;
        }
        return tekst;
    }

    private static void vydalytyZaDatoiu() {
        String data = otrymatyKorektnuDatu();
        int vydaleno = 0;

        for (int i = 0; i < kilkistZapysiv; i++) {
            if (daty[i].equals(data)) {
                for (int j = i; j < kilkistZapysiv - 1; j++) {
                    daty[j] = daty[j + 1];
                    zapysy[j] = zapysy[j + 1];
                }
                kilkistZapysiv--;
                i--;
                vydaleno++;
            }
        }

        System.out.println(vydaleno > 0 ? "Видалено записів: " + vydaleno : "Записив не знайдено");
    }

    private static void pokazatyVsiZapysy() {
        if (kilkistZapysiv == 0) {
            System.out.println("Щоденник порожній!");
            return;
        }

        System.out.println("\nВсі записи:");
        for (int i = 0; i < kilkistZapysiv; i++) {
            System.out.println("Дата: " + daty[i]);
            System.out.println("Запис:\n" + zapysy[i].replace("\n", "\n"));
            System.out.println("-------------------");
        }
    }
}