import Core.*;
import TaxCalculator.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaySlipTest {

    private PaySlip payslip;
    private PayslipGenerator payslipGenerator;

    @Before
    public void setup() {
        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);
        payslipGenerator = new PayslipGenerator(newTaxCalculator);
        Employee newEmployee = new Employee("John", "Doe", "60050", "9", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
    }

    @Test
    public void getsFullName() {
        assertThat(payslip.getName(), is("John Doe"));
    }

    @Test
    public void concatenatesPayPeriod() {
        assertThat(payslip.getPayPeriod(), is("1 March - 31 March"));
    }

    @Test
    public void calculatesGrossMonthlyIncome_roundsDown() {
        assertThat(payslip.getGrossIncome(), is("5004"));
    }

    @Test
    public void calculatesGrossMonthlyIncome_roundsUp() {
        Employee newEmployee = new Employee("John", "Doe", "60055", "9", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
        assertThat(payslip.getGrossIncome(), is("5005"));
    }

    @Test
    public void calculatesMonthlySuperannnuation_roundsDown() {
        assertThat(payslip.getSuperannuation(), is("450"));
    }

    @Test
    public void calculatesMonthlySuperannnuation_roundsUp() {
        Employee newEmployee = new Employee("John", "Doe", "60055", "13", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
        assertThat(payslip.getSuperannuation(), is("651"));
    }

}

