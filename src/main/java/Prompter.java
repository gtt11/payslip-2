public class Prompter {

    private EmployeeDetailGetter employeeDetailGetter;
    private PayslipGenerator payslipGenerator;
    private Employee employee;
    private PaySlip payslip;
    private PayslipPresenter payslipOutputGenerator;

    public Prompter(EmployeeDetailGetter input, PayslipPresenter output, PayslipGenerator payslipGenerator) {
        this.employeeDetailGetter = input;
        this.payslipOutputGenerator = output;
        this.payslipGenerator = payslipGenerator;
    }

    public void runApplication() {
        getEmployee();
        preparePayslip();
        outputPayslip();
    }

    private void getEmployee() {
        String firstName = employeeDetailGetter.getFirstName();
        String surname = employeeDetailGetter.getSurname();
        String salary = employeeDetailGetter.getSalary();
        String superRate = employeeDetailGetter.getSuperRate();
        String paymentStartDate = employeeDetailGetter.getPaymentStartDate();
        String paymentEndDate = employeeDetailGetter.getPaymentEndDate();
        this.employee = new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private void preparePayslip() {
        payslip = payslipGenerator.getPayslip(employee);
    }

    private void outputPayslip() {
        payslipOutputGenerator.outputPayslip(payslip);
    }

}
