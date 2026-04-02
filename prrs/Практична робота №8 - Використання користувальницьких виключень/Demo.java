public class Demo {

    public static void main(String[] args) {

        System.out.println("=== Тест 1: Неприпустима початкова місткість ===");
        try {
            MijVektor poganyjVektor = new MijVektor(-5);
        } catch (NevirnaPochtkovaRozmirnistVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 2: Нормальна робота ===");
        MijVektor v = null;
        try {
            v = new MijVektor(4);
            v.dodatyVKinez(10);
            v.dodatyVKinez(20);
            v.dodatyVKinez(30);
            v.dodatyVPochatok(5);
            v.dodatyZaIndeksom(2, 15);
            System.out.println("Після додавань: " + v);
            System.out.println("rozmir = " + v.rozmir() + ", mistkist = " + v.mistkist());
        } catch (NevirnaPochtkovaRozmirnistVynatok | NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 3: Недопустиме значення (від'ємне число) ===");
        try {
            v.dodatyVKinez(-99);
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 4: Неправильний індекс ===");
        try {
            int element = v.otrymaty(100);
        } catch (NevirnyiIndeksVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
            System.out.println("Запитуваний індекс: " + e.otrymatyIndeks() + ", розмір: " + e.otrymatyRozmir());
        }

        System.out.println("\n=== Тест 5: Операція над порожнім вектором ===");
        try {
            MijVektor porozhnij = new MijVektor();
            porozhnij.otrymaty(0);
        } catch (PorozhnijVektorVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 6: Перевищення максимального розміру ===");
        try {
            MijVektor velykyjVektor = new MijVektor(998);
            for (int i = 0; i < 1005; i++) {
                velykyjVektor.dodatyVKinez(i);
            }
        } catch (NevirnaPochtkovaRozmirnistVynatok | NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (MaksymalnaRozmirnistVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }

        System.out.println("\n=== Тест 7: Видалення та очищення ===");
        v.vyluchytyZaIndeksom(1);
        System.out.println("Після vyluchytyZaIndeksom(1): " + v);
        v.ochystyty();
        System.out.println("Після ochystyty(): " + v);
        System.out.println("rozmir = " + v.rozmir() + ", mistkist = " + v.mistkist());
    }
}
