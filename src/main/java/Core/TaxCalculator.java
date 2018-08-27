package Core;

import DataStore.TaxBracketLoader;

import java.io.FileNotFoundException;


public class TaxCalculator {

    private TaxBracketLoader taxBracketLoader;

    public TaxCalculator(TaxBracketLoader taxTaxBracketLoader) {
        this.taxBracketLoader = taxTaxBracketLoader;
    }

    public int getIncomeTax(int grossIncome) throws FileNotFoundException {
        TaxBracket[] taxBrackets = taxBracketLoader.getSortedTaxBrackets();
        for (int i = 0; i < taxBrackets.length; i++) {
            if (grossIncome >= taxBrackets[i].getBracketMin()) {
                return calculateIncomeTax(taxBrackets[i], grossIncome);
            }
        }
        return 0;
    }

    private int calculateIncomeTax(TaxBracket taxBracket, int grossIncome) {
        float totalIncomeTax = taxBracket.getBaseTax() + getMarginalTax(taxBracket, grossIncome);
        return Math.round(totalIncomeTax);
    }

    private float getMarginalTax(TaxBracket taxBracket, int grossIncome) {
        float taxableIncome = grossIncome - taxBracket.getBracketMin();
        float marginalTaxRateFraction = taxBracket.getMarginalTaxRate() / 100;
        return taxableIncome * marginalTaxRateFraction;
    }

}
