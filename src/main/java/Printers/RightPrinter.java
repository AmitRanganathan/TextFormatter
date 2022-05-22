package Printers;

public class RightPrinter extends LeftPrinter {

    public RightPrinter(String text, int width) {
        super(text, width);
    }

    @Override
    protected void performCustomLogic(boolean isLastLine) {
        int leftOverSpace;
        leftOverSpace = isLastLine ? width - (currentLineLength - 1) :  width - (currentLineLength - currentWord.length() - 1); // -1 because of the extra space that will always be at the end

        if (leftOverSpace > 0) {
            StringBuilder beginningSpace = new StringBuilder();
            for (int i = 0; i < leftOverSpace; i++) {
                beginningSpace.append(" "); // Add leftOverSpace amount of spaces to the beginning of the line to make it right aligned
            }
            currentLineString = beginningSpace.append(currentLineString);
        }
    }
}
