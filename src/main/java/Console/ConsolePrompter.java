package Console;

import Core.*;
import java.io.*;
import java.util.Scanner;

public class ConsolePrompter implements EmployeeDetailGetter {

    private Scanner in;

    public ConsolePrompter(InputStream input) {
        this.in = new Scanner(input);
    }

    public Employee getEmployee() {
        String firstName = requestFirstName();
        String surname = requestSurname();
        String salary = requestNumberInput();
        String superRate = requestNumberInput();
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

    private String requestNumberInput() {
        String inputValue = in.nextLine();
        return numericalInputIsValid(inputValue) ? inputValue : requestNumberInput();
    }

    private String requestPaymentStartDate() {
        return in.nextLine();
    }

    private String requestPaymentEndDate() {
        return in.nextLine();
    }

    private boolean numericalInputIsValid(String inputValue) {
        try {
            Float.parseFloat(inputValue);
            return true;
        } catch(Exception e){
            return false;
        }
    }

}
