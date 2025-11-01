import java.util.List;
import java.util.Objects;

/**
 * Represents a Word, which is composed of a list of Letters.
 * This class implements SentenceElement and contains the logic
 * required by Lab 2 (Variant 14).
 */
public class Word implements SentenceElement {

    private List<Letter> letters;

    /**
     * Constructs a Word from a list of Letter objects.
     *
     * @param letters The list of letters that form this word.
     */
    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    /**
     * Reconstructs the word into a String for printing.
     *
     * @return The string representation of the word.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getCharacter());
        }
        return sb.toString();
    }

    /**
     * Executes the logic for Lab 2, Variant 14.
     * Removes all subsequent occurrences of the first letter
     * from this word's list of letters (case-sensitive).
     */
    public void removeSubsequentFirstLetter() {
        if (letters == null || letters.size() <= 1) {
            return; // Nothing to remove
        }

        Letter firstLetter = letters.get(0);

        for (int i = letters.size() - 1; i > 0; i--) {
            if (letters.get(i).equals(firstLetter)) {
                letters.remove(i);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Word word = (Word) obj;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}