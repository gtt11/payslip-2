import Alternates.ConsoleApplicationAlternate;
import Core.*;
import DataStore.*;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoreTest {

    @Test
    public void coreTest_JohnDoe() throws FileNotFoundException {

        // Arrange
        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new MonthlyTaxCalculator(taxTaxBracketLoader);
        PayslipGenerator payslipGenerator = new PayslipGenerator(newTaxCalculator);
        ConsoleApplicationAlternate consoleApplication = new ConsoleApplicationAlternate(payslipGenerator);

        // Act
        PaySlip paySlip = consoleApplication.getPayslip();

        // Assert
        assertThat(paySlip.getName(), is("John Doe"));
        assertThat(paySlip.getPayPeriod(), is("01 March - 31 March"));
        assertThat(paySlip.getGrossIncome(), is("5004"));
        assertThat(paySlip.getIncomeTax(), is("922"));
        assertThat(paySlip.getNetIncome(), is("4082"));
        assertThat(paySlip.getSuperannuation(), is("450"));
    }

}
