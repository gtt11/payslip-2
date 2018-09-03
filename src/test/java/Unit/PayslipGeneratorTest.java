package Unit;

import Alternates.*;
import Core.Employee.Employee;
import Core.Payslip.Payslip;
import Core.Payslip.PayslipGeneratorStandard;
import Core.Tax.TaxCalculator;
import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PayslipGeneratorTest {

    private Payslip payslip;
    private PayslipGeneratorStandard payslipGenerator;

    @Before
    public void setup() {
        TaxCalculator taxCalculator = new TaxCalculatorAlternateReturns922();
        payslipGenerator = new PayslipGeneratorStandard(taxCalculator);
    }

    @Test
    public void concatenatesPayPeriod_JohnDoe() {
        preparePayslip_JohnDoe();
        assertThat(payslip.getPayPeriod(), is("1 March - 31 March"));
    }

    @Test
    public void concatenatesPayPeriod_JaneCitizen() {
        preparePayslip_JaneCitizen();
        assertThat(payslip.getPayPeriod(), is("1 August - 31 August"));
    }

    @Test
    public void calculatesGrossMonthlyIncome_RoundsDown_JohnDoe() {
        preparePayslip_JohnDoe();
        assertThat(payslip.getGrossIncome().toString(), is("5004"));
    }

    @Test
    public void calculatesGrossMonthlyIncome_RoundsUp_JaneCitizen() {
        preparePayslip_JaneCitizen();
        assertThat(payslip.getGrossIncome().toString(), is("5045"));
    }

    @Test
    public void retrievesMonthlyIncomeTax() {
        preparePayslip_JohnDoe();
        assertThat(payslip.getIncomeTax().toString(), is("922"));
    }

    @Test
    public void calculatesNetMonthlyIncome_JohnDoe() {
        preparePayslip_JohnDoe();
        assertThat(payslip.getNetIncome().toString(), is("4082"));
    }

    @Test
    public void calculatesNetMonthlyIncome_JaneCitizen() {
        preparePayslip_JaneCitizen();
        assertThat(payslip.getNetIncome().toString(), is("4123"));
    }

    @Test
    public void calculatesMonthlySuper_RoundsDown_JohnDoe() {
        preparePayslip_JohnDoe();
        assertThat(payslip.getSuperannuation().toString(), is("450"));
    }

    @Test
    public void calculatesMonthlySuper_RoundsUp_JaneCitizen() {
        preparePayslip_JaneCitizen();
        assertThat(payslip.getSuperannuation().toString(), is("530"));
    }

    private void preparePayslip_JohnDoe() {
        Employee employee = new EmployeeAlternateJohnDoe();
        payslip = payslipGenerator.getPayslip(employee);
    }

    private void preparePayslip_JaneCitizen() {
        Employee employee = new EmployeeAlternateJaneCitizen();
        payslip = payslipGenerator.getPayslip(employee);
    }

}

