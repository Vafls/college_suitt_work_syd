public class Main {
    public static void main(String[] args) {
        String init = DatabaseWorker.init();
        if (init.startsWith("ERROR")) {
            System.out.println("Не вдалося ініціалізувати базу даних: " + init);
            return;
        }
        new App().run();
    }
}

// ТВ