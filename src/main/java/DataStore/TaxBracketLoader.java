package DataStore;

import Core.Tax.TaxBracket;

import java.io.FileNotFoundException;

public interface TaxBracketLoader {

    TaxBracket[] getSortedTaxBrackets() throws FileNotFoundException;

}
