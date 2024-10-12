import java.util.Scanner;

public class second_task {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введiть текст: ");
        String text = scn.nextLine();

        String[] sentences = text.split("[.!?]");
        int prcount = sentences.length;

        System.out.println("Кiлькiсть пропозицiй: " + prcount);
        scn.close();
    }
}

// auth: Sydoruk KB-21