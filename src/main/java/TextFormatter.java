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
        while (true) {
            process();
        }
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
}
