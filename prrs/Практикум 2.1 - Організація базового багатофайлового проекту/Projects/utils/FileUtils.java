package Projects.utils;

import Projects.MyDiary;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    public static void zberegtyDoFailu(MyDiary diary, Scanner vvid) {
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
                    for (int i = 0; i < diary.getKilkistZapysiv(); i++) {
                        pysalnyk.println(diary.getData(i));
                        pysalnyk.println(diary.getZapys(i));
                        pysalnyk.println();
                    }
                    System.out.println("Успішно збережено у файл: " + fail.getAbsolutePath());
                }
            } catch (IOException | SecurityException e) {
                System.out.println("Помилка збереження: " + e.getMessage());
            }
        }
    }

    public static void zavantazhytyZFailu(MyDiary diary, String shlyahDoFailu) {
        try (BufferedReader chytatel = new BufferedReader(new FileReader(shlyahDoFailu))) {
            String ryadok;
            while ((ryadok = chytatel.readLine()) != null) {
                if (ryadok.trim().isEmpty()) continue;

                String dataZFailu = ryadok;
                StringBuilder tekstZapysu = new StringBuilder();
                while ((ryadok = chytatel.readLine()) != null && !ryadok.trim().isEmpty()) {
                    if (tekstZapysu.length() > 0) tekstZapysu.append("\n");
                    tekstZapysu.append(ryadok);
                }

                diary.dodatyZFaylu(dataZFailu, tekstZapysu.toString());
            }
            System.out.println("Щоденник завантажено успішно!");
        } catch (IOException vyklyuchennya) {
            System.out.println("Помилка при завантаженні файлу: " + vyklyuchennya.getMessage());
        }
    }
}
