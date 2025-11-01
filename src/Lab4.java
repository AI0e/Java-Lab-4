import java.util.Scanner;

/**
 * Main executable class for Laboratory Work #4.
 * This class demonstrates class composition by refactoring Lab 2.
 * It uses a Text object model (Text, Sentence, Word, Letter) and
 * a parser to perform the logic.
 *
 * Variant 14: Remove all subsequent occurrences of the first letter in each
 * word.
 */
public class Lab4 {

    private static final String SAMPLE_TEXT = "Little Lora looked for her little lamb. Statistics is a science. A big bamboo boat. Anna likes apples.";

    /**
     * Program entry point.
     * Handles the user interface loop, I/O, and top-level exception handling.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.print("\nEnter your text (or press Enter for sample): ");
                String line = scanner.nextLine();

                String inputText;
                boolean isSample = false;

                if (line == null || line.trim().isEmpty()) {
                    inputText = SAMPLE_TEXT;
                    System.out.println("\nUsing sample text:");
                    isSample = true;
                } else {
                    inputText = line;
                }

                try {
                    // 1. PARSE: Convert String -> Object Model
                    Text text = TextParser.parse(inputText);

                    // We print the "original" text *after* parsing
                    // to show the whitespace normalization.
                    if (isSample) {
                        System.out.println(text.toString());
                    } else {
                        System.out.println("\nNormalized original text:\n" + text.toString());
                    }

                    // 2. APPLY LOGIC: Call the method on the top-level object
                    text.applyLabLogic();

                    // 3. PRINT RESULT: Call toString() on the modified object
                    System.out.println("\nProcessed text:\n" + text.toString());

                } catch (Exception e) {
                    System.err.println("An error occurred during processing: " + e.getMessage());
                    e.printStackTrace();
                }

                // Ask the user to exit
                String choice;
                do {
                    System.out.print("\nDo you want to exit? (y/n): ");
                    choice = scanner.nextLine().trim().toLowerCase();
                } while (!choice.equals("y") && !choice.equals("n"));

                if (choice.equals("y")) {
                    exit = true;
                    System.out.println("Program finished.");
                }
            }
        }
    }
}