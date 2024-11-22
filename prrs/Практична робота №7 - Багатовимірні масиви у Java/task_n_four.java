
import java.util.Scanner;

public class task_n_four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введiть розмiр матрицi:");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Введiть значення элементiв матрицi:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Введіть номер рядка та стовпця для обчислення мінора:");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;

        System.out.println("Мiнор: " + calculateMinor(matrix, row, col, n));
    }

    public static int calculateMinor(int[][] matrix, int row, int col, int n) {
        int[][] temp = new int[n - 1][n - 1];
        int i = 0, j = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r != row && c != col) {
                    temp[i][j++] = matrix[r][c];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
        return determinant(temp, n - 1);
    }

    public static int determinant(int[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }

        int det = 0;
        int[][] temp = new int[n][n];
        int sign = 1;

        for (int f = 0; f < n; f++) {
            getCofactor(matrix, temp, 0, f, n);
            det += sign * matrix[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }
        return det;
    }

    public static void getCofactor(int[][] matrix, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = matrix[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
}

// auth Сидорук Костянтин КБ-21
