package Console;

import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleWriter {

    private PrintStream out;

    public ConsoleWriter(OutputStream output) {
        this.out = new PrintStream(output);
    }

    public void display(String text) {
        out.println(text);
    }
}
