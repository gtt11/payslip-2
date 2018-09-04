package Console;

import Console.Reader.ConsoleReader;
import Console.Writer.ConsoleWriter;
import Core.Employee.Employee;
import Core.Employee.EmployeeGetter;

import java.math.BigDecimal;

public class ConsoleEmployeeGetter implements EmployeeGetter {

    private ConsoleReader input;
    private ConsoleWriter output;
    private Validator validator;

    public ConsoleEmployeeGetter(ConsoleReader consoleReader, ConsoleWriter consoleWriter, Validator validator) {
        this.input = consoleReader;
        this.output = consoleWriter;
        this.validator = validator;
    }

    public Employee getEmployee() {
        output.display("Welcome to the payslip generator!\n");
        String firstName = requestNameInput("Please enter your first name:");
        String surname = requestNameInput("Please enter your surname:");
        BigDecimal salary = requestSalaryInput("Please enter your annual salary:");
        BigDecimal superRate = requestSuperInput("Please enter your super rate:");
        String paymentStartDate = requestDate("Please enter your payment start date:");
        String paymentEndDate = requestDate("Please enter your payment end date:");
        return new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private String requestNameInput(String question) {
        output.display(question);
        String inputValue = input.getResponse();
        return validator.nameInputIsValid(inputValue) ? inputValue : requestNameInput("Invalid selection. " + question);
    }

    private BigDecimal requestSalaryInput(String question) {
        output.display(question);
        String inputValue = input.getResponse();
        return validator.salaryInputIsValid(inputValue) ? new BigDecimal(inputValue) : requestSalaryInput("Invalid selection. " + question);
    }

    private BigDecimal requestSuperInput(String question) {
        output.display(question);
        String inputValue = input.getResponse();
        return validator.superInputIsValid(inputValue) ? new BigDecimal(inputValue) : requestSuperInput("Invalid selection. " + question);
    }

    private String requestDate(String question) {
        output.display(question);
        String inputValue = input.getResponse();
        return validator.dateInputIsValid(inputValue) ? inputValue : requestDate("Invalid selection. " + question);
    }

}
