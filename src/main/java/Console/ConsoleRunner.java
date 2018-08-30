package Console;

import Core.*;

import java.io.FileNotFoundException;

public class ConsoleRunner {

    private PayslipGenerator payslipGenerator;
    private UserInterface userInterface;

    public ConsoleRunner(PayslipGenerator payslipGenerator, UserInterface userInterface) {
        this.payslipGenerator = payslipGenerator;
        this.userInterface = userInterface;
    }

    public void run() throws FileNotFoundException {
        Employee employee = userInterface.getEmployee();
        PaySlip payslip = payslipGenerator.getPayslip(employee);
        userInterface.outputPayslip(payslip);
    }

}
