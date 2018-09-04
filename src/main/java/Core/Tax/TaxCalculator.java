package Core.Tax;

import java.math.BigDecimal;

public interface TaxCalculator {

    BigDecimal calculateIncomeTax(BigDecimal grossIncome);

    BigDecimal getAnnualPayPeriods();

}
