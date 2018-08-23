package DataStore;

import Core.TaxBracket;

import java.io.FileNotFoundException;

public interface RateLoader {

    TaxBracket[] getTaxRates() throws FileNotFoundException;

}
