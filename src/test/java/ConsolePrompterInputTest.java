import java.io.*;
import Console.*;
import Core.Employee;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConsolePrompterInputTest {

    private ConsolePrompter consolePrompter;
    private Employee defaultEmployee;

    @Test
    public void createsEmployee_withProvidedName() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(defaultEmployee.getFullName(), is("John Doe"));
    }

    @Test
    public void createsEmployee_withProvidedSalary() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(defaultEmployee.getSalary(), is(65000F));
    }

    @Test
    public void createsEmployee_withProvidedSuperannuationRate() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(defaultEmployee.getSuperRate(), is(9F));
    }

    @Test
    public void createsEmployee_withProvidedPaymentStartDate() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(defaultEmployee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void createsEmployee_withProvidedPaymentEndDate() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(defaultEmployee.getPaymentEndDate(), is("31 March"));
    }

    @Test
    public void validatesConsoleInputForSalary_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertThat(defaultEmployee.getSalary(), is(65000F));
    }

    @Test
    public void validatesConsoleInputForSuper_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertThat(defaultEmployee.getSuperRate(), is(10F));
    }

    @Test
    public void validatesConsoleInputForStartDate_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertThat(defaultEmployee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void validatesConsoleInputForEndDate_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertThat(defaultEmployee.getPaymentEndDate(), is("31 March"));
    }

    public void createDefaultEmployee_withInvalidConsoleInput() throws UnsupportedEncodingException {
        createConsoleReader_withTestInput("John\nDoe\n65a00\n65000\n9 4\n10\n41 March\n01 March\n28 Mag\n31 March");
    }

    public void createDefaultEmployee_usingConsoleInput() throws UnsupportedEncodingException {
        createConsoleReader_withTestInput("John\nDoe\n65000\n9\n01 March\n31 March");
    }

    public void createConsoleReader_withTestInput(String testUserInput) throws UnsupportedEncodingException {
        InputStream inputStream = new ByteArrayInputStream(testUserInput.getBytes("UTF-8"));
        ConsoleIO consoleIO = new ConsoleIO(inputStream, System.out);
        consolePrompter = new ConsolePrompter(consoleIO);
        defaultEmployee = consolePrompter.getEmployee();
    }

}
