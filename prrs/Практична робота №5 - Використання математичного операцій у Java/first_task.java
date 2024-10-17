public class first_task {
    public static void main(String[] args) {

        double a = 2.8;
        double b = 16.4;
        double c = -5.4;

        double x = b * Math.pow(Math.tan(c), 2) - 1 / Math.pow(Math.sin(c / a), 2);

        double y = a * Math.exp(-Math.sqrt(a)) * Math.cos((b * c) / a);

        System.out.println("Значення x: " + x);
        System.out.println("Значення y: " + y);
    }
}

// auth: Сидорук Костянтин КБ-21