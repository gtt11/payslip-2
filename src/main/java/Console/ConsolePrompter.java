package Console;

import Core.*;
import java.text.*;


public class ConsolePrompter implements EmployeeDetailGetter, PayslipPresenter {

    private ConsoleIO console;

    public ConsolePrompter(ConsoleIO console) {
        this.console = console;
    }

    public Employee getEmployee() {
        String firstName = requestTextInput();
        String surname = requestTextInput();
        String salary = requestNumberInput();
        String superRate = requestNumberInput();
        String paymentStartDate = requestDate();
        String paymentEndDate = requestDate();
        return new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private String requestTextInput() {
        return console.ask();
    }

    private String requestNumberInput() {
        String inputValue = console.ask();
        return numericalInputIsValid(inputValue) ? inputValue : requestNumberInput();
    }

    private String requestDate() {
        String inputValue = console.ask();
        return dateInputIsValid(inputValue) ? inputValue : requestDate();
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
        console.display("Name: " + payslip.getName());
    }
}
