package Application;

import Core.*;
import Core.Payslip.*;

import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        PayslipGeneratorStandard payslipGenerator = Builder.buildMonthlyPayslipGenerator();
        Runner consoleApplication = Console.Builder.buildConsoleRunner(payslipGenerator);
        consoleApplication.run();
    }

}
