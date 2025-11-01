import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Represents a Text, which is composed of a list of Sentences.
 * This is the top-level container for our object model.
 */
public class Text {

    private List<Sentence> sentences;

    /**
     * Constructs a Text from a list of Sentences.
     *
     * @param sentences The list of sentences that form this text.
     */
    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    /**
     * Applies the required lab logic (Variant 14) to the entire text
     * by delegating the call to each sentence.
     */
    public void applyLabLogic() {
        if (sentences == null) {
            return;
        }

        for (Sentence sentence : sentences) {
            sentence.applyLabLogic();
        }
    }

    /**
     * Reconstructs the entire text into a String for printing.
     *
     * @return The string representation of the text.
     */
    @Override
    public String toString() {
        if (sentences == null || sentences.isEmpty()) {
            return "";
        }

        return sentences.stream()
                .map(Sentence::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Text text = (Text) obj;
        return Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences);
    }
}