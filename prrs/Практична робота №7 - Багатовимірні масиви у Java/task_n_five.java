
import java.util.Scanner;

public class task_n_five {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введiть розмiр матрицi:");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Введiть значення матрицi:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Оригiнальна матриця:");
        printMatrix(matrix, n);

        System.out.println("Транспонована матриця:");
        printMatrix(transpose(matrix, n), n);
    }

    public static int[][] transpose(int[][] matrix, int n) {
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//auth Сидорук Костянтин КБ-21
