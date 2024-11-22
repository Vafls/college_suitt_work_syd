
import java.util.Scanner;

public class task_n_one {
    public static void main(String[] args) {
        int[][] pyramid = {
            {1},
            {2, 3},
            {4, 5, 6},
            {7, 8, 9, 10}
        };

        System.out.println("Звичайний порядок:");
        for (int[] row : pyramid) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("\nЗворотнiй порядок:");
        for (int i = pyramid.length - 1; i >= 0; i--) {
            for (int j = pyramid[i].length - 1; j >= 0; j--) {
                System.out.print(pyramid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//auth Сидорук Костянтин КБ-21
