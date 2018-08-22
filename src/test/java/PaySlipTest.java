import Core.*;
import TaxCalculator.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaySlipTest {

    private PaySlip payslip;

    @Before
    public void setup() {
        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);
        PayslipGenerator payslipGenerator = new PayslipGenerator(newTaxCalculator);
        Employee newEmployee = new Employee("John", "Doe", "60050", "9", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
    }

    @Test
    public void concatenatesFullName() {
        assertThat(payslip.getName(), is("John Doe"));
    }

    @Test
    public void concatenatesPayPeriod() {
        assertThat(payslip.getPayPeriod(), is("1 March - 31 March"));
    }


}

