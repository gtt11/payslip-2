import java.io.*;
import Console.ConsoleReader;
import Core.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConsoleReaderTest {

    private ConsoleReader consoleReader;
    private Employee defaultEmployee;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        createDefaultEmployee_throughConsoleInput();
    }

    @Test
    public void createsEmployee_withCorrectName() {
        assertThat(defaultEmployee.getFullName(), is("John Doe"));
    }

    @Test
    public void createsEmployee_withCorrectSalary() {
        assertThat(defaultEmployee.getSalary(), is(65000F));
    }

    @Test
    public void createsEmployee_withCorrectSuperannuationRate() {
        assertThat(defaultEmployee.getSuperRate(), is(9F));
    }

    @Test
    public void createsEmployee_withCorrectPaymentStartDate() {
        assertThat(defaultEmployee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void createsEmployee_withCorrectPaymentEndDate() {
        assertThat(defaultEmployee.getPaymentEndDate(), is("31 March"));
    }

    public void createDefaultEmployee_throughConsoleInput() throws UnsupportedEncodingException {
        createConsoleReader_withTestInput("John\nDoe\n65000\n9\n01 March\n31 March");
    }

    public void createConsoleReader_withTestInput(String testUserInput) throws UnsupportedEncodingException {
        InputStream inputStream = new ByteArrayInputStream(testUserInput.getBytes("UTF-8"));
        consoleReader = new ConsoleReader(inputStream);
        defaultEmployee = consoleReader.getEmployee();
    }

}
