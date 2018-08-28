package Console;

import Core.*;
import DataStore.JSONTaxBracketLoader;
import DataStore.TaxBracketLoader;

import java.io.FileNotFoundException;

public class ConsoleApplication {

    private PayslipGenerator payslipGenerator;
    private UserInterface userInterface;

    public ConsoleApplication(PayslipGenerator payslipGenerator, UserInterface userInterface) {
        this.payslipGenerator = payslipGenerator;
        this.userInterface = userInterface;
    }

    public void run() throws FileNotFoundException {
        Employee employee = userInterface.getEmployee();
        PaySlip payslip = preparePayslip(employee);
        outputPayslip(payslip);
    }

    private PaySlip preparePayslip(Employee employee) throws FileNotFoundException {
        return payslipGenerator.getPayslip(employee);
    }

    private void outputPayslip(PaySlip payslip) {
        userInterface.outputPayslip(payslip);
    }

    public static void main(String[] args) throws FileNotFoundException {
        ConsoleApplication consoleApplication = buildApplication();
        consoleApplication.run();
    }

    public static ConsoleApplication buildApplication() {
        TaxBracketLoader JSONTaxBracketLoader = new JSONTaxBracketLoader("src/main/java/Resources/tax_brackets.json");
        TaxCalculator taxCalculator = new MonthlyTaxCalculator(JSONTaxBracketLoader);
        PayslipGenerator payslipGenerator = new PayslipGenerator(taxCalculator);
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        ConsolePrompter consolePrompter = new ConsolePrompter(consoleIO);
        return new ConsoleApplication(payslipGenerator, consolePrompter);
    }
}
