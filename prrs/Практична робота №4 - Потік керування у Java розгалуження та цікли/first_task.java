import java.util.Scanner;

public class first_task {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введiть довжини трьох сторонiн трикутника (через пробiли): ");
        double a = scn.nextDouble();
        double b = scn.nextDouble();
        double c = scn.nextDouble();

        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                System.out.println("Трикутник рiвностороннiй.");
            } else if (a == b || b == c || a == c) {
                System.out.println("Трикутник рiвнобедренний.");
            } else {
                System.out.println("Трикутник рiзностороннiй.");
            }
        } else {
            System.out.println("Трикутника з такмими сторонами не iснуэ.");
        }
        scn.close();
    }
}

// auth: Sydoruk KB-21