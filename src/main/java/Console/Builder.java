package Console;

import Console.Reader.ConsoleReader;
import Console.Reader.ConsoleReaderStandard;
import Console.Writer.ConsoleWriter;
import Console.Writer.ConsoleWriterStandard;
import Core.Payslip.PayslipGeneratorStandard;
import Application.*;

public class Builder {

    public static Runner buildConsoleRunner(PayslipGeneratorStandard payslipGenerator) {
        ConsoleReader consoleReader = new ConsoleReaderStandard();
        ConsoleWriter consoleWriter = new ConsoleWriterStandard();
        ConsolePayslipPresenter payslipWriter = new ConsolePayslipPresenter(consoleWriter);
        ConsoleEmployeeGetter employeeGetter = new ConsoleEmployeeGetter(consoleReader, consoleWriter);
        return new Runner(employeeGetter, payslipGenerator, payslipWriter);
    }

}
