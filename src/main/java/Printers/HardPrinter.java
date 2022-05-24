package Printers;

public class HardPrinter extends LeftPrinter {
    public HardPrinter(String text, int width) {
        super(text, width);
    }

    @Override
    public String createString() {
        String currentLine;

        while (text.length() > width) { // While our text still has width number of characters
            currentLine = text.substring(0, width) + "\n"; // Grab width number of characters from the text and add a new line
            displayString.append( currentLine); // Append it to our display string
            text = text.substring(width);   // Update text to exclude characters we already used
        }

        displayString.append(text); // Append what is left of the text
        return displayString.toString();
    }
}
