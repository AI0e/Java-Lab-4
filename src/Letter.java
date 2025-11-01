import java.util.Objects;

/**
 * Represents a single Letter (an "atom" of a word).
 * This class is immutable.
 */
public class Letter {

    private final char character;

    /**
     * Constructs a Letter object.
     *
     * @param character The character this Letter represents.
     */
    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Letter letter = (Letter) obj;
        return character == letter.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}