package Unit;

import Console.*;
import Core.PaySlip;
import org.junit.*;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PayslipWriterTest {

    private OutputStream consoleOutput;

    @Before
    public void setUp() {
        PaySlip paySlip = new PaySlip("John Doe", "01 March - 31 March", 5004, 922, 4082, 450);
        consoleOutput = new ByteArrayOutputStream();
        ConsoleWriter consoleWriter = new ConsoleWriter(consoleOutput);
        PayslipWriter payslipWriter = new PayslipWriter(consoleWriter);
        payslipWriter.outputPayslip(paySlip);
    }

    @Test
    public void consoleOutputsEmployeeName_fromProvidedPaySlip() {
        assertConsoleOutput("Name: John Doe");
    }

    @Test
    public void consoleOutputsPayDateRange_fromProvidedPaySlip() {
        assertConsoleOutput("Pay Period: 01 March - 31 March");
    }

    @Test
    public void consoleOutputsGrossIncome_fromProvidedPaySlip() {
        assertConsoleOutput("Gross Income: 5004");
    }

    @Test
    public void consoleOutputsIncomeTax_fromProvidedPaySlip() {
        assertConsoleOutput("Income Tax: 922");
    }
    @Test
    public void consoleOutputsNetIncome_fromProvidedPaySlip() {
        assertConsoleOutput("Net Income: 4082");
    }
    @Test
    public void consoleOutputsSuperannuation_fromProvidedPaySlip() {
        assertConsoleOutput("Super: 450");
    }

    private void assertConsoleOutput(String expectedValue) {
        assertThat(consoleOutput.toString().contains(expectedValue), is(true));
    }

}
