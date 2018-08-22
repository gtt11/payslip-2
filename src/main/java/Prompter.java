public class Prompter {

    private EmployeeDetailGenerator employeeDetailGenerator;
    private TaxCalculator taxCalculator;
    private SuperannuationCalculator superCalculator;
    private Employee employee;

    public Prompter(EmployeeDetailGenerator employeeDetailGenerator, TaxCalculator taxCalculator, SuperannuationCalculator superCalculator) {
        this.employeeDetailGenerator = employeeDetailGenerator;
        this.taxCalculator = taxCalculator;
        this.superCalculator = superCalculator;
    }

    public void runApplication() {
        getEmployee();
    }

    private void getEmployee() {
        String firstName = employeeDetailGenerator.getFirstName();
        String surname = employeeDetailGenerator.getSurname();
        String salary = employeeDetailGenerator.getSalary();
        String superRate = employeeDetailGenerator.getSuperRate();
        String paymentStartDate = employeeDetailGenerator.getPaymentStartDate();
        String paymentEndDate = employeeDetailGenerator.getPaymentEndDate();
        this.employee = new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    public boolean hasOutputPayslip() {
        return false;
    }

}
