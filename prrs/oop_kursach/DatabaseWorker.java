import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DatabaseWorker {

    static final String DB_PORT  = "db.txt";
    static final String DB_USERS = "db_user.txt";
    static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yy");

    static String init() {
        try {
            new File(DB_PORT).createNewFile();
            new File(DB_USERS).createNewFile();
            return "OK";
        } catch (IOException e) {
            return "ERROR:" + e.getMessage();
        }
    }

    static String register(String username, String password) {
        for (String line : readLines(DB_USERS)) {
            if (line.split(";")[0].equals(username)) return "ERROR:Логін вже зайнятий";
        }
        int id = countLines(DB_USERS) + 1;
        appendLine(DB_USERS, username + ";" + password);

        String now = LocalDateTime.now().format(FMT);
        appendLine(DB_PORT, id + ";" + now + ";" + now + ";;;;;;;;;;;");
        return "OK;" + id;
    }

    static String login(String username, String password) {
        List<String> lines = readLines(DB_USERS);
        for (int i = 0; i < lines.size(); i++) {
            String[] p = lines.get(i).split(";", -1);
            if (p[0].equals(username) && p[1].equals(password)) {
                return "OK;" + (i + 1);
            }
        }
        return "ERROR:Невірний логін або пароль";
    }

    static String getPortfolio(int id) {
        List<String> lines = readLines(DB_PORT);
        if (id < 1 || id > lines.size()) return "EMPTY";
        return lines.get(id - 1);
    }

    static String getAllPortfolios() {
        List<String> lines = readLines(DB_PORT);
        if (lines.isEmpty()) return "EMPTY";
        return String.join("\n", lines);
    }

    static String updatePortfolio(int id, String[] newFields) {
        List<String> lines = readLines(DB_PORT);
        if (id < 1 || id > lines.size()) return "ERROR:Запис не знайдено";

        String[] current = lines.get(id - 1).split(";", -1);
        String[] full = Arrays.copyOf(current, 14);

        full[0] = String.valueOf(id);
        full[1] = current.length > 1 ? current[1] : LocalDateTime.now().format(FMT);
        full[2] = LocalDateTime.now().format(FMT);

        for (int i = 0; i < newFields.length && i < 11; i++) {
            if (!newFields[i].isEmpty()) full[3 + i] = newFields[i];
        }

        lines.set(id - 1, String.join(";", full));
        writeLines(DB_PORT, lines);
        return "OK";
    }

    static List<String> readLines(String filename) {
        List<String> result = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) result.add(line);
            }
        } catch (FileNotFoundException ignored) {}
        return result;
    }

    static void writeLines(String filename, List<String> lines) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (String line : lines) pw.println(line);
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    static void appendLine(String filename, String line) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(line);
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    static int countLines(String filename) {
        return readLines(filename).size();
    }
}
