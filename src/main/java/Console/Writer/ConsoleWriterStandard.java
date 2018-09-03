package Console.Writer;

import java.io.PrintStream;

public class ConsoleWriterStandard implements ConsoleWriter {

    private PrintStream out;

    public ConsoleWriterStandard() {
        this.out = new PrintStream(System.out);
    }

    public void display(String text) {
        out.println(text);
    }
}
