package EndToEnd;

import Alternates.ConsoleReaderAlternateAcceptsInputStream;
import Alternates.ConsoleWriterAlternateSavesOutput;
import Application.*;
import Console.*;
import Console.Reader.ConsoleReader;
import Core.Payslip.PayslipGeneratorStandard;
import Core.Tax.MonthlyTaxCalculator;
import Core.Tax.TaxCalculator;
import DataStore.*;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class KataExampleTest {

    @Test
    public void consolePayslipCalculator_JohnDoe() throws UnsupportedEncodingException, FileNotFoundException {

        // Arrange
        String testUserInput = "John\nDoe\n60050\n9\n01 March\n31 March";

        ConsoleReader consoleReader = new ConsoleReaderAlternateAcceptsInputStream(testUserInput);
        ConsoleWriterAlternateSavesOutput consoleWriter = new ConsoleWriterAlternateSavesOutput();

        ConsolePayslipPresenter payslipPresenter = new ConsolePayslipPresenter(consoleWriter);
        ConsoleEmployeeGetter employeeGetter = new ConsoleEmployeeGetter(consoleReader, consoleWriter);

        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new MonthlyTaxCalculator(taxTaxBracketLoader);
        PayslipGeneratorStandard payslipGenerator = new PayslipGeneratorStandard(newTaxCalculator);

        Runner consoleApplication = new Runner(employeeGetter, payslipGenerator, payslipPresenter);

        // Act
        consoleApplication.run();

        // Assert
        assertTrue(consoleWriter.outputIncludes("Name: John Doe"));
        assertTrue(consoleWriter.outputIncludes("Pay Period: 01 March - 31 March"));
        assertTrue(consoleWriter.outputIncludes("Gross Income: 5004"));
        assertTrue(consoleWriter.outputIncludes("Income Tax: 922"));
        assertTrue(consoleWriter.outputIncludes("Net Income: 4082"));
        assertTrue(consoleWriter.outputIncludes("Super: 450"));
    }

    @Test
    public void consolePayslipCalculator_RyanChen() throws UnsupportedEncodingException, FileNotFoundException {

        // Arrange
        String testUserInput = "Ryan\nChen\n120000\n10\n01 March\n31 March";

        ConsoleReader consoleReader = new ConsoleReaderAlternateAcceptsInputStream(testUserInput);
        ConsoleWriterAlternateSavesOutput consoleWriter = new ConsoleWriterAlternateSavesOutput();

        ConsolePayslipPresenter payslipPresenter = new ConsolePayslipPresenter(consoleWriter);
        ConsoleEmployeeGetter employeeGetter = new ConsoleEmployeeGetter(consoleReader, consoleWriter);

        TaxBracketLoader taxTaxBracketLoader = new JSONTaxBracketLoader("src/test/java/Alternates/tax_brackets_alternate.json");
        TaxCalculator newTaxCalculator = new MonthlyTaxCalculator(taxTaxBracketLoader);
        PayslipGeneratorStandard payslipGenerator = new PayslipGeneratorStandard(newTaxCalculator);

        Runner consoleApplication = new Runner(employeeGetter, payslipGenerator, payslipPresenter);

        // Act
        consoleApplication.run();

        // Assert
        assertTrue(consoleWriter.outputIncludes("Name: Ryan Chen"));
        assertTrue(consoleWriter.outputIncludes("Pay Period: 01 March - 31 March"));
        assertTrue(consoleWriter.outputIncludes("Gross Income: 10000"));
        assertTrue(consoleWriter.outputIncludes("Income Tax: 2658"));
        assertTrue(consoleWriter.outputIncludes("Net Income: 7342"));
        assertTrue(consoleWriter.outputIncludes("Super: 1000"));
    }
}
