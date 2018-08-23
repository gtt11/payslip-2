package DataStore;

import Core.TaxBracket;
import com.google.gson.Gson;

import java.io.*;

public class JSONTaxRateLoader implements RateLoader {

    private String filePath;

    public JSONTaxRateLoader(String filePath) {
        this.filePath = filePath;
    }

    public TaxBracket[] getTaxRates() throws FileNotFoundException {
        Gson gson = new Gson();
        TaxBracket[] taxRates = gson.fromJson(new FileReader(filePath), TaxBracket[].class);
        return taxRates;
    }

}
