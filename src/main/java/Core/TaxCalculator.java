package Core;

import java.io.FileNotFoundException;

public interface TaxCalculator {

    int calculateIncomeTax(float grossIncome) throws FileNotFoundException;

}
