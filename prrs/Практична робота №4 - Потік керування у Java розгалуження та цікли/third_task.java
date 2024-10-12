import java.util.Scanner;

public class third_task {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введiть число 'N': ");
        int n = scn.nextInt();

        System.out.println("Простi числа вiд 1 до " + n + ":");
        for (int num = 2; num <= n; num++) {
            boolean ifeasy = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    ifeasy = false;
                    break;
                }
            }
            if (ifeasy) {
                System.out.print(num + " ");
            }
        }
        scn.close();
    }
}

// auth: Sydoruk KB-21