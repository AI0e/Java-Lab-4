import java.util.Objects;

/**
 * Represents a punctuation mark in a sentence.
 * This class implements SentenceElement and is immutable.
 */
public class Punctuation implements SentenceElement {

    private final char mark;

    /**
     * Constructs a Punctuation object.
     *
     * @param mark The punctuation character (e.g., '.', ',', '!').
     */
    public Punctuation(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Punctuation that = (Punctuation) obj;
        return mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark);
    }
}