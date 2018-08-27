package Console;

import Core.*;
import java.text.*;


public class ConsolePrompter implements EmployeeDetailGetter, PayslipPresenter {

    private ConsoleIO console;

    public ConsolePrompter(ConsoleIO console) {
        this.console = console;
    }

    public Employee getEmployee() {
        console.display("Welcome to the payslip generator!\n");
        String firstName = requestTextInput("Please enter your first name:");
        String surname = requestTextInput("Please enter your surname:");
        String salary = requestNumberInput("Please enter your annual salary:");
        String superRate = requestNumberInput("Please enter your super rate:");
        String paymentStartDate = requestDate("Please enter your payment start date:");
        String paymentEndDate = requestDate("Please enter your payment end date:");
        return new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private String requestTextInput(String question) {
        return console.ask(question);
    }

    private String requestNumberInput(String question) {
        String inputValue = console.ask(question);
        return numericalInputIsValid(inputValue) ? inputValue : requestNumberInput("Invalid selection. " + question);
    }

    private String requestDate(String question) {
        String inputValue = console.ask(question);
        return dateInputIsValid(inputValue) ? inputValue : requestDate("Invalid selection. " + question);
    }

    public boolean dateInputIsValid(String inputValue){
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

    public void outputPayslip(PaySlip payslip) {
        console.display("Your payslip has been generated:\n");
        console.display("Name: " + payslip.getName());
        console.display("Pay Period: " + payslip.getPayPeriod());
        console.display("Gross Income: " + payslip.getGrossIncome());
        console.display("Income Tax: " + payslip.getIncomeTax());
        console.display("Net Income: " + payslip.getNetIncome());
        console.display("Super: " + payslip.getSuperannuation() + "\n");
        console.display("Thank you for using MYOB!");
    }

}
