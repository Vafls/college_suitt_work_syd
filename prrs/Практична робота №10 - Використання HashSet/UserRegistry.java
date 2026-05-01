import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserRegistry {
    private HashSet<User> users = new HashSet<>();
    private int nextId = 1;

    public void registerUser(String login, String password) {
        User newUser = new User(nextId, login, password);
        if (!users.add(newUser)) {
            System.out.println("Користувач [" + login + "] вже є у списку");
        } else {
            nextId++;
            System.out.println("Користувач [" + login + "] успішно зареєстрований");
        }
    }

    public void loginUser(String login, String password) {
        for (User user : users) {
            if (user.getName().equals(login)) {
                if (user.getPassword().equals(password)) {
                    user.setLoggedIn(true);
                    user.setLastLoginDate(LocalDateTime.now());
                    System.out.println("Користувач [" + login + "] успішно увійшов у систему");
                    return;
                } else {
                    System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
                    return;
                }
            }
        }
        System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
    }

    public void logoutUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                if (user.isLoggedIn()) {
                    user.setLoggedIn(false);
                    System.out.println("Користувач [" + user.getName() + "] вийшов із системи");
                } else {
                    System.out.println("Користувач з id=" + userId + " і так не був у системі");
                }
                return;
            }
        }
        System.out.println("Користувача з id=" + userId + " не знайдено");
    }

    public boolean isUserRegistered(String login) {
        for (User user : users) {
            if (user.getName().equals(login)) return true;
        }
        return false;
    }

    public void removeUser(int id) {
        User toRemove = null;
        for (User user : users) {
            if (user.getId() == id) {
                toRemove = user;
                break;
            }
        }
        if (toRemove != null) {
            users.remove(toRemove);
            System.out.println("Користувач [" + toRemove.getName() + "] видалений зі списку");
        } else {
            System.out.println("Користувача з id=" + id + " не знайдено");
        }
    }

    public void printTotalUniqueUsers() {
        System.out.println("Кількість унікальних користувачів: " + users.size());
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Список користувачів порожній");
            return;
        }
        System.out.println("--- Список всіх користувачів ---");
        List<User> sorted = new ArrayList<>(users);
        sorted.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        for (User user : sorted) {
            System.out.println(user);
        }
        System.out.println("--------------------------------");
    }
}
