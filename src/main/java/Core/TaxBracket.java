package Core;

public class TaxBracket {
    private String bracketMin;
    private String bracketMax;
    private String baseTax;
    private String marginalTaxRate;

    public TaxBracket(String bracketMin, String bracketMax, String baseTax, String marginalTaxRate) {
        this.bracketMin = bracketMin;
        this.bracketMax = bracketMax;
        this.baseTax = baseTax;
        this.marginalTaxRate = marginalTaxRate;
    }

    public int getBracketMin() {
        return Integer.parseInt(bracketMin);
    }

    public int getBracketMax() {
        return Integer.parseInt(bracketMax);
    }

    public int getBaseTax() {
        return Integer.parseInt(baseTax);
    }

    public int getMarginalTaxRate() {
        return Integer.parseInt(marginalTaxRate);
    }

}
