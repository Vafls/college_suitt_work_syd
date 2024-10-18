import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class extra {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введiть кiлькiсть чисел: ");
        int count = scn.nextInt();

        System.out.print("Введiть мiнiмальне число дiапазона: ");
        int min = scn.nextInt();
        System.out.print("Введiть максимальне число дiапазона: ");
        int max = scn.nextInt();

        ArrayList<Double> array = new ArrayList<Double>();

        for (int i = 0; i < count; i++) {
            double randomNumber = min + (max - min) * random.nextDouble();
            array.add(randomNumber);
        }

        double sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        double averageArithmetic = sum / array.size();

        double product = 1;
        for (int i = 0; i < array.size(); i++) {
            product *= array.get(i);
        }
        double averageGeometric = Math.pow(product, 1.0 / array.size());

        System.out.println("Згенеровані числа: " + array);
        System.out.println("Середнє арифметичне: " + averageArithmetic);
        System.out.println("середнє геометричне: " + averageGeometric);
    }
}

// auth: Сидорук Костянтин КБ-21