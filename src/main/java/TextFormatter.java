import Printers.*;
import utils.Constants;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 */
public class TextFormatter {
    private static final Logger LOGGER = Logger.getLogger(TextFormatter.class.getName());

    public static void main(String[] args) {
//        System.out.println(args[0]);
        Scanner input = new Scanner(System.in); // Scanner for user input
        boolean validAlgorithm = false;
        boolean validWidth = false;

        // Until the user passes a valid algorithm, keep retrying
        String algorithm = "";
        while (!validAlgorithm) {
            System.out.print("Please enter an algorithm (center, full, left, right, hard): ");
            algorithm = input.nextLine();

            if (!Arrays.asList(Constants.validAlgorithms).contains(algorithm)) {
                System.out.println("Invalid algorithm specified. Must be center, full, left, right, or hard.");
            } else {
                validAlgorithm = true;
            }
        }

        int width = 0;
        // Until the user passes a valid width, keep retrying
        while (!validWidth) {
            System.out.print("Please enter a width: ");
            try {
                width = input.nextInt();
                validWidth = true;
            } catch (Exception e) {
                System.out.println("Invalid width specified. Must be valid int value.");
                input.next();
            }
        }

        input.nextLine(); // Need to call nextLine after nextInt()

        String text = "";
        boolean validText = false;
        while (!validText) {
            System.out.print("Please enter the text you wish to format: ");
            text = input.nextLine();
            if (!text.isBlank() && !text.isEmpty()) {
                validText = true;
            }
        }

        String formattedText = formatText(text, algorithm , width);
        System.out.println("------------------ FORMATTED TEXT ------------------ ");
        System.out.println();

        System.out.println(formattedText);

        System.out.println();
        System.out.println("------------------ END FORMATTED TEXT ------------------ ");
    }

    private static String formatText(String text, String algorithm, int width) {
        System.out.println(algorithm);
        switch (algorithm) {
            case (Constants.LEFT):
                LeftPrinter leftPrinter = new LeftPrinter(text, width);
                return leftPrinter.createString();
            case (Constants.RIGHT):
                RightPrinter rightPrinter = new RightPrinter(text, width);
                return rightPrinter.createString();
            case (Constants.CENTER):
                CenterPrinter centerPrinter = new CenterPrinter(text, width);
                return centerPrinter.createString();
            case (Constants.HARD):
                HardPrinter hardPrinter = new HardPrinter(text, width);
                return hardPrinter.createString();
            default:
                LOGGER.warning("Invalid algorithm identified... Cannot format text...");
                throw new RuntimeException("Invalid algorithm identified... Cannot format text...");
        }
    }

//    private static void printWrapped(String text, int width, boolean isRight, boolean isCenter) {
//        StringTokenizer tokenizer = new StringTokenizer(text, " ");
//        StringBuilder displayString = new StringBuilder(text.length());
//        StringBuilder displayRightString = new StringBuilder();
//        StringBuilder currentLineString = new StringBuilder();
//        int currentLineLength = 0;
//        while (tokenizer.hasMoreTokens()) {
//            String currentWord = tokenizer.nextToken() + " ";
//            currentLineLength += currentWord.length();
//            if (currentLineLength > width) {
//
//                displayString.append("\n");
//                currentLineString.append("\n");
//                // For right aligned, reverse the string and add the space
//                int leftOverSpace = width - (currentLineLength - currentWord.length() - 1); // -1 because of the extra space that will always be at the end
//                if (isRight && leftOverSpace > 0) {
//                    StringBuilder beginningSpace = new StringBuilder();
//                    for (int i = 0; i < leftOverSpace; i++) {
//                        beginningSpace.append(" "); // Add leftOverSpace amount of spaces to the beginning of the line to make it right aligned
//                    }
//                    currentLineString = beginningSpace.append(currentLineString);
//                    displayRightString.append(currentLineString); // Append the right aligned line to the final display right string
//                }
//                if (isCenter) {
//                    if (leftOverSpace >= 2) {
//                        StringBuilder beginningSpace = new StringBuilder();
//                        for (int i = 0; i < leftOverSpace/2; i++) {
//                            beginningSpace.append(" "); // Add leftOverSpace amount of spaces to the beginning of the line to make it right aligned
//                        }
//                        currentLineString = beginningSpace.append(currentLineString);
//                        displayRightString.append(currentLineString); // Append the
//                    } else {
//                        displayRightString.append(currentLineString); // Append the
//                    }
//                }
//                // Reset the variables for the next line
//                currentLineLength = 0;
//                currentLineLength += currentWord.length();
//                currentLineString = new StringBuilder();
//            }
//            currentLineString.append(currentWord);
//            displayString.append(currentWord);
//        }
//
//        if (isRight) {
//            int leftOverSpace = width - (currentLineLength - 1);
//            if (leftOverSpace > 0) {
//                StringBuilder beginningSpace = new StringBuilder();
//                for (int i = 0; i < leftOverSpace; i++) {
//                    beginningSpace.append(" "); // Add leftOverSpace amount of spaces to the beginning of the line to make it right aligned
//                }
//                currentLineString = beginningSpace.append(currentLineString);
//                displayRightString.append(currentLineString); // Append the rig
//            }
//            System.out.println(displayRightString);
//        } else if (isCenter) {
//            int leftOverSpace = width - (currentLineLength - 1);
//            if (leftOverSpace >= 2) {
//                StringBuilder beginningSpace = new StringBuilder();
//                for (int i = 0; i < leftOverSpace / 2; i++) {
//                    beginningSpace.append(" "); // Add leftOverSpace amount of spaces to the beginning of the line to make it right aligned
//                }
//                currentLineString = beginningSpace.append(currentLineString);
//                displayRightString.append(currentLineString); // Append the rig
//            } else {
//                displayRightString.append(currentLineString); // Append the rig
//            }
//            System.out.println(displayRightString);
//        } else {
//            System.out.println(displayString);
//        }
//    }
}
