package Unit;

import Alternates.*;
import Core.Employee.*;
import Core.Payslip.Payslip;
import Core.Payslip.PayslipGeneratorStandard;
import Core.Tax.TaxCalculator;
import org.junit.*;

import java.math.BigDecimal;

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
    public void concatenatesPayPeriod_DefaultEmployee() {
        preparePayslip_DefaultEmployee();
        assertThat(payslip.getPayPeriod(), is("1 March - 31 March"));
    }

    @Test
    public void concatenatesPayPeriod_AlternateEmployee() {
        preparePayslip_AlternateEmployee();
        assertThat(payslip.getPayPeriod(), is("1 August - 31 August"));
    }

    @Test
    public void calculatesGrossMonthlyIncome_RoundsDown_DefaultEmployee() {
        preparePayslip_DefaultEmployee();
        assertThat(payslip.getGrossIncome().toString(), is("5004"));
    }

    @Test
    public void calculatesGrossMonthlyIncome_RoundsUp_AlternateEmployee() {
        preparePayslip_AlternateEmployee();
        assertThat(payslip.getGrossIncome().toString(), is("5045"));
    }

    @Test
    public void retrievesMonthlyIncomeTax() {
        preparePayslip_DefaultEmployee();
        assertThat(payslip.getIncomeTax().toString(), is("922"));
    }

    @Test
    public void calculatesNetMonthlyIncome_DefaultEmployee() {
        preparePayslip_DefaultEmployee();
        assertThat(payslip.getNetIncome().toString(), is("4082"));
    }

    @Test
    public void calculatesNetMonthlyIncome_AlternateEmployee() {
        preparePayslip_AlternateEmployee();
        assertThat(payslip.getNetIncome().toString(), is("4123"));
    }

    @Test
    public void calculatesMonthlySuper_RoundsDown_DefaultEmployee() {
        preparePayslip_DefaultEmployee();
        assertThat(payslip.getSuperannuation().toString(), is("450"));
    }

    @Test
    public void calculatesMonthlySuper_RoundsUp_AlternateEmployee() {
        preparePayslip_AlternateEmployee();
        assertThat(payslip.getSuperannuation().toString(), is("530"));
    }

    private void preparePayslip_DefaultEmployee() {
        BigDecimal salary = new BigDecimal("60050");
        BigDecimal superRate = new BigDecimal("9");
        Employee employee = new Employee("John", "Doe", salary, superRate, "1 March", "31 March");
        payslip = payslipGenerator.getPayslip(employee);
    }

    private void preparePayslip_AlternateEmployee() {
        BigDecimal salary = new BigDecimal("60535");
        BigDecimal superRate = new BigDecimal("10.5");
        Employee employee = new Employee("Jane", "Citizen", salary, superRate, "1 August", "31 August");
        payslip = payslipGenerator.getPayslip(employee);
    }

}

