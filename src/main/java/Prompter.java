public class Prompter {

    private EmployeeDetailGenerator employeeDetailGenerator;
    private PayslipOutputGenerator payslipOutputGenerator;
    private TaxCalculator taxCalculator;
    private Employee employee;
    private PaySlip payslip;

    public Prompter(EmployeeDetailGenerator input, PayslipOutputGenerator output, TaxCalculator taxCalculator) {
        this.employeeDetailGenerator = input;
        this.payslipOutputGenerator = output;
        this.taxCalculator = taxCalculator;
    }

    public void runApplication() {
        getEmployee();
        preparePayslip();
        outputPayslip();
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
        Integer incomeTax = getIncomeTax(grossIncome);
        Integer netIncome = getNetIncome(grossIncome, incomeTax);
        Integer superannuation = getSuper();
        this.payslip = new PaySlip(fullName, payPeriod, grossIncome,incomeTax,netIncome,superannuation);
    }

    private String getFullName() {
        return "John Doe";
    }

    private String getPayPeriod() {
        return "1 March - 31 March";
    }

    private Integer getGrossIncome() {
        return 5004;
    }

    private Integer getIncomeTax(Integer grossIncome) {
        return taxCalculator.getIncomeTax(grossIncome);
    }

    private Integer getNetIncome(Integer grossIncome, Integer incomeTax) {
        return 4082;
    }

    private Integer getSuper() {
        return 450;
    }

    private void outputPayslip() {
        payslipOutputGenerator.outputPayslip(this.payslip);
    }

}
