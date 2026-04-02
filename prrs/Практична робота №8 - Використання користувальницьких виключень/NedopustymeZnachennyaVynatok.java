public class NedopustymeZnachennyaVynatok extends Exception {
    public NedopustymeZnachennyaVynatok(int znachennia) {
        super("Недопустиме значення: " + znachennia + ". Вектор приймає лише невід'ємні числа (>= 0)");
    }
}
