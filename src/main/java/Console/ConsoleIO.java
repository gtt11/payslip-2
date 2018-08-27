package Console;

import java.io.*;
import java.util.Scanner;

public class ConsoleIO {

    private Scanner in;

    public ConsoleIO(InputStream input) {
        this.in = new Scanner(input);
    }

    public String ask() {
        return in.nextLine();
    }
}
