public class Prompter {

    private final UserInterface userInterface;
    private final TaxCalculator taxCalculator;
    private final SuperannuationCalculator superCalculator;

    public Prompter(UserInterface userInterface, TaxCalculator taxCalculator, SuperannuationCalculator superCalculator) {
        this.userInterface = userInterface;
        this.taxCalculator = taxCalculator;
        this.superCalculator = superCalculator;
    }

    public void runApplication() {
    }

    public boolean hasOutputPayslip() {
        return false;
    }

}
