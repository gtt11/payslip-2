import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest {

    @Test
    public void createApplication() {
        UserInterface userInterface = new ConsoleIO();
        Employee newEmployee = new Employee();


        RateLoader taxRateLoader = new JSONTaxRateLoader();
        TaxCalculator newTaxCalculator = new TaxCalculator(taxRateLoader);

        RateLoader superRateLoader = new JSONSuperannuationRateLoader();
        SuperannuationCalculator newSuperCalculator = new SuperannuationCalculator(superRateLoader);

        Prompt newPrompter = new Prompt(userInterface, newEmployee, newTaxCalculator, newSuperCalculator);

        newPrompter.runApplication();

        assertThat(newPrompter.hasOutputPayslip(), is(true));

    }
}
