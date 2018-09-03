package Integration;

import Core.Employee.*;
import Core.Payslip.*;
import Core.Tax.*;
import DataStore.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoreTest {

    PayslipGenerator payslipGenerator;

    @Before
    public void setup() throws FileNotFoundException {
        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new MonthlyTaxCalculator(taxTaxBracketLoader);
        payslipGenerator = new PayslipGeneratorStandard(newTaxCalculator);
    }

    @Test
    public void coreTest_JohnDoe() {

        // Arrange
        BigDecimal salary = new BigDecimal("60050");
        BigDecimal superRate = new BigDecimal("9");
        Employee employee = new Employee("John", "Doe", salary, superRate, "1 March", "31 March");

        // Act
        Payslip paySlip = payslipGenerator.getPayslip(employee);

        // Assert
        assertThat(paySlip.getName(), is("John Doe"));
        assertThat(paySlip.getPayPeriod(), is("1 March - 31 March"));
        assertThat(paySlip.getGrossIncome().toString(), is("5004"));
        assertThat(paySlip.getIncomeTax().toString(), is("922"));
        assertThat(paySlip.getSuperannuation().toString(), is("450"));

    }

    @Test
    public void coreTest_JaneCitizen() {

        // Arrange
        BigDecimal salary = new BigDecimal("60535");
        BigDecimal superRate = new BigDecimal("10.5");
        Employee employee = new Employee("Jane", "Citizen", salary, superRate, "1 August", "31 August");

        // Act
        Payslip paySlip = payslipGenerator.getPayslip(employee);

        // Assert
        assertThat(paySlip.getName(), is("Jane Citizen"));
        assertThat(paySlip.getPayPeriod(), is("1 August - 31 August"));
        assertThat(paySlip.getGrossIncome().toString(), is("5045"));
        assertThat(paySlip.getIncomeTax().toString(), is("935"));
        assertThat(paySlip.getNetIncome().toString(), is("4110"));
        assertThat(paySlip.getSuperannuation().toString(), is("530"));

    }

}
