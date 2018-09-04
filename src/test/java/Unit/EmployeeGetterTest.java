package Unit;

import Alternates.ConsoleReaderAlternateAcceptsInputStream;
import Console.*;
import Console.Reader.ConsoleReader;
import Console.Writer.*;
import Core.Employee.Employee;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class EmployeeGetterTest {

    private Employee employee;

    private final String anyFirstName = "Any first name";
    private final String anyLastName = "Any last name";
    private final String anySalary = "0";
    private final String anySuperRate = "0";
    private final String anyPaymentStartDate = "1 January";
    private final String anyPaymentEndDate = "2 January";

    @Test
    public void createsEmployee_withProvidedName() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                "John",
                "Doe",
                anySalary,
                anySuperRate,
                anyPaymentStartDate,
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertThat(employee.getFullName(), is("John Doe"));
    }

    @Test
    public void createsEmployee_withProvidedSalary() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                "65000",
                anySuperRate,
                anyPaymentStartDate,
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertEquals("65000", employee.getSalary().toString());
    }

    @Test
    public void createsEmployee_withProvidedSuperannuationRate() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                anySalary,
                "9",
                anyPaymentStartDate,
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertEquals("9", employee.getSuperRate().toString());
    }

    @Test
    public void createsEmployee_WithDecimalSuperannuationRate() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                anySalary,
                "10.8",
                anyPaymentStartDate,
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertEquals("10.8", employee.getSuperRate().toString());
    }

    @Test
    public void createsEmployee_withProvidedPaymentStartDate() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                anySalary,
                anySuperRate,
                "01 March",
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertThat(employee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void createsEmployee_withProvidedPaymentEndDate() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                anySalary,
                anySuperRate,
                anyPaymentStartDate,
                "31 March"
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertThat(employee.getPaymentEndDate(), is("31 March"));
    }

    @Test
    public void createsEmployee_seeksFurtherInputInvalidSalaryProvided() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                "65ab201",
                "65000",
                anySuperRate,
                anyPaymentStartDate,
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertEquals("65000", employee.getSalary().toString());
    }

    @Test
    public void createsEmployee_seeksFurtherInputWhenInvalidSuperProvided() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                anySalary,
                "55",
                "10",
                anyPaymentStartDate,
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertEquals("10", employee.getSuperRate().toString());
    }

    @Test
    public void createsEmployee_seeksFurtherInputWhenInvalidStartDateProvided() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                anySalary,
                anySuperRate,
                "41 March",
                "01 March",
                anyPaymentEndDate
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertThat(employee.getPaymentStartDate(), is("01 March"));
    }

    @Test
    public void createsEmployee_seeksFurtherInputWhenInvalidEndDateProvided() throws UnsupportedEncodingException {
        String[] employeeDetails = {
                anyFirstName,
                anyLastName,
                anySalary,
                anySuperRate,
                anyPaymentStartDate,
                "28 Mag",
                "31 March"
        };
        createConsoleReader_withTestInput(employeeDetails);
        assertThat(employee.getPaymentEndDate(), is("31 March"));
    }

    public void createConsoleReader_withTestInput(String[] testUserInput) throws UnsupportedEncodingException {
        String testInputWithLineBreaks = String.join("\n", testUserInput);
        ConsoleReader consoleReader = new ConsoleReaderAlternateAcceptsInputStream(testInputWithLineBreaks);
        ConsoleWriter consoleWriter = new ConsoleWriterStandard();
        Validator validator = new Validator(50);
        ConsoleEmployeeGetter employeeGetter = new ConsoleEmployeeGetter(consoleReader, consoleWriter, validator);
        employee = employeeGetter.getEmployee();
    }

}
