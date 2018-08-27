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
        String salary = requestSalary();
        String superRate = requestSuperRate();
        String paymentStartDate = requestPaymentStartDate();
        String paymentEndDate = requestPaymentEndDate();
        return new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private String requestFirstName() {
        return in.nextLine();
    }

    private String requestSurname() {
        return in.nextLine();
    }

    private String requestSalary() {
        return in.nextLine();
    }

    private String requestSuperRate() {
        return in.nextLine();
    }

    private String requestPaymentStartDate() {
        return in.nextLine();
    }

    private String requestPaymentEndDate() {
        return in.nextLine();
    }
}
