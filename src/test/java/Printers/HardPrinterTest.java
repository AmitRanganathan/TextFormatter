package Printers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HardPrinterTest {
    @Test
    public void createString() {
        String sentence = "This is what hard justification looks like.";
        int width = 10;
        String expected = "This is wh\n" +
                "at hard ju\n" +
                "stificatio\n" +
                "n looks li\n" +
                "ke.";

        HardPrinter hardPrinter = new HardPrinter(sentence, width);
        assertEquals(expected, hardPrinter.createString());
    }

}