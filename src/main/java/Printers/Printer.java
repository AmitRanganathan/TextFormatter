package Printers;

import java.util.StringTokenizer;

/**
 * Abstract class that represents a generic Printer.  Child classes must
 * implement the functionality of createString.
 */
public abstract class Printer {
    protected String text;
    protected int width;
    protected Algorithms algorithm;
    protected StringTokenizer tokenizer;
    protected StringBuilder displayString;
    protected StringBuilder currentLineString = new StringBuilder();

    public Printer(String text, int width) {
        this.text = text;
        this.width = width;
        this.tokenizer = new StringTokenizer(text, " ");
        this.displayString = new StringBuilder(text.length());
    }

    public abstract String createString();

}


