package Console;

import Core.*;
import java.io.*;
import java.text.*;
import java.util.Scanner;

public class ConsolePrompter implements EmployeeDetailGetter {

    private Scanner in;

    public ConsolePrompter(InputStream input) {
        this.in = new Scanner(input);
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
        return in.nextLine();
    }

    private String requestNumberInput() {
        String inputValue = in.nextLine();
        return numericalInputIsValid(inputValue) ? inputValue : requestNumberInput();
    }

    private String requestDate() {
        String inputValue = in.nextLine();
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
        } catch(Exception e){
            return false;
        }
    }

}
