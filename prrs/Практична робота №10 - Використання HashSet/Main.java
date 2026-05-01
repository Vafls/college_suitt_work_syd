import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRegistry registry = new UserRegistry();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Система логування подій на сайті");

        while (true) {
            System.out.println("--- МЕНЮ ---");
            System.out.println("1. Зареєструвати користувача");
            System.out.println("2. Увійти в систему (login)");
            System.out.println("3. Вийти з системи (logout)");
            System.out.println("4. Перевірити реєстрацію користувача");
            System.out.println("5. Видалити користувача");
            System.out.println("6. Кількість унікальних користувачів");
            System.out.println("7. Показати всіх користувачів");
            System.out.println("0. Вихід");
            System.out.print("Оберіть пункт: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("Введіть логін: ");
                    String regLogin = scanner.nextLine().trim();
                    System.out.print("Введіть пароль: ");
                    String regPass = scanner.nextLine().trim();
                    registry.registerUser(regLogin, regPass);
                    break;

                case "2":
                    System.out.print("Введіть логін: ");
                    String loginName = scanner.nextLine().trim();
                    System.out.print("Введіть пароль: ");
                    String loginPass = scanner.nextLine().trim();
                    registry.loginUser(loginName, loginPass);
                    break;

                case "3":
                    System.out.print("Введіть id користувача для виходу: ");
                    try {
                        int logoutId = Integer.parseInt(scanner.nextLine().trim());
                        registry.logoutUser(logoutId);
                    } catch (NumberFormatException e) {
                        System.out.println("Невірний формат id");
                    }
                    break;

                case "4":
                    System.out.print("Введіть логін для перевірки: ");
                    String checkLogin = scanner.nextLine().trim();
                    boolean registered = registry.isUserRegistered(checkLogin);
                    System.out.println("Користувач [" + checkLogin + "] "
                            + (registered ? "зареєстрований" : "не зареєстрований"));
                    break;

                case "5":
                    System.out.print("Введіть id користувача для видалення: ");
                    try {
                        int removeId = Integer.parseInt(scanner.nextLine().trim());
                        registry.removeUser(removeId);
                    } catch (NumberFormatException e) {
                        System.out.println("Невірний формат id");
                    }
                    break;

                case "6":
                    registry.printTotalUniqueUsers();
                    break;

                case "7":
                    registry.displayAllUsers();
                    break;

                case "0":
                    System.out.println("До побачення!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний пункт меню, спробуйте ще раз");
            }
        }
    }
}
