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

        Prompter newPrompter = new Prompter(consoleReader, consoleWriter, newTaxCalculator);

        newPrompter.runApplication();

        assertThat(consoleWriter.hasOutputPayslip(), is(true));

    }
}
