import Core.TaxCalculator;
import DataStore.JSONTaxBracketLoader;
import org.junit.Before;
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
        assertTaxOnGrossIncome(18200, 0);
    }

    @Test
    public void taxCalculatorTest_returnsIncomeTaxForSecondTaxBracket() throws FileNotFoundException {
        assertTaxOnGrossIncome(37000, 3572);
    }

    private void assertTaxOnGrossIncome(int grossIncome, int expectedTax) throws FileNotFoundException {
        int incomeTax = taxCalculator.getIncomeTax(grossIncome);
        assertThat(incomeTax, is(expectedTax));
    }
}
