import java.util.Random;

public class task_n_two {
    public static void main(String[] args) {
        int rows = 4, cols = 5;
        Random random = new Random();
        double[][] array = new double[rows][cols];

        System.out.println("Оригiнальний масив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextDouble() * 10;
                System.out.printf("%.2f ", array[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nМасив з корнем:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 != 0 || j % 2 != 0) {
                    array[i][j] = Math.sqrt(array[i][j]);
                }
                System.out.printf("%.2f ", array[i][j]);
            }
            System.out.println();
        }
    }
}

// auth Сидорук Костянтин КБ-21
