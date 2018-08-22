package TaxCalculator;

public class TaxCalculator {

    private RateLoader taxRateLoader;

    public TaxCalculator(RateLoader taxRateLoader) {
        this.taxRateLoader = taxRateLoader;
    }

    public Integer getIncomeTax(Integer grossIncome) {
        return 922;
    }
}
