package Printers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeftPrinterTest {

    @Test
    public void createString() {
        String sentence = "This text should be left aligned ";
        int width = 10;
        String expected = "This text \n" +
                "should be \n" +
                "left \n" +
                "aligned ";

        LeftPrinter leftPrinter = new LeftPrinter(sentence, width);
        assertEquals(expected, leftPrinter.createString());

        sentence = "This text should be left aligned ";
        width = 20;
        expected = "This text should be \n" +
                "left aligned ";

        leftPrinter = new LeftPrinter(sentence, width);
        assertEquals(expected, leftPrinter.createString());
    }

}