import Core.TaxCalculator;import DataStore.JSONTaxBracketLoader;
import
 org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaxCalculatorTest {

    private final String alternateFilePath = "src/test/java/Alternates/tax_brackets_alternate.json";
    private TaxCalculator taxCalculator;

    @Before
    public void setup() {
        JSONTaxBracketLoader taxLoader = new JSONTaxBracketLoader(alternateFilePath);
        taxCalculator = new TaxCalculator(taxLoader);
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForLowestBracket() throws FileNotFoundException {
        assertMonthlyTaxOnAnnualIncome(5000, 0);
        assertMonthlyTaxOnAnnualIncome(18200, 0);
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForSecondTaxBracket() throws FileNotFoundException {
        assertMonthlyTaxOnAnnualIncome(18201, 0);
        assertMonthlyTaxOnAnnualIncome(18203, 0);
        assertMonthlyTaxOnAnnualIncome(37000, 298);
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForThirdTaxBracket() throws FileNotFoundException {
        assertMonthlyTaxOnAnnualIncome(37001, 298);
        assertMonthlyTaxOnAnnualIncome(60050, 922);
        assertMonthlyTaxOnAnnualIncome(90000, 1733);
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForFourthTaxBracket() throws FileNotFoundException {
        assertMonthlyTaxOnAnnualIncome(90024, 1734);
        assertMonthlyTaxOnAnnualIncome(143012, 3368);
        assertMonthlyTaxOnAnnualIncome(180000, 4508);
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForHighestTaxBracket() throws FileNotFoundException {
        assertMonthlyTaxOnAnnualIncome(180024, 4509);
        assertMonthlyTaxOnAnnualIncome(250000, 7133);
    }

    private void assertMonthlyTaxOnAnnualIncome(int annualSalary, int expectedTax) throws FileNotFoundException {
        int incomeTax = taxCalculator.getMonthlyIncomeTax(annualSalary);
        assertThat(incomeTax, is(expectedTax));
    }
}
