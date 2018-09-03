package Unit;

import Core.Tax.MonthlyTaxCalculator;
import Core.Tax.TaxCalculator;
import DataStore.JSONTaxBracketLoader;
import org.junit.*;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class TaxCalculatorTest {

    private final String alternateFilePath = "src/test/java/Alternates/tax_brackets_alternate.json";
    private TaxCalculator taxCalculator;

    @Before
    public void setup() throws FileNotFoundException {
        JSONTaxBracketLoader taxLoader = new JSONTaxBracketLoader(alternateFilePath);
        taxCalculator = new MonthlyTaxCalculator(taxLoader);
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForLowestBracket_5000() {
        assertMonthlyTaxOnAnnualIncome("5000", "0");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForLowestBracket_18200() {
        assertMonthlyTaxOnAnnualIncome("18200", "0");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForSecondTaxBracket_18201() {
        assertMonthlyTaxOnAnnualIncome("18201", "0");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForSecondTaxBracket_18203() {
        assertMonthlyTaxOnAnnualIncome("18203", "0");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForSecondTaxBracket_37000() {
        assertMonthlyTaxOnAnnualIncome("37000", "298");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForThirdTaxBracket_37001() {
        assertMonthlyTaxOnAnnualIncome("37034", "299");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForThirdTaxBracket_60050() {
        assertMonthlyTaxOnAnnualIncome("60050", "922");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForThirdTaxBracket_90000() {
        assertMonthlyTaxOnAnnualIncome("90000", "1733");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForFourthTaxBracket_90024() {
        assertMonthlyTaxOnAnnualIncome("90024", "1734");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForFourthTaxBracket_143012() {
        assertMonthlyTaxOnAnnualIncome("143012", "3368");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForFourthTaxBracket_180000() {
        assertMonthlyTaxOnAnnualIncome("180000", "4508");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForHighestTaxBracket_180024() {
        assertMonthlyTaxOnAnnualIncome("180024", "4509");
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForHighestTaxBracket_250000() {
        assertMonthlyTaxOnAnnualIncome("250000", "7133");
    }

    private void assertMonthlyTaxOnAnnualIncome(String annualSalary, String expectedTax) {
        String incomeTax = taxCalculator.calculateIncomeTax(new BigDecimal(annualSalary)).toString();
        assertEquals(expectedTax, incomeTax);
    }
}
