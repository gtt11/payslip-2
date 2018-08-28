package Console;

import java.io.*;
import java.util.Scanner;

public class ConsoleIO {

    private Scanner in;
    private PrintStream out;

    public ConsoleIO(InputStream input, OutputStream output) {
        this.in = new Scanner(input);
        this.out = new PrintStream(output);
    }

    public String ask(String question) {
        display(question);
        return in.nextLine();
    }

    public void display(String text) {
        out.println(text);
    }

}
