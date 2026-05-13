import java.time.LocalDateTime;

public class User {
    private UserIdentifier identifier;
    private String password;
    private LocalDateTime lastLoginDate;
    private boolean isLoggedIn;

    public User(UserIdentifier identifier, String password) {
        this.identifier = identifier;
        this.password = password;
        this.lastLoginDate = null;
        this.isLoggedIn = false;
    }

    @Override
    public String toString() {
        return "User{" + identifier +
                ", lastLogin=" + (lastLoginDate != null ? lastLoginDate : "ніколи") +
                ", isLoggedIn=" + isLoggedIn + "}";
    }

    public UserIdentifier getIdentifier() { return identifier; }
    public String getPassword() { return password; }
    public LocalDateTime getLastLoginDate() { return lastLoginDate; }
    public boolean isLoggedIn() { return isLoggedIn; }

    public void setLastLoginDate(LocalDateTime lastLoginDate) { this.lastLoginDate = lastLoginDate; }
    public void setLoggedIn(boolean loggedIn) { isLoggedIn = loggedIn; }
}
