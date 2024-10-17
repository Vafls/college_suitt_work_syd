import java.util.Scanner;

public class second_task {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Введiть значение a: ");
        double a = scn.nextDouble();
        
        System.out.print("Введiть значение b: ");
        double b = scn.nextDouble();

        double[] xValues = {-8, 3, Double.POSITIVE_INFINITY};

        for (double x : xValues) {
            double f;

            if (x == -8) {
                f = Math.sqrt(a * x - 3);
                System.out.println("f(-8) = " + f);
            } else if (x == 3) {
                f = Math.abs(Math.pow(x, 2) - b * x + 7);
                System.out.println("f(3) = " + f);
            } else {
                f = Math.cos(x + 1);
                System.out.println("f(+∞) = " + f);
            }
        }
        
        scn.close();
    }
}

// auth: Сидорук Костянтин КБ-21