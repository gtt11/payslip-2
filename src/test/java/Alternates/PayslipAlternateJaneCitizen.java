package Alternates;

import Core.Payslip.Payslip;

import java.math.BigDecimal;

public class PayslipAlternateJaneCitizen implements Payslip {

    @Override
    public String getName() {
        return "Jane Citizen";
    }

    @Override
    public String getPayPeriod() {
        return "1 December - 31 December";
    }

    @Override
    public BigDecimal getGrossIncome() {
        return new BigDecimal("6403");
    }

    @Override
    public BigDecimal getIncomeTax() {
        return new BigDecimal("1203");
    }

    @Override
    public BigDecimal getNetIncome() {
        return getGrossIncome().subtract(getIncomeTax());
    }

    @Override
    public BigDecimal getSuperannuation() {
        return new BigDecimal("498");
    }
}
