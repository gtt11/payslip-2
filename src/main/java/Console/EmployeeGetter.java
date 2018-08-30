package Console;

import Core.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeGetter {

    private ConsoleReader input;
    private ConsoleWriter output;

    public EmployeeGetter(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.input = consoleReader;
        this.output = consoleWriter;
    }

    public Employee getEmployee() {
        output.display("Welcome to the payslip generator!\n");
        String firstName = requestTextInput("Please enter your first name:");
        String surname = requestTextInput("Please enter your surname:");
        String salary = requestNumberInput("Please enter your annual salary:");
        String superRate = requestNumberInput("Please enter your super rate:");
        String paymentStartDate = requestDate("Please enter your payment start date:");
        String paymentEndDate = requestDate("Please enter your payment end date:");
        return new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private String requestTextInput(String question) {
        output.display(question);
        return input.getResponse();
    }

    private String requestNumberInput(String question) {
        output.display(question);
        String inputValue = input.getResponse();
        return numericalInputIsValid(inputValue) ? inputValue : requestNumberInput("Invalid selection. " + question);
    }

    private String requestDate(String question) {
        output.display(question);
        String inputValue = input.getResponse();
        return dateInputIsValid(inputValue) ? inputValue : requestDate("Invalid selection. " + question);
    }

    public boolean dateInputIsValid(String inputValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM");
        sdf.setLenient(false);
        try {
            sdf.parse(inputValue);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean numericalInputIsValid(String inputValue) {
        try {
            Float.parseFloat(inputValue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
