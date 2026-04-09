public class Demo {

    public static void main(String[] args) {

        System.out.println("=== Тест 1: Неприпустима початкова місткість ===");
        try {
            MijVektor<Integer> poganyjVektor = new MijVektor<>(-5);
        } catch (NevirnaPochtkovaRozmirnistVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 2: MijVektor<Integer> — нормальна робота ===");
        MijVektor<Integer> intVektor = null;
        try {
            intVektor = new MijVektor<>(4);
            intVektor.dodatyVKinez(10);
            intVektor.dodatyVKinez(20);
            intVektor.dodatyVKinez(30);
            intVektor.dodatyVPochatok(5);
            intVektor.dodatyZaIndeksom(2, 15);
            System.out.println("Після додавань: " + intVektor);
            System.out.println("rozmir = " + intVektor.rozmir() + ", mistkist = " + intVektor.mistkist());
        } catch (NevirnaPochtkovaRozmirnistVynatok | NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 3: MijVektor<String> — рядковий вектор ===");
        try {
            MijVektor<String> strVektor = new MijVektor<>();
            strVektor.dodatyVKinez("яблуко");
            strVektor.dodatyVKinez("банан");
            strVektor.dodatyVKinez("вишня");
            strVektor.dodatyVPochatok("абрикос");
            strVektor.dodatyZaIndeksom(2, "груша");
            System.out.println("Рядковий вектор: " + strVektor);
            System.out.println("otrymaty(2) = " + strVektor.otrymaty(2));
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 4: Недопустиме значення (null) ===");
        try {
            intVektor.dodatyVKinez(null);
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 5: Неправильний індекс ===");
        try {
            intVektor.otrymaty(100);
        } catch (NevirnyiIndeksVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
            System.out.println("Запитуваний індекс: " + e.otrymatyIndeks() + ", розмір: " + e.otrymatyRozmir());
        }

        System.out.println("\n=== Тест 6: Операція над порожнім вектором ===");
        try {
            MijVektor<String> porozhnij = new MijVektor<>();
            porozhnij.otrymaty(0);
        } catch (PorozhnijVektorVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 7: Перевищення максимального розміру ===");
        try {
            MijVektor<Integer> velykyjVektor = new MijVektor<>(998);
            for (int i = 0; i < 1005; i++) {
                velykyjVektor.dodatyVKinez(i);
            }
        } catch (NevirnaPochtkovaRozmirnistVynatok | NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (MaksymalnaRozmirnistVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 8: Видалення та очищення ===");
        intVektor.vyluchytyZaIndeksom(1);
        System.out.println("Після vyluchytyZaIndeksom(1): " + intVektor);
        intVektor.ochystyty();
        System.out.println("Після ochystyty(): " + intVektor);
        System.out.println("rozmir = " + intVektor.rozmir() + ", mistkist = " + intVektor.mistkist());
    }
}
