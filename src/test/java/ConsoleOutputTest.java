import Console.*;
import Core.PaySlip;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleOutputTest {

    private OutputStream consoleOutput;

    @Before
    public void setUp() {
        PaySlip paySlip = new PaySlip("John Doe", "01 March - 31 March", 5004, 922, 4082, 450);
        consoleOutput = new ByteArrayOutputStream();
        ConsoleIO consoleIO = new ConsoleIO(System.in, consoleOutput);
        ConsolePrompter consolePrompter = new ConsolePrompter(consoleIO);
        consolePrompter.outputPayslip(paySlip);
    }

    @Test
    public void consoleOutputsEmployeeName_fromProvidedPaySlip() {
        assertThat(consoleOutput.toString().contains("Name: John Doe"), is(true));
    }

    @Test
    public void consoleOutputsPayDateRange_fromProvidedPaySlip() {
        assertThat(consoleOutput.toString().contains("Pay Period: 01 March - 31 March"), is(true));
    }


}
