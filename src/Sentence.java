import java.util.List;
import java.util.Objects;

/**
 * Represents a Sentence, which is composed of a list of SentenceElements
 * (Words and Punctuation).
 */
public class Sentence {

    private List<SentenceElement> elements;

    /**
     * Constructs a Sentence from a list of its elements.
     *
     * @param elements The list of Words and Punctuation marks.
     */
    public Sentence(List<SentenceElement> elements) {
        this.elements = elements;
    }

    /**
     * Applies the Lab 2 logic (Variant 14) to every Word in this sentence.
     */
    public void applyLabLogic() {
        if (elements == null) {
            return;
        }

        for (SentenceElement element : elements) {
            if (element instanceof Word) {
                ((Word) element).removeSubsequentFirstLetter();
            }
        }
    }

    /**
     * Reconstructs the sentence into a String for printing.
     * It handles spacing between words and punctuation correctly.
     *
     * @return The string representation of the sentence.
     */
    @Override
    public String toString() {
        if (elements == null || elements.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(elements.get(0).toString());

        for (int i = 1; i < elements.size(); i++) {
            SentenceElement current = elements.get(i);

            if (current instanceof Word) {
                sb.append(" ");
            }

            sb.append(current.toString());
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Sentence sentence = (Sentence) obj;
        return Objects.equals(elements, sentence.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}