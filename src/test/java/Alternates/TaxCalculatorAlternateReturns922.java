package Alternates;

import Core.Tax.TaxCalculator;

import java.math.BigDecimal;

public class TaxCalculatorAlternateReturns922 implements TaxCalculator {

    @Override
    public BigDecimal calculateIncomeTax(BigDecimal annualSalary) {
        return new BigDecimal("922");
    }

    @Override
    public BigDecimal getPayPeriodDivisor() {
        return new BigDecimal("12");
    }
}
