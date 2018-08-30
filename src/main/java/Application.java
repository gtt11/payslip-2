import Console.Runner;
import Core.Builder;
import Core.PayslipGeneratorStandard;

import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        PayslipGeneratorStandard payslipGenerator = Builder.buildMonthlyPayslipGenerator();
        Runner consoleApplication = Console.Builder.buildConsoleRunner(payslipGenerator);
        consoleApplication.run();
    }

}
