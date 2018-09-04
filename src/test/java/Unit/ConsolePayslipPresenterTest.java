package Unit;

import Alternates.*;
import Console.*;
import Core.Payslip.*;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class ConsolePayslipPresenterTest {

    ConsoleWriterAlternateSavesOutput consoleWriter;

    @Before
    public void setUp() {

        // Arrange
        consoleWriter = new ConsoleWriterAlternateSavesOutput();
        PayslipPresenter payslipPresenter = new ConsolePayslipPresenter(consoleWriter);

        BigDecimal grossIncome = new BigDecimal("5004");
        BigDecimal incomeTax = new BigDecimal("922");
        BigDecimal netIncome = grossIncome.subtract(incomeTax);
        BigDecimal superannuation = new BigDecimal("450");
        Payslip payslip = new Payslip("John Doe", "01 March - 31 March", grossIncome, incomeTax, netIncome, superannuation);

        // Act
        payslipPresenter.outputPayslip(payslip);
    }

    @Test
    public void consoleOutputsEmployeeName() {
        assertConsoleOutput("Name: John Doe");
    }

    @Test
    public void consoleOutputsPayDateRange() {
        assertConsoleOutput("Pay Period: 01 March - 31 March");
    }

    @Test
    public void consoleOutputsGrossIncome() {
        assertConsoleOutput("Gross Income: 5004");
    }

    @Test
    public void consoleOutputsIncomeTax() {
        assertConsoleOutput("Income Tax: 922");
    }

    @Test
    public void consoleOutputsNetIncome() {
        assertConsoleOutput("Net Income: 4082");
    }

    @Test
    public void consoleOutputsSuperannuation() {
        assertConsoleOutput("Super: 450");
    }

    private void assertConsoleOutput(String expectedValue) {
        assertTrue(consoleWriter.outputIncludes(expectedValue));
    }

}

