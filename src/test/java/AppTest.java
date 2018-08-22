import Console.ConsoleReaderAlternate;
import Core.EmployeeDetailGetter;
import Console.ConsoleWriterAlternate;
import Core.PayslipPresenter;
import Core.PayslipGenerator;
import Core.Prompter;
import TaxCalculator.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest {

    @Test
    public void createApplication() {
        EmployeeDetailGetter consoleReader = new ConsoleReaderAlternate();

        PayslipPresenter consoleWriter = new ConsoleWriterAlternate();

        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);

        PayslipGenerator payslipGenerator = new PayslipGenerator(newTaxCalculator);

        Prompter newPrompter = new Prompter(consoleReader, consoleWriter, payslipGenerator);

        newPrompter.runApplication();

        assertThat(consoleWriter.hasOutputPayslip(), is(true));

    }
}
