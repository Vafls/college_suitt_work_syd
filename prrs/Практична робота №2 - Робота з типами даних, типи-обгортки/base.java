import java.util.Scanner;

public class base {
    
    public static void definfo() {
        System.out.println("Примітивні типи даних у язику програмування Java:");
        
        System.out.println("byte:");
        System.out.println("Розмір: " + Byte.SIZE + " біт");
        System.out.println("Мінімальне значення: " + Byte.MIN_VALUE);
        System.out.println("Максимальне значення: " + Byte.MAX_VALUE);
        
        System.out.println("\nshort:");
        System.out.println("Розмір: " + Short.SIZE + " біт");
        System.out.println("Мінімальне значення: " + Short.MIN_VALUE);
        System.out.println("Максимальне значення: " + Short.MAX_VALUE);
        
        System.out.println("\nint:");
        System.out.println("Розмір: " + Integer.SIZE + " біт");
        System.out.println("Мінімальне значення: " + Integer.MIN_VALUE);
        System.out.println("Максимальне значення: " + Integer.MAX_VALUE);
        
        System.out.println("\nlong:");
        System.out.println("Розмір: " + Long.SIZE + " біт");
        System.out.println("Мінімальне значення: " + Long.MIN_VALUE);
        System.out.println("Максимальне значення: " + Long.MAX_VALUE);
        
        System.out.println("\nfloat:");
        System.out.println("Розмір: " + Float.SIZE + " біт");
        System.out.println("Мінімальне значення: " + Float.MIN_VALUE);
        System.out.println("Максимальне значення: " + Float.MAX_VALUE);
        
        System.out.println("\ndouble:");
        System.out.println("Розмір: " + Double.SIZE + " біт");
        System.out.println("Мінімальне значення: " + Double.MIN_VALUE);
        System.out.println("Максимальне значення: " + Double.MAX_VALUE);
        
        System.out.println("\nchar:");
        System.out.println("Розмір: " + Character.SIZE + " біт");
        System.out.println("Мінімальне значення: " + (int) Character.MIN_VALUE);
        System.out.println("Максимальне значення: " + (int) Character.MAX_VALUE);
        
        System.out.println("\nboolean:");
        System.out.println("boolean не має визначеного розміру, значення: true або false");
    }

    public static void readAndConvert(Scanner scan) {
        System.out.println("\nВведіть ціле число (int):");
        String intInput = scan.nextLine();
        int intValue = Integer.parseInt(intInput);
        System.out.println("Ви ввели: " + intValue);
        
        System.out.println("\nВведіть дробове число (double):");
        String doubleInput = scan.nextLine();
        double doubleValue = Double.parseDouble(doubleInput);
        System.out.println("Ви ввели: " + doubleValue);
        
        System.out.println("\nВведіть символ (char):");
        String charInput = scan.nextLine();
        char charValue = charInput.charAt(0);
        System.out.println("Ви ввели: " + charValue);
        
        System.out.println("\nВведіть логічне значення (boolean):");
        String booleanInput = scan.nextLine();
        boolean booleanValue = Boolean.parseBoolean(booleanInput);
        System.out.println("Ви ввели: " + booleanValue);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        definfo();
        
        readAndConvert(scan);
        
        scan.close();
    }
}


// зробив Сидорук К.В. Група КБ-21.