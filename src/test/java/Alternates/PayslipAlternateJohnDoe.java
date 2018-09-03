package Alternates;

import Core.Payslip.Payslip;

import java.math.BigDecimal;

public class PayslipAlternateJohnDoe implements Payslip {

    @Override
    public String getName() {
        return "John Doe";
    }

    @Override
    public String getPayPeriod() {
        return "01 March - 31 March";
    }

    @Override
    public BigDecimal getGrossIncome() {
        return new BigDecimal("5004");
    }

    @Override
    public BigDecimal getIncomeTax() {
        return new BigDecimal("922");
    }

    @Override
    public BigDecimal getNetIncome() {
        return getGrossIncome().subtract(getIncomeTax());
    }

    @Override
    public BigDecimal getSuperannuation() {
        return new BigDecimal("450");
    }

}
