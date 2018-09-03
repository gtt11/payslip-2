package Core.Payslip;

import java.math.BigDecimal;

public class PayslipStandard implements Payslip {

    private String name;
    private String payPeriod;
    private BigDecimal grossIncome;
    private BigDecimal incomeTax;
    private BigDecimal netIncome;
    private BigDecimal superannuation;

    public PayslipStandard(String name, String payPeriod, BigDecimal grossIncome, BigDecimal incomeTax, BigDecimal netIncome, BigDecimal superannuation) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superannuation = superannuation;
    }

    public String getName() {
        return name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public BigDecimal getGrossIncome() {
        return grossIncome;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getSuperannuation() {
        return superannuation;
    }
}
