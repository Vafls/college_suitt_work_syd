import java.util.Scanner;

public class hww3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Уведіть ціле число: ");
        int intVal = scn.nextInt();

        System.out.print("Уведіть число з плаваючою точкою: ");
        double floatVal = scn.nextDouble();

        scn.nextLine();  

        System.out.print("Уведіть строку: ");
        String strVal = scn.nextLine();

        System.out.print("Уведіть 1 або 0 ");
        boolean boolVal = scn.nextInt() == 1;

        System.out.println("\nСтарий стиль форматування (String.format):");
        System.out.println(String.format("Ціле число: %d, шістнадцяткове: %x, вісімкове: %o", intVal, intVal, intVal));
        System.out.println(String.format("Число з плаваючою точкою: %.2f", floatVal));
        System.out.println(String.format("Рядок: %.5s", strVal));
        System.out.println(String.format("Логічне значення: %b", boolVal));

        System.out.println("\nМетод System.out.printf:");
        System.out.printf("Ціле число: %d, шістнадцяткове: %x, вісімкове: %o%n", intVal, intVal, intVal);
        System.out.printf("Число з плаваючою точкою: %.2f%n", floatVal);
        System.out.printf("Рядок: %.10s%n", strVal);
        System.out.printf("Логічне значення: %b%n", boolVal);

        System.out.println("\nЗвичайна конкатенація:");
        System.out.println("Ціле число: " + intVal + ", шістнадцяткове: " + Integer.toHexString(intVal) +
                ", вісімкове: " + Integer.toOctalString(intVal));
        System.out.println("Число з плаваючою точкою: " + String.format("%.2f", floatVal));
        System.out.println("Рядок: " + strVal.substring(0, Math.min(7, strVal.length()))); 
        System.out.println("Логічне значення: " + boolVal);
    }
}
