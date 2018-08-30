package Console;

import Core.PayslipGeneratorStandard;

public class Builder {

    public static Runner buildConsoleRunner(PayslipGeneratorStandard payslipGenerator) {
        ConsoleReader consoleReader = new ConsoleReader(System.in);
        ConsoleWriter consoleWriter = new ConsoleWriter(System.out);
        PayslipWriter payslipWriter = new PayslipWriter(consoleWriter);
        EmployeeGetter employeeGetter = new EmployeeGetter(consoleReader, consoleWriter);
        return new Runner(employeeGetter, payslipGenerator, payslipWriter);
    }

}
