import Console.*;
import Core.*;
import DataStore.*;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EndToEndTest {

    @Test
    public void consolePayslipCalculator() throws UnsupportedEncodingException, FileNotFoundException {

        // Arrange
        String testUserInput = "John\nDoe\n60050\n9\n01 March\n31 March";
        InputStream inputStream = new ByteArrayInputStream(testUserInput.getBytes("UTF-8"));
        OutputStream outputStream = new ByteArrayOutputStream();
        ConsoleIO consoleIO = new ConsoleIO(inputStream, outputStream);
        ConsolePrompter consolePrompter = new ConsolePrompter(consoleIO);

        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new MonthlyTaxCalculator(taxTaxBracketLoader);
        PayslipGenerator payslipGenerator = new PayslipGenerator(newTaxCalculator);

        ConsoleApplication consoleApplication = new ConsoleApplication(payslipGenerator, consolePrompter);

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
