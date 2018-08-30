package Core;

import DataStore.*;

import java.io.FileNotFoundException;

public class Builder {

    public static PayslipGeneratorStandard buildMonthlyPayslipGenerator() throws FileNotFoundException {
        TaxBracketLoader JSONTaxBracketLoader = new JSONTaxBracketLoader("src/main/java/Resources/tax_brackets.json");
        TaxCalculator taxCalculator = new MonthlyTaxCalculator(JSONTaxBracketLoader);
        return new PayslipGeneratorStandard(taxCalculator);
    }

}
