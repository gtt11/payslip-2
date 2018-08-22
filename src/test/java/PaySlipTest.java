import Core.*;
import TaxCalculator.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaySlipTest {

    private PayslipGenerator payslipGenerator;

    @Before
    public void setup() {
        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);
        payslipGenerator = new PayslipGenerator(newTaxCalculator);
    }

    @Test
    public void concatenatesFullName() {
        Employee newEmployee = new Employee("John", "Doe", "60050", "9", "1 March", "31 March");
        PaySlip payslip = payslipGenerator.getPayslip(newEmployee);
        assertThat(payslip.getName(), is("John Doe"));
    }


}

