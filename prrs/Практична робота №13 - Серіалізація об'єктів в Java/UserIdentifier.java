import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class UserIdentifier implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public UserIdentifier(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIdentifier that = (UserIdentifier) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + "'";
    }

    public int getId()     { return id; }
    public String getName(){ return name; }
}
