import Alternates.ConsoleReaderAlternate;
import Alternates.ConsoleWriterAlternate;
import Core.*;
import DataStore.JSONTaxBracketLoader;
import DataStore.TaxBracketLoader;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest {

    @Test
    public void acceptanceTest() throws FileNotFoundException {

        // Arrange
        EmployeeDetailGetter consoleReader = new ConsoleReaderAlternate();
        ConsoleWriterAlternate consoleWriter = new ConsoleWriterAlternate();
        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new TaxCalculator(taxTaxBracketLoader);
        PayslipGenerator payslipGenerator = new PayslipGenerator(newTaxCalculator);
        Application newPrompter = new Application(consoleReader, consoleWriter, payslipGenerator);

        // Act
        newPrompter.runApplication();
        PaySlip paySlip = consoleWriter.getPayslip();

        // Assert
        assertThat(paySlip.getName(), is("John Doe"));
        assertThat(paySlip.getPayPeriod(), is("01 March – 31 March"));
        assertThat(paySlip.getGrossIncome(), is("5004"));
        assertThat(paySlip.getIncomeTax(), is("922"));
        assertThat(paySlip.getNetIncome(), is("4082"));
        assertThat(paySlip.getSuperannuation(), is("450"));

    }

}
