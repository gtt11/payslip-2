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
        Validator validator = new Validator(50);
        ConsoleEmployeeGetter employeeGetter = new ConsoleEmployeeGetter(consoleReader, consoleWriter, validator);
        return new Runner(employeeGetter, payslipGenerator, payslipWriter);
    }

}
