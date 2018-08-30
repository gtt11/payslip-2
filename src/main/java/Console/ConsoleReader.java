package Console;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader {

    private Scanner in;

    public ConsoleReader(InputStream input) {
        this.in = new Scanner(input);
    }

    public String getResponse() {
        return in.nextLine();
    }


}
