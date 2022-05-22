package Printers;

public class HardPrinter extends LeftPrinter {

    public HardPrinter(String text, int width) {
        super(text, width);
        this.algorithm = Algorithms.HARD;
    }

    @Override
    protected void performCustomLogic(boolean isLastLine) {
        int leftOverSpace;
        // currentLineLength - currentWord.length() - 1 can be greater than width

        leftOverSpace = isLastLine ? width - (currentLineLength - 1) :  width - (currentLineLength - currentWord.length() - 1); // -1 because of the extra space that will always be at the end
//        currentLineString.deleteCharAt(4); // Remove the \n (new line) character from the current Line.

        String charsToFillLine = currentWord.substring(0, leftOverSpace-1);
        currentLineString = currentLineString.append(charsToFillLine);
//        // We need to get leftOverSpace number of characters from the next line and add it to the currentLineString
//        if (leftOverSpace > 0) {
//            StringBuilder beginningSpace = new StringBuilder();
//            for (int i = 0; i < leftOverSpace / 2; i++) {
//                beginningSpace.append(" "); // Add leftOverSpace / 2 amount of spaces to the beginning of the line to make it center aligned
//            }
//            currentLineString = beginningSpace.append(currentLineString);
//        }
    }
}
