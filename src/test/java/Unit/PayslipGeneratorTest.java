package Unit;

import Alternates.TaxCalculatorAlternate;
import Core.*;
import org.junit.*;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PayslipGeneratorTest {

    private PaySlip payslip;
    private PayslipGeneratorStandard payslipGenerator;

    @Before
    public void setup() {
        TaxCalculator taxCalculator = new TaxCalculatorAlternate();
        payslipGenerator = new PayslipGeneratorStandard(taxCalculator);
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
    public void calculatesMonthlySuper_roundsDown() {
        assertThat(payslip.getSuperannuation(), is("450"));
    }

    @Test
    public void calculatesMonthlySuper_roundsUp() throws FileNotFoundException {
        Employee newEmployee = new Employee("John", "Doe", "60055", "13", "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(newEmployee);
        assertThat(payslip.getSuperannuation(), is("651"));
    }

    @Test
    public void retrievesMonthlyIncomeTax() {
        assertThat(payslip.getIncomeTax(), is("922"));
    }

    @Test
    public void calculatesNetMonthlyIncome() {
        assertThat(payslip.getNetIncome(), is("4082"));
    }

}

