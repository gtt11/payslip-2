package Console;

import Core.*;
import java.io.*;
import java.util.Scanner;

public class ConsoleReader implements EmployeeDetailGetter {

    private Scanner in;

    public ConsoleReader(InputStream input) {
        this.in = new Scanner(input);
    }

    public Employee getEmployee() {
        String firstName = requestFirstName();
        String surname = requestSurname();
        return new Employee(firstName, surname, "65000", "9", "1 March", "30 March");
    }

    private String requestFirstName() {
        return in.nextLine();
    }

    private String requestSurname() {
        return in.nextLine();
    }


}
