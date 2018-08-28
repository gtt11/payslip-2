import Core.TaxBracket;
import DataStore.JSONTaxBracketLoader;
import org.junit.*;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
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
        assertThat(taxBrackets[4].getBracketMin(), is(0F));
        assertThat(taxBrackets[3].getBracketMin(), is(18201F));
        assertThat(taxBrackets[2].getBaseTax(), is(3572F));
        assertThat(taxBrackets[1].getMarginalTaxRate(), is(37F));
        assertThat(taxBrackets[0].getMarginalTaxRate(), is(45F));
    }
}
