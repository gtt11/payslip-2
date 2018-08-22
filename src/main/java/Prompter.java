public class Prompter {

    private final UserInterface userInterface;
    private final Employee employee;
    private final TaxCalculator taxCalculator;
    private final SuperannuationCalculator superCalculator;

    public Prompter(UserInterface userInterface, Employee employee, TaxCalculator taxCalculator, SuperannuationCalculator superCalculator) {
        this.userInterface = userInterface;
        this.employee = employee;
        this.taxCalculator = taxCalculator;
        this.superCalculator = superCalculator;
    }

    public void runApplication() {
    }

    public boolean hasOutputPayslip() {
        return false;
    }

}
