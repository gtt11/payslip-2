public class Prompter {

    private EmployeeDetailGenerator employeeDetailGenerator;
    private PayslipOutputGenerator payslipOutputGenerator;
    private TaxCalculator taxCalculator;
    private SuperannuationCalculator superCalculator;
    private Employee employee;
    private PaySlip payslip;

    public Prompter(EmployeeDetailGenerator input, PayslipOutputGenerator output, TaxCalculator taxCalculator, SuperannuationCalculator superCalculator) {
        this.employeeDetailGenerator = input;
        this.payslipOutputGenerator = output;
        this.taxCalculator = taxCalculator;
        this.superCalculator = superCalculator;
    }

    public void runApplication() {
        getEmployee();
        preparePayslip();
    }

    private Employee getEmployee() {
        String firstName = employeeDetailGenerator.getFirstName();
        String surname = employeeDetailGenerator.getSurname();
        String salary = employeeDetailGenerator.getSalary();
        String superRate = employeeDetailGenerator.getSuperRate();
        String paymentStartDate = employeeDetailGenerator.getPaymentStartDate();
        String paymentEndDate = employeeDetailGenerator.getPaymentEndDate();
        this.employee = new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private void preparePayslip() {
        String fullName = getFullName();
        String payPeriod = getPayPeriod();
        Integer grossIncome = getGrossIncome();
        Integer incomeTax = getIncomeTax();
        Integer netIncome = getNetIncome(grossIncome, incomeTax);
        Integer superannuation = getSuper();
        this.payslip = new PaySlip(fullName, payPeriod, grossIncome,incomeTax,netIncome,superannuation);
    }

}
