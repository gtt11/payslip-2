package Core.Tax;

import DataStore.TaxBracketLoader;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MonthlyTaxCalculator implements TaxCalculator {

    private TaxBracketLoader taxBracketLoader;
    private TaxBracket[] taxBrackets;
    private final int quotientScale = 0;
    private final String payPeriodDivisor = "12";

    public MonthlyTaxCalculator(TaxBracketLoader taxTaxBracketLoader) throws FileNotFoundException {
        this.taxBracketLoader = taxTaxBracketLoader;
        taxBrackets = taxBracketLoader.getSortedTaxBrackets();
    }

    public BigDecimal getPayPeriodDivisor() {
        return new BigDecimal(payPeriodDivisor);
    }

    public BigDecimal calculateIncomeTax(BigDecimal annualSalary) {
        for (int i = 0; i < taxBrackets.length; i++) {
            if (taxBracketApplies(annualSalary, taxBrackets[i])) {
                return applyTaxBracket(annualSalary, taxBrackets[i]);
            }
        }
        return new BigDecimal("0");
    }

    private boolean taxBracketApplies(BigDecimal annualSalary, TaxBracket taxBracket) {
        return annualSalary.compareTo(taxBracket.getBracketMin()) >= 0;
    }

    private BigDecimal applyTaxBracket(BigDecimal grossIncome, TaxBracket taxBracket) {
        BigDecimal baseTax = taxBracket.getBaseTax();
        BigDecimal marginalTax = getMarginalTax(grossIncome, taxBracket);
        BigDecimal totalIncomeTax = baseTax.add(marginalTax);
        BigDecimal monthlyIncomeTax = totalIncomeTax.divide(getPayPeriodDivisor(), quotientScale, RoundingMode.HALF_UP);
        return monthlyIncomeTax;
    }

    private BigDecimal getMarginalTax(BigDecimal grossIncome, TaxBracket taxBracket) {
        BigDecimal taxableIncome = grossIncome.subtract(taxBracket.getBracketMin()).add(new BigDecimal("1"));
        BigDecimal marginalTaxRate = taxBracket.getMarginalTaxRate();
        return taxableIncome.multiply(marginalTaxRate).divide(new BigDecimal("100"), quotientScale, RoundingMode.HALF_UP);
    }

}
