package Printers;

public class LeftPrinter extends Printer {
    protected int currentLineLength;
    protected String currentWord;

    public LeftPrinter(String text, int width) {
        super(text, width);
    }

    @Override
    public String createString() {
        currentLineLength = 0;
        while (tokenizer.hasMoreTokens()) {
            currentWord = tokenizer.nextToken() + " ";
            currentLineLength += currentWord.length();
            if (currentLineLength - 1 > width) { // Subtract 1 to allocate for space at the end and only count words
                performCustomLogic(false);
                currentLineString.append("\n");
                displayString.append(currentLineString);

                // Reset the variables for the next line
                currentLineLength = 0;
                currentLineLength += currentWord.length();
                currentLineString = new StringBuilder();
            }
            currentLineString.append(currentWord);
        }
        performCustomLogic(true);
        displayString.append(currentLineString);

        return displayString.toString();

    }

    protected void performCustomLogic(boolean isLastLine) {
    }
}
