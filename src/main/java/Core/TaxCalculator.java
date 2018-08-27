package Core;

import DataStore.TaxBracketLoader;

import java.io.FileNotFoundException;


public class TaxCalculator {

    private TaxBracketLoader taxBracketLoader;

    public TaxCalculator(TaxBracketLoader taxTaxBracketLoader) {
        this.taxBracketLoader = taxTaxBracketLoader;
    }

    public int calculateMonthlyIncomeTax(float annualSalary) throws FileNotFoundException {
        TaxBracket[] taxBrackets = taxBracketLoader.getSortedTaxBrackets();
        for (int i = 0; i < taxBrackets.length; i++) {
            if (annualSalary >= taxBrackets[i].getBracketMin()) {
                return calculateMonthlyIncomeTax(taxBrackets[i], annualSalary);
            }
        }
        return 0;
    }

    private int calculateMonthlyIncomeTax(TaxBracket taxBracket, float grossIncome) {
        float totalIncomeTax = taxBracket.getBaseTax() + getMarginalTax(taxBracket, grossIncome);
        float monthlyIncomeTax = totalIncomeTax / 12;
        return Math.round(monthlyIncomeTax);
    }

    private float getMarginalTax(TaxBracket taxBracket, float grossIncome) {
        float taxableIncome = grossIncome - taxBracket.getBracketMin() + 1;
        float marginalTaxRateFraction = taxBracket.getMarginalTaxRate() / 100;
        return taxableIncome * marginalTaxRateFraction;
    }

}
