package Projects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyDiary {
    private static final int MAKS_ZAPYSIV = 50;
    private final String[] daty = new String[MAKS_ZAPYSIV];
    private final String[] zapysy = new String[MAKS_ZAPYSIV];
    private int kilkistZapysiv = 0;

    private final Scanner vvid;
    private SimpleDateFormat formatVidobrazhennyaDaty = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private final SimpleDateFormat formatFailuDaty = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public MyDiary(Scanner scanner) {
        this.vvid = scanner;
    }

    public void vibratyFormatDaty() {
        System.out.println("\nОберіть формат дати:");
        System.out.println("1. дд.мм.рррр ГГ:хх");
        System.out.println("2. мм/дд/рррр гг:мм a");
        System.out.println("3. рррр-мм-дд гг:хх:сс");
        System.out.println("4. Ввести свій формат");
        System.out.print("Ваш вибір: ");
        String vybirFormatu = vvid.nextLine();

        try {
            switch (vybirFormatu) {
                case "1" -> formatVidobrazhennyaDaty = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                case "2" -> formatVidobrazhennyaDaty = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                case "3" -> formatVidobrazhennyaDaty = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                case "4" -> {
                    System.out.print("Введіть свій формат (наприклад, dd/MM/yyyy HH:mm): ");
                    String vlasnyFormat = vvid.nextLine();
                    formatVidobrazhennyaDaty = new SimpleDateFormat(vlasnyFormat);
                }
                default -> System.out.println("Невірний вибір, використовується формат за замовчуванням.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Невірний формат! Використовується формат за замовчуванням.");
            formatVidobrazhennyaDaty = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        }
    }

    public void dodatyZapys() {
        if (kilkistZapysiv >= MAKS_ZAPYSIV) {
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

    private String otrymatyKorektnuDatu() {
        while (true) {
            System.out.print("Введіть дату та час (у вибраному форматі): ");
            String vvedenaData = vvid.nextLine();
            try {
                Date dataObiekta = formatVidobrazhennyaDaty.parse(vvedenaData);
                return formatFailuDaty.format(dataObiekta);
            } catch (ParseException e) {
                System.out.println("Некоректна дата або час! Спробуйте ще раз.");
            }
        }
    }

    private String zbyrayTekst() {
        StringBuilder tekst = new StringBuilder();
        while (true) {
            String ryadok = vvid.nextLine();
            if (ryadok.isEmpty()) {
                if (tekst.isEmpty()) {
                    System.out.println("Запис не може бути порожнім!");
                    continue;
                }
                break;
            }
            if (!tekst.isEmpty()) tekst.append("\n");
            tekst.append(ryadok);
        }
        return tekst.toString();
    }

    public void vydalytyZaDatoiu() {
        System.out.print("Введіть дату для видалення (у вибраному форматі): ");
        String vvedenaData = vvid.nextLine();
        int kilkistVydalenykh = 0;

        try {
            Date dataDlyaVydalennya = formatVidobrazhennyaDaty.parse(vvedenaData);
            String dataDlyaFailu = formatFailuDaty.format(dataDlyaVydalennya);

            for (int i = 0; i < kilkistZapysiv; i++) {
                if (daty[i].equals(dataDlyaFailu)) {
                    for (int j = i; j < kilkistZapysiv - 1; j++) {
                        daty[j] = daty[j + 1];
                        zapysy[j] = zapysy[j + 1];
                    }
                    kilkistZapysiv--;
                    i--;
                    kilkistVydalenykh++;
                }
            }
        } catch (ParseException e) {
            System.out.println("Некоректна дата!");
            return;
        }

        System.out.println(kilkistVydalenykh > 0 ? "Видалено записів: " + kilkistVydalenykh : "Записів не знайдено");
    }

    public void pokazatyVsiZapysy() {
        if (kilkistZapysiv == 0) {
            System.out.println("Щоденник порожній!");
            return;
        }

        System.out.println("\nВсі записи:");
        for (int i = 0; i < kilkistZapysiv; i++) {
            try {
                Date dataObiekta = formatFailuDaty.parse(daty[i]);
                String formatovanaData = formatVidobrazhennyaDaty.format(dataObiekta);
                System.out.println("Дата: " + formatovanaData);
                System.out.println("Запис:\n" + zapysy[i]);
                System.out.println("-------------------");
            } catch (ParseException e) {
                System.out.println("Помилка форматування дати для запису #" + (i + 1));
            }
        }
    }

    public int getKilkistZapysiv() {
        return kilkistZapysiv;
    }

    public String getData(int i) {
        return daty[i];
    }

    public String getZapys(int i) {
        return zapysy[i];
    }

    public void dodatyZFaylu(String data, String tekst) {
        if (kilkistZapysiv < MAKS_ZAPYSIV) {
            daty[kilkistZapysiv] = data;
            zapysy[kilkistZapysiv] = tekst;
            kilkistZapysiv++;
        }
    }
}
