import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A parser class responsible for converting a raw String
 * into our composite Text object model.
 * This class also handles the whitespace normalization requirement.
 */
public class TextParser {

    /**
     * Main public method to parse a string.
     *
     * @param inputText The raw input text.
     * @return A fully constructed Text object.
     */
    public static Text parse(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return new Text(new ArrayList<>());
        }

        String normalizedText = inputText.replaceAll("[ \\t]+", " ");

        List<Sentence> sentences = parseSentences(normalizedText);

        return new Text(sentences);
    }

    /**
     * Splits the normalized text into Sentences.
     * We define a sentence as anything ending with [.!?]
     * OR as any remaining text.
     */
    private static List<Sentence> parseSentences(String text) {
        List<Sentence> sentenceList = new ArrayList<>();

        Pattern sentencePattern = Pattern.compile("([^.!?]+[.!?])");
        Matcher sentenceMatcher = sentencePattern.matcher(text);

        int lastMatchEnd = 0;

        while (sentenceMatcher.find()) {
            String sentenceText = sentenceMatcher.group().trim();
            if (!sentenceText.isEmpty()) {
                sentenceList.add(parseSingleSentence(sentenceText));
            }
            lastMatchEnd = sentenceMatcher.end();
        }

        if (lastMatchEnd < text.length()) {
            String leftoverText = text.substring(lastMatchEnd).trim();
            if (!leftoverText.isEmpty()) {
                sentenceList.add(parseSingleSentence(leftoverText));
            }
        }

        return sentenceList;
    }

    /**
     * Parses a single sentence string into a list of Words and Punctuation.
     */
    private static Sentence parseSingleSentence(String sentenceText) {
        List<SentenceElement> elements = new ArrayList<>();

        Pattern elementPattern = Pattern.compile("([a-zA-Z]+)|([^a-zA-Z])");
        Matcher elementMatcher = elementPattern.matcher(sentenceText);

        while (elementMatcher.find()) {
            String wordMatch = elementMatcher.group(1);
            String punctuationMatch = elementMatcher.group(2);

            if (wordMatch != null) {
                elements.add(parseSingleWord(wordMatch));
            } else if (punctuationMatch != null) {
                char mark = punctuationMatch.charAt(0);
                if (!Character.isWhitespace(mark)) {
                    elements.add(new Punctuation(mark));
                }
            }
        }
        return new Sentence(elements);
    }

    /**
     * Parses a single word string into a list of Letters.
     */
    private static Word parseSingleWord(String wordText) {
        List<Letter> letters = new ArrayList<>();
        for (char c : wordText.toCharArray()) {
            letters.add(new Letter(c));
        }
        return new Word(letters);
    }
}