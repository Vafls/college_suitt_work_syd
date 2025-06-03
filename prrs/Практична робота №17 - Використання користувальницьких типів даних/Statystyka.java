import java.time.LocalDateTime;

public class Statystyka {
    public String imyaPeremozhtsya;
    public char znakPeremozhtsya;
    public LocalDateTime pochatoK;
    public int rozmirPolya;
    public String imGrav1;
    public String imGrav2;

    public Statystyka(String imyaPeremozhtsya, char znakPeremozhtsya, LocalDateTime pochatoK, Nalashtuvannya nalash) {
        this.imyaPeremozhtsya = imyaPeremozhtsya;
        this.znakPeremozhtsya = znakPeremozhtsya;
        this.pochatoK = pochatoK;
        this.rozmirPolya = nalash.rozmirPolya;
        this.imGrav1 = nalash.imGrav1;
        this.imGrav2 = nalash.imGrav2;
    }
}
