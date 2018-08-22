import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest {

    @Test
    public void createApplication() {
        EmployeeDetailGenerator consoleReader = new ConsoleReader();

        PayslipPresenter consoleWriter = new ConsoleWriter();

        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);

        PayslipGenerator payslipGenerator = new PayslipGenerator(newTaxCalculator);

        Prompter newPrompter = new Prompter(consoleReader, consoleWriter, payslipGenerator);

        newPrompter.runApplication();

        assertThat(consoleWriter.hasOutputPayslip(), is(true));

    }
}
