import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        UserRegistry registry = new UserRegistry();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Система логування подій на сайті ===");

        System.out.print("Відновити базу користувачів із файлу? (так/ні): ");
        String restoreAnswer = scanner.nextLine().trim().toLowerCase();
        if (restoreAnswer.equals("так") || restoreAnswer.equals("т")
                || restoreAnswer.equals("yes") || restoreAnswer.equals("y")) {
            System.out.print("Введіть шлях до файлу з даними: ");
            String restorePath = scanner.nextLine().trim();
            registry.loadFromFile(restorePath);
        }

        while (true) {
            System.out.println("--- МЕНЮ ---");
            System.out.println("1.  Зареєструвати користувача");
            System.out.println("2.  Увійти в систему (login)");
            System.out.println("3.  Вийти з системи (logout)");
            System.out.println("4.  Перевірити реєстрацію");
            System.out.println("5.  Видалити користувача");
            System.out.println("6.  Кількість унікальних користувачів");
            System.out.println("7.  Показати всіх користувачів");
            System.out.println("8.  getUserList — список за іменем");
            System.out.println("9.  getInOrder — список за id (зворотній порядок)");
            System.out.println("10. getFiltered — лише залогінені користувачі");
            System.out.println("0.  Вихід");
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

                case "8":
                    LinkedList<User> byName = registry.getUserList();
                    System.out.println("--- getUserList (за іменем) ---");
                    byName.forEach(System.out::println);
                    System.out.println("-------------------------------");
                    break;

                case "9":
                    Comparator<User> byIdDesc = (u1, u2) ->
                            u2.getIdentifier().getId() - u1.getIdentifier().getId();
                    LinkedList<User> ordered = registry.getInOrder(byIdDesc);
                    System.out.println("--- getInOrder (id за спаданням) ---");
                    ordered.forEach(System.out::println);
                    System.out.println("------------------------------------");
                    break;

                case "10":
                    Predicate<User> onlyLoggedIn = User::isLoggedIn;
                    LinkedList<User> filtered = registry.getFiltered(onlyLoggedIn);
                    System.out.println("--- getFiltered (залогінені) ---");
                    if (filtered.isEmpty()) {
                        System.out.println("Немає залогінених користувачів");
                    } else {
                        filtered.forEach(System.out::println);
                    }
                    System.out.println("--------------------------------");
                    break;

                case "0":
                    System.out.print("Зберегти базу користувачів у файл? (так/ні): ");
                    String saveAnswer = scanner.nextLine().trim().toLowerCase();
                    if (saveAnswer.equals("так") || saveAnswer.equals("т")
                            || saveAnswer.equals("yes") || saveAnswer.equals("y")) {
                        System.out.print("Введіть шлях для збереження файлу: ");
                        String savePath = scanner.nextLine().trim();
                        registry.saveToFile(savePath);
                    }
                    System.out.println("До побачення!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний пункт меню, спробуйте ще раз");
            }
        }
    }
}
