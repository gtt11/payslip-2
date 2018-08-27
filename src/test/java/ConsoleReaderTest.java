import java.io.*;
import Console.ConsoleReader;
import Core.Employee;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConsoleReaderTest {

    private ConsoleReader consoleReader;

    @Test
    public void createsEmployee_withCorrectName() throws UnsupportedEncodingException {
        createConsoleReader_withTestInput("John\nDoe");
        Employee employee = consoleReader.getEmployee();
        assertThat(employee.getFullName(), is("John Doe"));
    }

    public void createConsoleReader_withTestInput(String testUserInput) throws UnsupportedEncodingException {
        InputStream inputStream = new ByteArrayInputStream(testUserInput.getBytes("UTF-8"));
        consoleReader = new ConsoleReader(inputStream);
    }

}
