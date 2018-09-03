package Alternates;

import Console.Reader.ConsoleReader;

import java.io.*;
import java.util.Scanner;

public class ConsoleReaderAlternateAcceptsInputStream implements ConsoleReader {

    private Scanner in;

    public ConsoleReaderAlternateAcceptsInputStream(String input) throws UnsupportedEncodingException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
        this.in = new Scanner(inputStream);
    }

    public String getResponse() {
        return in.nextLine();
    }

}


