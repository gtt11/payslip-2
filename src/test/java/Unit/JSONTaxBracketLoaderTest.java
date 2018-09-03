package Unit;

import Core.Tax.TaxBracket;
import DataStore.JSONTaxBracketLoader;
import org.junit.*;

import java.io.FileNotFoundException;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JSONTaxBracketLoaderTest {

    private final String alternateFilePath = "src/test/java/Alternates/tax_brackets_alternate.json";
    private TaxBracket[] taxBrackets;

    @Before
    public void setup() throws FileNotFoundException {
        JSONTaxBracketLoader taxLoader = new JSONTaxBracketLoader(alternateFilePath);
        taxBrackets = taxLoader.getSortedTaxBrackets();
    }

    @Test
    public void parsesJSONTaxBrackets_returnsArrayOfTaxBrackets() {
        assertThat(taxBrackets.length, is(5));
    }

    @Test
    public void returnsArrayOfTaxBrackets_sortedFromHighestToLowestIncome() {
        assertTaxBracketMinimum("180001", taxBrackets[0]);
        assertTaxBracketMinimum("90001", taxBrackets[1]);
        assertTaxBracketMinimum("37001", taxBrackets[2]);
        assertTaxBracketMinimum("18201", taxBrackets[3]);
        assertTaxBracketMinimum("0", taxBrackets[4]);
    }

    private void assertTaxBracketMinimum(String expectedValue, TaxBracket taxBracket) {
        String taxBracketMin = taxBracket.getBracketMin().setScale(0, RoundingMode.HALF_UP).toString();
        assertEquals(expectedValue, taxBracketMin);
    }
}
