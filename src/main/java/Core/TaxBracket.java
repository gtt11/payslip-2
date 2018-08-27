package Core;

public class TaxBracket implements Comparable<TaxBracket> {
    private float bracketMin;
    private float bracketMax;
    private float baseTax;
    private float marginalTaxBracket;

    public TaxBracket(String bracketMin, String bracketMax, String baseTax, String marginalTaxBracket) {
        this.bracketMin = Float.parseFloat(bracketMin);
        this.bracketMax = Float.parseFloat(bracketMax);
        this.baseTax = Float.parseFloat(baseTax);
        this.marginalTaxBracket = Float.parseFloat(marginalTaxBracket);
    }

    public float getBracketMin() {
        return bracketMin;
    }

    public float getBracketMax() {
        return bracketMax;
    }

    public float getBaseTax() {
        return baseTax;
    }

    public float getMarginalTaxRate() {
        return marginalTaxBracket;
    }

    @Override
    public int compareTo(TaxBracket o) {
        return Float.compare(o.getBracketMin(), getBracketMin());
    }
}
