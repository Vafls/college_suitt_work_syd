public class NevirnaPochtkovaRozmirnistVynatok extends Exception {
    public NevirnaPochtkovaRozmirnistVynatok(int mistkist) {
        super("Неприпустима початкова місткість: " + mistkist + ". Значення має бути більше 0");
    }
}
