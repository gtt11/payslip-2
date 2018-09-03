package Core.Payslip;

import java.math.BigDecimal;

public interface Payslip {

    String getName();

    String getPayPeriod();

    BigDecimal getGrossIncome();

    BigDecimal getIncomeTax();

    BigDecimal getNetIncome();

    BigDecimal getSuperannuation();

}
