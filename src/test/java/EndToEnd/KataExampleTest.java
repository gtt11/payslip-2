package EndToEnd;

import Console.*;
import Core.*;
import DataStore.*;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KataExampleTest {

    @Test
    public void consolePayslipCalculator() throws UnsupportedEncodingException, FileNotFoundException {

        // Arrange
        String testUserInput = "John\nDoe\n60050\n9\n01 March\n31 March";

        InputStream inputStream = new ByteArrayInputStream(testUserInput.getBytes("UTF-8"));
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        OutputStream outputStream = new ByteArrayOutputStream();
        ConsoleWriter consoleWriter = new ConsoleWriter(outputStream);

        PayslipWriter payslipWriter = new PayslipWriter(consoleWriter);
        EmployeeGetter employeeGetter = new EmployeeGetter(consoleReader, consoleWriter);

        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new MonthlyTaxCalculator(taxTaxBracketLoader);
        PayslipGeneratorStandard payslipGenerator = new PayslipGeneratorStandard(newTaxCalculator);

        Runner consoleApplication = new Runner(employeeGetter, payslipGenerator, payslipWriter);

        // Act
        consoleApplication.run();

        // Assert
        assertThat(outputStream.toString().contains("Name: John Doe"), is(true));
        assertThat(outputStream.toString().contains("Pay Period: 01 March - 31 March"), is(true));
        assertThat(outputStream.toString().contains("Gross Income: 5004"), is(true));
        assertThat(outputStream.toString().contains("Income Tax: 922"), is(true));
        assertThat(outputStream.toString().contains("Net Income: 4082"), is(true));
        assertThat(outputStream.toString().contains("Super: 450"), is(true));
    }
}
