package DataStore;

import Core.TaxBracket;

import java.io.FileNotFoundException;

public interface TaxBracketLoader {

    TaxBracket[] getSortedTaxBrackets() throws FileNotFoundException;

}
