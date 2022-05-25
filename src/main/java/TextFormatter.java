import Printers.*;
import utils.Constants;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * TextFormatter class that can read from both command line arguments and user input.
 * Expects only 2 command line arguments
 *  1) algorithm
 *  2) width
 * If these 2 command line arguments are passed, and they are valid, user will be prompted to
 * enter a text to format.
 *
 * If these 2 command line arguments are not passed, then manual mode is triggered and user is prompted
 * to enter a valid algorithm, width, and text.
 *
 * Prints the formatted text using the specified algorithm and width.
 */
public class TextFormatter {
    private static final Logger LOGGER = Logger.getLogger(TextFormatter.class.getName());

    public static void main(String[] args) {
        if (args != null && args.length == 2) { // There must be 3 arguments passed in
            processArguments(args);
        } else {
            System.out.println("Invalid number of arguments passed... Triggering manual mode.");
            while (true) {
                process();
            }
        }

    }

    private static void processArguments(String[] args) {
        // Validate the algorithm
        String algorithm = args[0];
        if (!Arrays.asList(Constants.validAlgorithms).contains(algorithm)) {
            System.out.println("Invalid algorithm specified. Must be center, full, left, right, or hard.");
            System.exit(-1);
        }
        
        int width = 0;
        try {
            width = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid width specified. Must be valid int value.");
            System.exit(-1);
        }

        Scanner input = new Scanner(System.in); // Scanner for user input
        String text = getValidTextFromUser(input);
        printFormattedString(text, algorithm, width);

    }

    private static void process() {
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

        String text = getValidTextFromUser(input);
        printFormattedString(text, algorithm, width);
    }

    private static String formatText(String text, String algorithm, int width) {
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

    /*
    Helper method to get valid sentence from user to use as text
     */
    private static String getValidTextFromUser(Scanner scanner) {
        String text = "";
        boolean validText = false;
        while (!validText) {
            System.out.print("Please enter the text you wish to format: ");
            text = scanner.nextLine();
            if (!text.isBlank() && !text.isEmpty()) {
                validText = true;
            }
        }
        return text;
    }

    private static void printFormattedString(String text, String algorithm, int width) {
        String formattedText = formatText(text, algorithm, width);
        System.out.println("------------------ FORMATTED TEXT ------------------ ");
        System.out.println();

        System.out.println(formattedText);

        System.out.println();
        System.out.println("------------------ END FORMATTED TEXT ------------------ ");
    }}
