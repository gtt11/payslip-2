package DataStore;

import Core.Tax.TaxBracket;
import com.google.gson.Gson;

import java.io.*;
import java.util.Arrays;

public class JSONTaxBracketLoader implements TaxBracketLoader {

    private String filePath;

    public JSONTaxBracketLoader(String filePath) {
        this.filePath = filePath;
    }

    public TaxBracket[] getSortedTaxBrackets() throws FileNotFoundException {
        TaxBracket[] taxRates = deserialiseJSON();
        Arrays.sort(taxRates);
        return taxRates;
    }

    private TaxBracket[] deserialiseJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(filePath), TaxBracket[].class);
    }

}
