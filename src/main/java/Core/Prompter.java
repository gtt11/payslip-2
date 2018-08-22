package Core;

public class Prompter {

    private EmployeeDetailGetter employeeDetailGetter;
    private PayslipGenerator payslipGenerator;
    private PayslipPresenter payslipOutputGenerator;

    public Prompter(EmployeeDetailGetter input, PayslipPresenter output, PayslipGenerator payslipGenerator) {
        this.employeeDetailGetter = input;
        this.payslipOutputGenerator = output;
        this.payslipGenerator = payslipGenerator;
    }

    public void runApplication() {
        Employee employee = getEmployee();
        PaySlip payslip = preparePayslip(employee);
        outputPayslip(payslip);
    }

    private Employee getEmployee() {
        String firstName = employeeDetailGetter.getFirstName();
        String surname = employeeDetailGetter.getSurname();
        String salary = employeeDetailGetter.getSalary();
        String superRate = employeeDetailGetter.getSuperRate();
        String paymentStartDate = employeeDetailGetter.getPaymentStartDate();
        String paymentEndDate = employeeDetailGetter.getPaymentEndDate();
        return new Employee(firstName, surname, salary, superRate, paymentStartDate, paymentEndDate);
    }

    private PaySlip preparePayslip(Employee employee) {
        return payslipGenerator.getPayslip(employee);
    }

    private void outputPayslip(PaySlip payslip) {
        payslipOutputGenerator.outputPayslip(payslip);
    }

}
