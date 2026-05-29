import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class UserRegistry {

    private HashMap<UserIdentifier, User> users = new HashMap<>();
    private int nextId = 1;

    public void saveToFile(String filePath) {
        List<User> snapshot = new ArrayList<>(users.values());
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(snapshot);
            System.out.println("Збережено " + snapshot.size()
                    + " користувачів у файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filePath) {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(filePath))) {
            List<User> loaded = (List<User>) ois.readObject();
            users.clear();
            int maxId = 0;
            for (User u : loaded) {
                users.put(u.getIdentifier(), u);
                if (u.getIdentifier().getId() > maxId) {
                    maxId = u.getIdentifier().getId();
                }
            }
            nextId = maxId + 1;
            System.out.println("Відновлено " + loaded.size()
                    + " користувачів із файлу: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    public void registerUser(String login, String password) {
        if (isUserRegistered(login)) {
            System.out.println("Користувач [" + login + "] вже є у списку");
            return;
        }
        UserIdentifier identifier = new UserIdentifier(nextId, login);
        User newUser = new User(identifier, password);
        users.put(identifier, newUser);
        nextId++;
        System.out.println("Користувач [" + login + "] успішно зареєстрований");
    }

    public void loginUser(String login, String password) {
        for (User user : users.values()) {
            if (user.getIdentifier().getName().equals(login)) {
                if (user.getPassword().equals(password)) {
                    user.setLoggedIn(true);
                    user.setLastLoginDate(LocalDateTime.now());
                    System.out.println("Користувач [" + login + "] успішно увійшов у систему");
                } else {
                    System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
                }
                return;
            }
        }
        System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
    }

    public void logoutUser(int userId) {
        for (User user : users.values()) {
            if (user.getIdentifier().getId() == userId) {
                if (user.isLoggedIn()) {
                    user.setLoggedIn(false);
                    System.out.println("Користувач ["
                            + user.getIdentifier().getName() + "] вийшов із системи");
                } else {
                    System.out.println("Користувач з id=" + userId
                            + " і так не був у системі");
                }
                return;
            }
        }
        System.out.println("Користувача з id=" + userId + " не знайдено");
    }

    public boolean isUserRegistered(String login) {
        for (User user : users.values()) {
            if (user.getIdentifier().getName().equals(login)) return true;
        }
        return false;
    }

    public void removeUser(int id) {
        UserIdentifier keyToRemove = null;
        for (Map.Entry<UserIdentifier, User> entry : users.entrySet()) {
            if (entry.getKey().getId() == id) {
                keyToRemove = entry.getKey();
                break;
            }
        }
        if (keyToRemove != null) {
            users.remove(keyToRemove);
            System.out.println("Користувач [" + keyToRemove.getName()
                    + "] видалений зі списку");
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
        getUserList().forEach(System.out::println);
        System.out.println("--------------------------------");
    }

    public LinkedList<User> getUserList() {
        LinkedList<User> list = new LinkedList<>(users.values());
        list.sort(Comparator.comparing(u -> u.getIdentifier().getName()));
        return list;
    }

    public LinkedList<User> getInOrder(Comparator<User> comparator) {
        LinkedList<User> list = new LinkedList<>(users.values());
        list.sort(comparator);
        return list;
    }

    public LinkedList<User> getFiltered(Predicate<User> predicate) {
        LinkedList<User> result = new LinkedList<>();
        for (User user : users.values()) {
            if (predicate.test(user)) result.add(user);
        }
        return result;
    }
}
