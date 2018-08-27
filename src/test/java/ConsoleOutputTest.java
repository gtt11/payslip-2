import Console.*;
import Core.PaySlip;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleOutputTest {

    @Test
    public void consoleOutputsEmployeeName_fromProvidedPaySlip() {
        PaySlip paySlip = new PaySlip("John Doe", "01 March - 31 March", 5004, 922, 4082, 450);
        OutputStream consoleOutput = new ByteArrayOutputStream();
        ConsoleIO consoleIO = new ConsoleIO(System.in, consoleOutput);
        ConsolePrompter consolePrompter = new ConsolePrompter(consoleIO);
        consolePrompter.outputPayslip(paySlip);
        assertThat(consoleOutput.toString().contains("Name: John Doe"), is(true));
    }


}
