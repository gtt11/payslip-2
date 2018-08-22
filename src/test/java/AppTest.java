import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest {

    @Test
    public void createApplication() {
        EmployeeDetailGenerator consoleReader = new ConsoleReader();
        PayslipOutputGenerator consoleWriter = new ConsoleWriter();

        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);

        SuperannuationCalculator newSuperCalculator = new SuperannuationCalculator();

        Prompter newPrompter = new Prompter(consoleReader, consoleWriter, newTaxCalculator, newSuperCalculator);

        newPrompter.runApplication();

        assertThat(consoleWriter.hasOutputPayslip(), is(true));

    }
}
