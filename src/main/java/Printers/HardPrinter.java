package Printers;

public class HardPrinter extends LeftPrinter {

    public HardPrinter(String text, int width) {
        super(text, width);
        this.algorithm = Algorithms.HARD;
    }

    @Override
    protected void performCustomLogic(boolean isLastLine) {
        int leftOverSpace; // Will keep track of the number of characters we need to add or remove from the current line to adhere to width

        leftOverSpace = isLastLine ? width - (currentLineLength - 1) :  width - (currentLineLength - currentWord.length() - 1); // -1 because of the extra space that will always be at the end

        String charsToFillLine;
        if (leftOverSpace < 0) {
            // If left over space is negative, we can be certain that the currentLineString.length() > width.
            // This means that leftOverSpace will be a negative value.  Meaning, we need to remove characters
            // from currentLineString.  Remove width - (leftOverSpace + 1) to determine number of characters to remove.
            // + 1 is to allocate for the space.
            StringBuilder copyString = currentLineString;
            currentLineString = new StringBuilder(currentLineString.substring(0, width - (leftOverSpace + 1)));
            currentWord = copyString.substring(width-(leftOverSpace + 1)) + currentWord;
        } else {
            // If conditional here to ensure we aren't processing the last line.  The last line might only contain a
            // few characters.  Don't need to do anything.
            if (currentWord.length() > leftOverSpace-1) {
                // Grab the leftOverSpace worth of characters from the currentWord.
                // Remove the characters from currentWord so that we don't use the same characters twice.
                // Append the characters to currentLineString
                charsToFillLine = currentWord.substring(0, leftOverSpace-1);
                currentWord = currentWord.substring(leftOverSpace-1);
                currentLineString = currentLineString.append(charsToFillLine);
            }
        }
    }
}
