package Core;

public class TaxBracket implements Comparable<TaxBracket> {
    private float bracketMin;
    private float baseTax;
    private float marginalTaxBracket;

    public TaxBracket(String bracketMin, String baseTax, String marginalTaxBracket) {
        this.bracketMin = Float.parseFloat(bracketMin);
        this.baseTax = Float.parseFloat(baseTax);
        this.marginalTaxBracket = Float.parseFloat(marginalTaxBracket);
    }

    public float getBracketMin() {
        return bracketMin;
    }

    public float getBaseTax() {
        return baseTax;
    }

    public float getMarginalTaxRate() {
        return marginalTaxBracket;
    }

    @Override
    public int compareTo(TaxBracket taxBracket) {
        return Float.compare(taxBracket.getBracketMin(), getBracketMin());
    }
}
