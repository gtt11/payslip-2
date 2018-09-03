package Console.Reader;

import java.util.Scanner;

public class ConsoleReaderStandard implements ConsoleReader {

    private Scanner in;

    public ConsoleReaderStandard() {
        this.in = new Scanner(System.in);
    }

    public String getResponse() {
        return in.nextLine();
    }

}
