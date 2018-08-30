package Console;

import Core.*;
import DataStore.*;

import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        buildApplication().run();
    }

    public static ConsoleRunner buildApplication() {
        TaxBracketLoader JSONTaxBracketLoader = new JSONTaxBracketLoader("src/main/java/Resources/tax_brackets.json");
        TaxCalculator taxCalculator = new MonthlyTaxCalculator(JSONTaxBracketLoader);
        PayslipGenerator payslipGenerator = new PayslipGenerator(taxCalculator);
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        ConsolePrompter consolePrompter = new ConsolePrompter(consoleIO);
        return new ConsoleRunner(payslipGenerator, consolePrompter);
    }
}
