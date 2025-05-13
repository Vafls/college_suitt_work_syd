package Projects;

import Projects.utils.FileUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner vvid = new Scanner(System.in);
        MyDiary diary = new MyDiary(vvid);

        System.out.println("Відновити щоденник з файлу? (yes/no)");
        String vybir = vvid.nextLine();

        if (vybir.equalsIgnoreCase("yes")) {
            System.out.print("Введіть шлях до файлу: ");
            String shlyahDoFailu = vvid.nextLine();
            FileUtils.zavantazhytyZFailu(diary, shlyahDoFailu);
        } else {
            System.out.println("Створено новий щоденник.");
            diary.vibratyFormatDaty();
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
                case "1" -> diary.dodatyZapys();
                case "2" -> diary.vydalytyZaDatoiu();
                case "3" -> diary.pokazatyVsiZapysy();
                case "4" -> diary.vibratyFormatDaty();
                case "5" -> {
                    FileUtils.zberegtyDoFailu(diary, vvid);
                    vvid.close();
                    return;
                }
                default -> System.out.println("Невірний вибір!");
            }
        }
    }
}
