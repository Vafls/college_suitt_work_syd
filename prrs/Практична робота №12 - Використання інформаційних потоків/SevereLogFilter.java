import java.io.*;
import java.util.Scanner;

public class SevereLogFilter implements LogFilter {

    @Override
    public void filter(String vkhidnyjFajl, String vykhidnyjFajl, LogLevel riven) {

        String klyuchovoSlovo = riven.otrymatyKlyuchovoSlovo();
        int kilkistZnahodzhen = 0;

        try (
            Scanner skaner = new Scanner(
                                 new BufferedReader(
                                     new FileReader(vkhidnyjFajl)));

            PrintWriter zapysuvach = new PrintWriter(
                                         new BufferedWriter(
                                             new FileWriter(vykhidnyjFajl)))
        ) {
            System.out.println("Обробка файлу: " + vkhidnyjFajl);
            System.out.println("Пошук рядків з ключовим словом: " + klyuchovoSlovo);
            System.out.println("-------------------------------------------");

            while (skaner.hasNextLine()) {
                String ryadok = skaner.nextLine();

                if (ryadok.contains(klyuchovoSlovo)) {
                    zapysuvach.println(ryadok);
                    kilkistZnahodzhen++;
                }
            }

            System.out.println("Фільтрацію завершено.");
            System.out.println("Знайдено та збережено рядків: " + kilkistZnahodzhen);
            System.out.println("Результат записано у файл: " + vykhidnyjFajl);

        } catch (FileNotFoundException pomylka) {
            System.err.println("Помилка: файл не знайдено — " + pomylka.getMessage());
        } catch (IOException pomylka) {
            System.err.println("Помилка введення/виведення — " + pomylka.getMessage());
        }
    }
}
