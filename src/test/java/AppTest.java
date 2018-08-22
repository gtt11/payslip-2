import Console.ConsoleReaderAlternate;
import Core.*;
import Console.ConsoleWriterAlternate;
import TaxCalculator.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest {

    @Test
    public void acceptanceTest() {

        // Arrange
        EmployeeDetailGetter consoleReader = new ConsoleReaderAlternate();
        PayslipPresenter consoleWriter = new ConsoleWriterAlternate();
        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);
        PayslipGenerator payslipGenerator = new PayslipGenerator(newTaxCalculator);
        Prompter newPrompter = new Prompter(consoleReader, consoleWriter, payslipGenerator);

        // Act
        newPrompter.runApplication();
        PaySlip paySlip = ((ConsoleWriterAlternate) consoleWriter).getPayslip();

        // Assert
        assertThat(paySlip.getName(), is("John Doe"));
        assertThat(paySlip.getPayPeriod(), is("01 March – 31 March"));
        assertThat(paySlip.getGrossIncome(), is("5004"));
        assertThat(paySlip.getIncomeTax(), is("922"));
        assertThat(paySlip.getNetIncome(), is("4082"));
        assertThat(paySlip.getSuperannuation(), is("450"));

    }

}
