import java.util.Scanner;

public class App {

    static final Scanner sc = new Scanner(System.in);

    static final String[] FIELD_NAMES = {
        "Ім'я", "Прізвище", "По батькові", "Телефон", "Email",
        "Місце роботи", "Місце навчання", "Вік", "Спеціальність",
        "Навички", "Про себе"
    };

    void run() {
        System.out.println("================================");
        System.out.println("   Електронне Портфоліо v1.6");
        System.out.println("================================");

        while (true) {
            System.out.println("==== ГОЛОВНЕ МЕНЮ ====");
            System.out.println("1. Реєстрація");
            System.out.println("2. Вхід");
            System.out.println("3. Переглянути всі портфоліо");
            System.out.println("0. Вийти");
            System.out.print("> ");

            switch (sc.nextLine().trim()) {
                case "1" -> register();
                case "2" -> loginMenu();
                case "3" -> viewAll();
                case "0" -> { System.out.println("До побачення!"); return; }
                default  -> System.out.println("Невідома команда.");
            }
        }
    }

    void register() {
        System.out.println("--Реєстрація--");
        System.out.print("Логін: ");    String username = sc.nextLine().trim();
        System.out.print("Пароль: ");   String password = sc.nextLine().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Логін і пароль не можуть бути порожніми.");
            return;
        }

        String response = DatabaseWorker.register(username, password);

        if (response.startsWith("ERROR")) {
            System.out.println("Помилка: " + response.split(":")[1]);
        } else {
            String id = response.split(";")[1];
            System.out.println("Зареєстровано! Ваш ID: " + id);
            System.out.println("Тепер увійдіть та заповніть профіль.");
        }
    }

    void loginMenu() {
        System.out.println("--Вхід--");
        System.out.print("Логін: ");  String username = sc.nextLine().trim();
        System.out.print("Пароль: "); String password = sc.nextLine().trim();

        String response = DatabaseWorker.login(username, password);

        if (response.startsWith("ERROR")) {
            System.out.println("Помилка: " + response.split(":")[1]);
            return;
        }

        int userId = Integer.parseInt(response.split(";")[1]);
        System.out.println("Вхід успішний! ID=" + userId);

        while (true) {
            System.out.println("==== МІЙ ПРОФІЛЬ ====");
            System.out.println("1. Переглянути мій профіль");
            System.out.println("2. Редагувати профіль");
            System.out.println("0. Вийти з акаунту");
            System.out.print("> ");

            switch (sc.nextLine().trim()) {
                case "1" -> viewProfile(userId);
                case "2" -> editProfile(userId);
                case "0" -> { System.out.println("Виходимо з акаунту."); return; }
                default  -> System.out.println("Невідома команда.");
            }
        }
    }

    void viewProfile(int userId) {
        String response = DatabaseWorker.getPortfolio(userId);

        if (response.equals("EMPTY")) {
            System.out.println("Профіль порожній.");
            return;
        }

        System.out.println("================================");
        System.out.println(" МІЙ ПРОФІЛЬ");
        System.out.println("================================");
        printPortfolioLine(response);
    }

    void editProfile(int userId) {
        String existing = DatabaseWorker.getPortfolio(userId);
        String[] current = existing.equals("EMPTY") ? new String[14] : existing.split(";", -1);

        System.out.println("-- Редагування профілю --");
        System.out.println("(Enter — залишити поточне значення)");

        String[] newFields = new String[11];

        for (int i = 0; i < FIELD_NAMES.length; i++) {
            String currentValue = (current.length > 3 + i && !current[3 + i].isEmpty())
                    ? current[3 + i] : "-";
            System.out.print(FIELD_NAMES[i] + " [" + currentValue + "]: ");
            newFields[i] = sc.nextLine().trim();
        }

        String response = DatabaseWorker.updatePortfolio(userId, newFields);

        if (response.equals("OK")) {
            System.out.println("Профіль збережено. Час редагування оновлено.");
        } else {
            System.out.println("Помилка: " + response.split(":")[1]);
        }
    }

    void viewAll() {
        String response = DatabaseWorker.getAllPortfolios();

        if (response.equals("EMPTY")) {
            System.out.println("База даних порожня.");
            return;
        }

        System.out.println("================================");
        System.out.println(" УСІ ПОРТФОЛІО");
        System.out.println("================================");

        for (String line : response.split("\n")) {
            printPortfolioLine(line);
            System.out.println("--------------------------------");
        }
    }

    void printPortfolioLine(String line) {
        String[] p = line.split(";", -1);

        String[] labels = {
            "ID", "Створено", "Редаговано", "Ім'я", "Прізвище", "По батькові",
            "Телефон", "Email", "Місце роботи", "Місце навчання",
            "Вік", "Спеціальність", "Навички", "Про себе"
        };

        for (int i = 0; i < labels.length; i++) {
            String value = (i < p.length && !p[i].isEmpty()) ? p[i] : "-";
            System.out.println("  " + labels[i] + ": " + value);
        }
    }
}
