import java.util.Scanner;

public class Main {
    static class invNickIsk extends Exception {
        public invNickIsk(String msg) {
            super(msg);
        }
    }

    static class invPassIsk extends Exception {
        public invPassIsk(String msg) {
            super(msg);
        }
    }

    String imya;
    String parol;

    Main(String imya, String parol) {
        this.imya = imya;
        this.parol = parol;
    }

    private static void validateUsername(String nick_u) throws invNickIsk {
        if (nick_u.length() < 5) {
            throw new invNickIsk("Ім'я повинно містити принаймні 5 символів");
        }
        if (nick_u.contains(" ")) {
            throw new invNickIsk("Ім'я не повинно містити пробілів");
        }
    }

    private static void validatePassword(String password) throws invPassIsk {
        if (password.length() < 10) {
            throw new invPassIsk("Пароль повинен бути не менше 10 символів");
        }
        if (password.contains(" ")) {
            throw new invPassIsk("Пароль не повинен містити пробілів");
        }

        int dc = 0;
        boolean specSym = false;
        String[] zapret = {"admin", "pass", "password", "qwerty", "ytrewq", "123456", "654321", "111111", "222222",
            "333333", "444444", "555555", "666666", "777777", "888888", "999999", "000000", "123123", "321321",
            "123321", "321123", "123654", "654123", "qazwsx", "wsxzaq"};
        String notCaps = password.toLowerCase();

        for (String slovo : zapret) {
            if (notCaps.contains(slovo)) {
                throw new invPassIsk("Пароль містить заборонене слово/комбiнацiю цифр: " + slovo);
            }
        }

        for (char c : password.toCharArray()) {
            if (!PassPrav(c)) {
                throw new invPassIsk("Пароль маэ недопустимі символи");
            }
            if (Character.isDigit(c)) {
                dc++;
            }
            if (!Character.isLetterOrDigit(c)) {
                specSym = true;
            }
        }

        if (dc < 3) {
            throw new invPassIsk("Пароль повинен містити принаймні 3 цифри");
        }
        if (!specSym) {
            throw new invPassIsk("Пароль повинен містити принаймні один спецсимвол");
        }
    }

    private static boolean PassPrav(char c) {
        return c >= 33 && c <= 126;
    }

    public static void main(String[] args) {
        final int maks_ludey = 15;
        Main[] ludu = new Main[maks_ludey];
        int kilkist_ludey = 0;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Меню:");
            System.out.println("-----------------------------");
            System.out.println("1 Додати користувача");
            System.out.println("-----------------------------");
            System.out.println("2 Видалити користувача");
            System.out.println("-----------------------------");
            System.out.println("3 Автентифікувати користувача");
            System.out.println("-----------------------------");
            System.out.println("4 Вийти");
            System.out.println("-----------------------------");
            System.out.print("Ваш вибір: ");

            int vibir = 0;
            try {
                vibir = Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Помилка: Неправильний ввід!");
                continue;
            }

            if (vibir == 1) {
                if (kilkist_ludey >= maks_ludey) {
                    System.out.println("Помилка: Досягнуто максимальну кількість користувачів.");
                } else {
                    try {
                        System.out.print("Введіть ім'я користувача: ");
                        String imya = scn.nextLine();
                        validateUsername(imya);

                        for (int i = 0; i < kilkist_ludey; i++) {
                            if (ludu[i].imya.equals(imya)) {
                                throw new invNickIsk("Користувач з таким іменем вже існує");
                            }
                        }

                        System.out.print("Введіть пароль: ");
                        String parol = scn.nextLine();
                        validatePassword(parol);

                        ludu[kilkist_ludey] = new Main(imya, parol);
                        kilkist_ludey++;
                        System.out.println("Користувача успішно зареєстровано!");
                    } catch (invNickIsk | invPassIsk e) {
                        System.out.println("Помилка: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Помилка додавання користувача: " + e.getMessage());
                    }
                }
            } else if (vibir == 2) {
                try {
                    System.out.print("Введіть ім'я користувача для видалення: ");
                    String imya = scn.nextLine();
                    boolean znajdeno = false;
                    for (int i = 0; i < kilkist_ludey; i++) {
                        if (ludu[i] != null && ludu[i].imya.equals(imya)) {
                            ludu[i] = ludu[kilkist_ludey - 1];
                            ludu[kilkist_ludey - 1] = null;
                            kilkist_ludey--;
                            System.out.println("Користувача видалено.");
                            znajdeno = true;
                            break;
                        }
                    }
                    if (!znajdeno) {
                        System.out.println("Помилка: Користувача не знайдено.");
                    }
                } catch (Exception e) {
                    System.out.println("Помилка видалення користувача: " + e.getMessage());
                }
            } else if (vibir == 3) {
                try {
                    System.out.print("Введіть ім'я користувача: ");
                    String imya = scn.nextLine();
                    System.out.print("Введіть пароль: ");
                    String parol = scn.nextLine();
                    boolean avtentifikovano = false;
                    for (int i = 0; i < kilkist_ludey; i++) {
                        if (ludu[i] != null && ludu[i].imya.equals(imya) && ludu[i].parol.equals(parol)) {
                            System.out.println("Автентифікація успішна! Виконання дії від імені користувача.");
                            avtentifikovano = true;
                            break;
                        }
                    }
                    if (!avtentifikovano) {
                        System.out.println("Помилка: Невірне ім'я користувача або пароль.");
                    }
                } catch (Exception e) {
                    System.out.println("Помилка під час автентифікації: " + e.getMessage());
                }
            } else if (vibir == 4) {
                System.out.println("Вихід...");
                break;
            } else {
                System.out.println("Невірний вибір!");
            }
        }
        scn.close();
    }
}