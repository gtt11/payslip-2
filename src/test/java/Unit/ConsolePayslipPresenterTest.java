package Unit;

import Alternates.*;
import Console.*;
import Core.Payslip.Payslip;
import Core.Payslip.PayslipPresenter;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class ConsolePayslipPresenterTest {

    ConsoleWriterAlternateSavesOutput consoleWriter;
    PayslipPresenter payslipPresenter;

    @Before
    public void setUp() {
        consoleWriter = new ConsoleWriterAlternateSavesOutput();
        payslipPresenter = new ConsolePayslipPresenter(consoleWriter);
    }

    @Test
    public void consoleOutputsEmployeeName_FromProvidedPaySlip_JohnDoe() {
        outputPayslipJohnDoe();
        assertConsoleOutput("Name: John Doe");
    }

    @Test
    public void consoleOutputsPayDateRange_FromProvidedPaySlip_JohnDoe() {
        outputPayslipJohnDoe();
        assertConsoleOutput("Pay Period: 01 March - 31 March");
    }

    @Test
    public void consoleOutputsGrossIncome_FromProvidedPaySlip_JohnDoe() {
        outputPayslipJohnDoe();
        assertConsoleOutput("Gross Income: 5004");
    }

    @Test
    public void consoleOutputsIncomeTax_FromProvidedPaySlip_JohnDoe() {
        outputPayslipJohnDoe();
        assertConsoleOutput("Income Tax: 922");
    }

    @Test
    public void consoleOutputsNetIncome_FromProvidedPaySlip_JohnDoe() {
        outputPayslipJohnDoe();
        assertConsoleOutput("Net Income: 4082");
    }

    @Test
    public void consoleOutputsSuperannuation_FromProvidedPaySlip_JohnDoe() {
        outputPayslipJohnDoe();
        assertConsoleOutput("Super: 450");
    }

    @Test
    public void consoleOutputsEmployeeName_FromProvidedPaySlip_JaneCitizen() {
        outputPayslipJaneCitizen();
        assertConsoleOutput("Name: Jane Citizen");
    }

    @Test
    public void consoleOutputsPayDateRange_FromProvidedPaySlip_JaneCitizen() {
        outputPayslipJaneCitizen();
        assertConsoleOutput("Pay Period: 1 December - 31 December");
    }

    @Test
    public void consoleOutputsGrossIncome_FromProvidedPaySlip_JaneCitizen() {
        outputPayslipJaneCitizen();
        assertConsoleOutput("Gross Income: 6403");
    }

    @Test
    public void consoleOutputsIncomeTax_FromProvidedPaySlip_JaneCitizen() {
        outputPayslipJaneCitizen();
        assertConsoleOutput("Income Tax: 1203");
    }

    @Test
    public void consoleOutputsNetIncome_FromProvidedPaySlip_JaneCitizen() {
        outputPayslipJaneCitizen();
        assertConsoleOutput("Net Income: 5200");
    }

    @Test
    public void consoleOutputsSuperannuation_FromProvidedPaySlip_JaneCitizen() {
        outputPayslipJaneCitizen();
        assertConsoleOutput("Super: 498");
    }

    private void outputPayslipJohnDoe() {
        BigDecimal grossIncome = new BigDecimal("5004");
        BigDecimal incomeTax = new BigDecimal("922");
        BigDecimal netIncome = grossIncome.subtract(incomeTax);
        BigDecimal superannuation = new BigDecimal("450");
        Payslip payslip = new Payslip("John Doe", "01 March - 31 March", grossIncome, incomeTax, netIncome, superannuation);
        payslipPresenter.outputPayslip(payslip);
    }

    private void outputPayslipJaneCitizen() {
        BigDecimal grossIncome = new BigDecimal("6403");
        BigDecimal incomeTax = new BigDecimal("1203");
        BigDecimal netIncome = grossIncome.subtract(incomeTax);
        BigDecimal superannuation = new BigDecimal("498");
        Payslip payslip = new Payslip("Jane Citizen", "1 December - 31 December", grossIncome, incomeTax, netIncome, superannuation);
        payslipPresenter.outputPayslip(payslip);
    }

    private void assertConsoleOutput(String expectedValue) {
        assertTrue(consoleWriter.outputIncludes(expectedValue));
    }

}

