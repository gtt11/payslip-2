import Core.*;
import DataStore.JSONTaxBracketLoader;
import DataStore.TaxBracketLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaySlipTest {

    private PaySlip payslip;
    private PayslipGenerator payslipGenerator;

    @Before
    public void setup() throws FileNotFoundException {
        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new TaxCalculator(taxTaxBracketLoader);
        payslipGenerator = new PayslipGenerator(newTaxCalculator);
        Employee newEmployee = new Employee("John", "Doe", "60050", "9", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
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
    public void calculatesGrossMonthlyIncome_roundsUp() throws FileNotFoundException {
        Employee newEmployee = new Employee("John", "Doe", "60055", "9", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
        assertThat(payslip.getGrossIncome(), is("5005"));
    }

    @Test
    public void calculatesMonthlySuperannnuation_roundsDown() {
        assertThat(payslip.getSuperannuation(), is("450"));
    }

    @Test
    public void calculatesMonthlySuperannnuation_roundsUp() throws FileNotFoundException {
        Employee newEmployee = new Employee("John", "Doe", "60055", "13", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
        assertThat(payslip.getSuperannuation(), is("651"));
    }

}

