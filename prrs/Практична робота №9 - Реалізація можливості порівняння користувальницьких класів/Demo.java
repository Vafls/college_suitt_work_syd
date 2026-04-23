import java.util.Comparator;

public class Demo {

    public static void main(String[] args) {

        System.out.println("=== Тест 1: sort() — Integer за зростанням ===");
        try {
            MijVektor<Integer> intVektor = new MijVektor<>();
            intVektor.dodatyVKinez(42);
            intVektor.dodatyVKinez(7);
            intVektor.dodatyVKinez(15);
            intVektor.dodatyVKinez(3);
            intVektor.dodatyVKinez(99);
            System.out.println("До сортування:   " + intVektor);
            intVektor.sort();
            System.out.println("Після sort():    " + intVektor);
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 2: sort() — String за алфавітом ===");
        try {
            MijVektor<String> strVektor = new MijVektor<>();
            strVektor.dodatyVKinez("банан");
            strVektor.dodatyVKinez("абрикос");
            strVektor.dodatyVKinez("груша");
            strVektor.dodatyVKinez("вишня");
            System.out.println("До сортування:   " + strVektor);
            strVektor.sort();
            System.out.println("Після sort():    " + strVektor);
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 3: sort(Comparator) — Integer за спаданням ===");
        try {
            MijVektor<Integer> intVektor2 = new MijVektor<>();
            intVektor2.dodatyVKinez(42);
            intVektor2.dodatyVKinez(7);
            intVektor2.dodatyVKinez(15);
            intVektor2.dodatyVKinez(3);
            intVektor2.dodatyVKinez(99);
            System.out.println("До сортування:   " + intVektor2);
            intVektor2.sort((a, b) -> b - a);
            System.out.println("Після sort(↓):   " + intVektor2);
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 4: sort(Comparator) — String за довжиною ===");
        try {
            MijVektor<String> strVektor2 = new MijVektor<>();
            strVektor2.dodatyVKinez("ківі");
            strVektor2.dodatyVKinez("полуниця");
            strVektor2.dodatyVKinez("слива");
            strVektor2.dodatyVKinez("ананас");
            strVektor2.dodatyVKinez("fig");
            System.out.println("До сортування:         " + strVektor2);
            strVektor2.sort(Comparator.comparingInt(String::length));
            System.out.println("Після sort(довжина):   " + strVektor2);
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 5: Comparable — порівняння колекцій за розміром ===");
        try {
            MijVektor<Integer> malyjVektor = new MijVektor<>();
            malyjVektor.dodatyVKinez(1);
            malyjVektor.dodatyVKinez(2);

            MijVektor<Integer> velykyjVektor = new MijVektor<>();
            velykyjVektor.dodatyVKinez(10);
            velykyjVektor.dodatyVKinez(20);
            velykyjVektor.dodatyVKinez(30);
            velykyjVektor.dodatyVKinez(40);

            System.out.println("malyjVektor:   " + malyjVektor + " (rozmir=" + malyjVektor.rozmir() + ")");
            System.out.println("velykyjVektor: " + velykyjVektor + " (rozmir=" + velykyjVektor.rozmir() + ")");

            int rezultat = malyjVektor.compareTo(velykyjVektor);
            if (rezultat < 0) {
                System.out.println("Результат: malyjVektor МЕНШИЙ за velykyjVektor");
            } else if (rezultat > 0) {
                System.out.println("Результат: malyjVektor БІЛЬШИЙ за velykyjVektor");
            } else {
                System.out.println("Результат: колекції РІВНІ за розміром");
            }
        } catch (NedopustymeZnachennyaVynatok e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 6: Виключення — sort на порожньому векторі ===");
        try {
            MijVektor<Integer> porozhnij = new MijVektor<>();
            porozhnij.sort();
            System.out.println("sort() на порожньому векторі пройшов без помилок: " + porozhnij);
            porozhnij.otrymaty(0);
        } catch (PorozhnijVektorVynatok e) {
            System.out.println("Перехоплено: " + e.getMessage());
        }
    }
}
