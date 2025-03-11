import java.util.Scanner;

public class Main {
    String imya; 
    String parol; 

    Main(String imya, String parol) {
        this.imya = imya;
        this.parol = parol;
    }

    public static void main(String[] args) {
        final int maks_ludey = 15; 
        Main[] ludu = new Main[maks_ludey];
        int kilkist_ludey = 0;
        Scanner scn = new Scanner(System.in); 

        while (true) {
            System.out.println("Меню:");
            System.out.println("1 Додати користувача");
            System.out.println("2 Видалити користувача");
            System.out.println("3 Автентифікувати користувача");
            System.out.println("4 Вийти");
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
                        System.out.print("Введіть пароль: ");
                        String parol = scn.nextLine();
                        ludu[kilkist_ludey] = new Main(imya, parol);
                        kilkist_ludey++;
                        System.out.println("Користувача успішно зареєстровано!");
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
                            System.out.println("Автентифікація успішна!");
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