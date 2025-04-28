import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final int MAKS_ZAPYSIV = 50;
    private static String[] daty = new String[MAKS_ZAPYSIV];
    private static String[] zapysy = new String[MAKS_ZAPYSIV];
    private static int kilkistZapysiv = 0;
    private static Scanner vvid = new Scanner(System.in);
    private static SimpleDateFormat formatVidobrazhennyaDaty = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private static SimpleDateFormat formatFailuDaty = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("Відновити щоденник з файлу? (yes/no)");
        String vybir = vvid.nextLine();
        
        if (vybir.equalsIgnoreCase("yes")) {
            System.out.print("Введіть шлях до файлу: ");
            String shlyahDoFailu = vvid.nextLine();
            zavantazhytyZFailu(shlyahDoFailu);
        } else {
            System.out.println("Створено новий щоденник.");
            vibratyFormatDaty();
        }

        while (true) {
            System.out.println("\nМій щоденник");
            System.out.println("1. Додати запис");
            System.out.println("2. Видалити записи за датою");
            System.out.println("3. Переглянути всі записи");
            System.out.println("4. Змінити формат дати");
            System.out.println("5. Вийти");
            System.out.print("Оберіть дію: ");
            vybir = vvid.nextLine();

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
                    vibratyFormatDaty();
                    break;
                case "5":
                    zberegtyDoFailu();
                    vvid.close();
                    return;
                default:
                    System.out.println("Невірний вибір!");
            }
        }
    }

    private static void vibratyFormatDaty() {
        System.out.println("\nОберіть формат дати:");
        System.out.println("1. дд.мм.рррр ГГ:хх");
        System.out.println("2. мм/дд/рррр гг:мм a");
        System.out.println("3. рррр-мм-дд гг:хх:сс");
        System.out.println("4. Ввести свій формат");
        System.out.print("Ваш вибір: ");
        String vybirFormatu = vvid.nextLine();
        
        try {
            switch (vybirFormatu) {
                case "1":
                    formatVidobrazhennyaDaty = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    break;
                case "2":
                    formatVidobrazhennyaDaty = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                    break;
                case "3":
                    formatVidobrazhennyaDaty = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    break;
                case "4":
                    System.out.print("Введіть свій формат (наприклад, dd/MM/yyyy HH:mm): ");
                    String vlasnyFormat = vvid.nextLine();
                    formatVidobrazhennyaDaty = new SimpleDateFormat(vlasnyFormat);
                    break;
                default:
                    System.out.println("Невірний вибір, використовується формат за замовчуванням.");
            }
        } catch (IllegalArgumentException vyklyuchennya) {
            System.out.println("Невірний формат! Використовується формат за замовчуванням.");
            formatVidobrazhennyaDaty = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        }
    }

    private static void dodatyZapys() {
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

    private static String otrymatyKorektnuDatu() {
        while (true) {
            System.out.print("Введіть дату та час (у вибраному форматі): ");
            String vvedenaData = vvid.nextLine();
            try {
                Date dataObiekta = formatVidobrazhennyaDaty.parse(vvedenaData);
                return formatFailuDaty.format(dataObiekta);
            } catch (ParseException vyklyuchennya) {
                System.out.println("Некоректна дата або час! Спробуйте ще раз.");
            }
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
        } catch (ParseException vyklyuchennya) {
            System.out.println("Некоректна дата!");
            return;
        }

        System.out.println(kilkistVydalenykh > 0 ? "Видалено записів: " + kilkistVydalenykh : "Записів не знайдено");
    }

    private static void pokazatyVsiZapysy() {
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
                System.out.println("Запис:\n" + zapysy[i].replace("\n", "\n"));
                System.out.println("-------------------");
            } catch (ParseException vyklyuchennya) {
                System.out.println("Помилка форматування дати для запису #" + (i+1));
            }
        }
    }

    private static void zberegtyDoFailu() {
    System.out.print("Зберегти щоденник? (yes/no): ");
    String vybir = vvid.nextLine().trim();
    
    if (vybir.equalsIgnoreCase("yes")) {
        System.out.print("Введіть шлях до файлу: ");
        String shlyah = vvid.nextLine().trim();
        
        if (shlyah.isEmpty()) {
            System.out.println("Некоректний шлях!");
            return;
        }

        File fail = new File(shlyah);
        try {
            File dir = fail.getParentFile();
            if (dir != null && !dir.exists()) {
                dir.mkdirs();
            }
            
            try (PrintWriter pysalnyk = new PrintWriter(fail)) {
                for (int i = 0; i < kilkistZapysiv; i++) {
                    pysalnyk.println(daty[i]);
                    pysalnyk.println(zapysy[i]);
                    pysalnyk.println();
                }
                System.out.println("Успішно збережено у файл: " + fail.getAbsolutePath());
            }
        } catch (IOException | SecurityException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }
}

    private static void zavantazhytyZFailu(String shlyahDoFailu) {
        try (BufferedReader chytatel = new BufferedReader(new FileReader(shlyahDoFailu))) {
            String ryadok;
            while ((ryadok = chytatel.readLine()) != null && kilkistZapysiv < MAKS_ZAPYSIV) {
                if (ryadok.trim().isEmpty()) continue;
                
                String dataZFailu = ryadok;
                String tekstZapysu = "";
                while ((ryadok = chytatel.readLine()) != null && !ryadok.trim().isEmpty()) {
                    tekstZapysu += (tekstZapysu.isEmpty() ? "" : "\n") + ryadok;
                }
                
                daty[kilkistZapysiv] = dataZFailu;
                zapysy[kilkistZapysiv] = tekstZapysu;
                kilkistZapysiv++;
            }
            System.out.println("Щоденник завантажено успішно! Записів: " + kilkistZapysiv);
        } catch (IOException vyklyuchennya) {
            System.out.println("Помилка при завантаженні файлу: " + vyklyuchennya.getMessage());
        }
    }
}