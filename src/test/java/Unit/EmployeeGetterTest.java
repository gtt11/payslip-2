package Unit;

import Alternates.ConsoleReaderAlternateAcceptsInputStream;
import Console.*;
import Console.Reader.ConsoleReader;
import Console.Writer.ConsoleWriter;
import Console.Writer.ConsoleWriterStandard;
import Core.Employee.Employee;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class EmployeeGetterTest {

    private Employee employee;

    @Test
    public void createsEmployee_withProvidedName() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(employee.getFullName(), is("John Doe"));
    }

    @Test
    public void createsAlternateEmployee_withProvidedName() throws UnsupportedEncodingException {
        createAlternateEmployee_usingConsoleInput();
        assertThat(employee.getFullName(), is("Jane Citizen"));
    }

    @Test
    public void createsEmployee_withProvidedSalary() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertEquals("65000", employee.getSalary().toString());
    }

    @Test
    public void createsAlternateEmployee_withProvidedSalary() throws UnsupportedEncodingException {
        createAlternateEmployee_usingConsoleInput();
        assertEquals("70151", employee.getSalary().toString());
    }

    @Test
    public void createsEmployee_withProvidedSuperannuationRate() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertEquals("9", employee.getSuperRate().toString());
    }

    @Test
    public void createsAlternateEmployee_withProvidedSuperannuationRate() throws UnsupportedEncodingException {
        createAlternateEmployee_usingConsoleInput();
        assertEquals("10.8", employee.getSuperRate().toString());
    }

    @Test
    public void createsEmployee_withProvidedPaymentStartDate() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(employee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void createsAlternateEmployee_withProvidedPaymentStartDate() throws UnsupportedEncodingException {
        createAlternateEmployee_usingConsoleInput();
        assertThat(employee.getPaymentStartDate(), is("1 May"));
    }

    @Test
    public void createsEmployee_withProvidedPaymentEndDate() throws UnsupportedEncodingException {
        createDefaultEmployee_usingConsoleInput();
        assertThat(employee.getPaymentEndDate(), is("31 March"));
    }

    @Test
    public void createsAlternateEmployee_withProvidedPaymentEndDate() throws UnsupportedEncodingException {
        createAlternateEmployee_usingConsoleInput();
        assertThat(employee.getPaymentEndDate(), is("31 May"));
    }

    @Test
    public void validatesConsoleInputForSalary_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertEquals("65000", employee.getSalary().toString());
    }

    @Test
    public void validatesConsoleInputForSuper_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertEquals("10", employee.getSuperRate().toString());
    }

    @Test
    public void validatesConsoleInputForStartDate_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertThat(employee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void validatesConsoleInputForEndDate_seeksFurtherInputWhenInvalid() throws UnsupportedEncodingException {
        createDefaultEmployee_withInvalidConsoleInput();
        assertThat(employee.getPaymentEndDate(), is("31 March"));
    }

    public void createDefaultEmployee_withInvalidConsoleInput() throws UnsupportedEncodingException{
        createConsoleReader_withTestInput("John\nDoe\n65a00\n65000\n9 4\n10\n41 March\n01 March\n28 Mag\n31 March");
    }

    public void createDefaultEmployee_usingConsoleInput() throws UnsupportedEncodingException {
        createConsoleReader_withTestInput("John\nDoe\n65000\n9\n01 March\n31 March");
    }

    public void createAlternateEmployee_usingConsoleInput() throws UnsupportedEncodingException {
        createConsoleReader_withTestInput("Jane\nCitizen\n70151\n10.8\n1 May\n31 May");
    }

    public void createConsoleReader_withTestInput(String testUserInput) throws UnsupportedEncodingException {
        ConsoleReader consoleReader = new ConsoleReaderAlternateAcceptsInputStream(testUserInput);
        ConsoleWriter consoleWriter = new ConsoleWriterStandard();
        ConsoleEmployeeGetter employeeGetter = new ConsoleEmployeeGetter(consoleReader, consoleWriter);
        employee = employeeGetter.getEmployee();
    }

}
