public class Prompter {

    private EmployeeDetailGenerator employeeDetailGenerator;
    private PayslipGenerator payslipGenerator;
    private Employee employee;
    private PaySlip payslip;
    private PayslipPresenter payslipOutputGenerator;

    public Prompter(EmployeeDetailGenerator input, PayslipPresenter output, PayslipGenerator payslipGenerator) {
        this.employeeDetailGenerator = input;
        this.payslipOutputGenerator = output;
        this.payslipGenerator = payslipGenerator;
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
        payslip = payslipGenerator.getPayslip(employee);
    }

    private void outputPayslip() {
        payslipOutputGenerator.outputPayslip(payslip);
    }

}
