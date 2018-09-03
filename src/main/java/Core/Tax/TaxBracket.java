package Core.Tax;

import java.math.BigDecimal;

public class TaxBracket implements Comparable<TaxBracket> {

    private BigDecimal bracketMin;
    private BigDecimal baseTax;
    private BigDecimal marginalTaxBracket;

    public TaxBracket(String bracketMin, String baseTax, String marginalTaxBracket) {
        this.bracketMin = new BigDecimal(bracketMin);
        this.baseTax = new BigDecimal(baseTax);
        this.marginalTaxBracket = new BigDecimal(marginalTaxBracket);
    }

    public BigDecimal getBracketMin() {
        return bracketMin;
    }

    public BigDecimal getBaseTax() {
        return baseTax;
    }

    public BigDecimal getMarginalTaxRate() {
        return marginalTaxBracket;
    }

    // allows TaxBrackets to be sorted from highest to lowest income minimum

    @Override
    public int compareTo(TaxBracket taxBracket) {
        return taxBracket.getBracketMin().compareTo(getBracketMin());
    }

}
