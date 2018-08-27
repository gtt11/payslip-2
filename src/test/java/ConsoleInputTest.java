import java.io.*;
import Console.*;
import Core.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConsoleInputTest {

    private ConsolePrompter consolePrompter;
    private Employee defaultEmployee;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        createDefaultEmployee_throughConsoleInput();
    }

    @Test
    public void createsEmployee_withProvidedName() {
        assertThat(defaultEmployee.getFullName(), is("John Doe"));
    }

    @Test
    public void createsEmployee_withProvidedSalary() {
        assertThat(defaultEmployee.getSalary(), is(65000F));
    }

    @Test
    public void createsEmployee_withProvidedSuperannuationRate() {
        assertThat(defaultEmployee.getSuperRate(), is(9F));
    }

    @Test
    public void createsEmployee_withProvidedPaymentStartDate() {
        assertThat(defaultEmployee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void createsEmployee_withProvidedPaymentEndDate() {
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

    public void createDefaultEmployee_throughConsoleInput() throws UnsupportedEncodingException {
        createConsoleReader_withTestInput("John\nDoe\n65000\n9\n01 March\n31 March");
    }

    public void createConsoleReader_withTestInput(String testUserInput) throws UnsupportedEncodingException {
        InputStream inputStream = new ByteArrayInputStream(testUserInput.getBytes("UTF-8"));
        ConsoleIO consoleIO = new ConsoleIO(inputStream);
        consolePrompter = new ConsolePrompter(consoleIO);
        defaultEmployee = consolePrompter.getEmployee();
    }

}
