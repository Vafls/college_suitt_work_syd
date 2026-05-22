import java.util.Scanner;

public class Main {

    public static void main(String[] argumenty) {

        Scanner vvodnyjSkaner = new Scanner(System.in);

        System.out.println("Фільтр системного журналу .log");

        System.out.print("Введіть шлях до вхідного файлу (.log): ");
        String vkhidnyjFajl = vvodnyjSkaner.nextLine().trim();

        System.out.print("Введіть шлях до вихідного файлу        : ");
        String vykhidnyjFajl = vvodnyjSkaner.nextLine().trim();

        LogLevel[] rivni = LogLevel.values();
        System.out.println("Оберіть рівень логування для фільтрації:");
        for (int indeks = 0; indeks < rivni.length; indeks++) {
            System.out.printf("  %d. %s%n", indeks + 1, rivni[indeks]);
        }

        int vybir = 0;
        while (vybir < 1 || vybir > rivni.length) {
            System.out.printf("Ваш вибір (1–%d): ", rivni.length);
            String vvid = vvodnyjSkaner.nextLine().trim();
            try {
                vybir = Integer.parseInt(vvid);
                if (vybir < 1 || vybir > rivni.length) {
                    System.out.println("Невірне число. Спробуйте ще раз.");
                }
            } catch (NumberFormatException pomylka) {
                System.out.println("Введіть число від 1 до " + rivni.length + ".");
            }
        }

        LogLevel obranyiRiven = rivni[vybir - 1];
        System.out.println("Вибрано: " + obranyiRiven);
        System.out.println();

        LogFilter filtr = new SevereLogFilter();
        filtr.filter(vkhidnyjFajl, vykhidnyjFajl, obranyiRiven);

        vvodnyjSkaner.close();
    }
}
