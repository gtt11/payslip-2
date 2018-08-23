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
        Employee employee = employeeDetailGetter.getEmployee();
        PaySlip payslip = preparePayslip(employee);
        outputPayslip(payslip);
    }

    private PaySlip preparePayslip(Employee employee) {
        return payslipGenerator.getPayslip(employee);
    }

    private void outputPayslip(PaySlip payslip) {
        payslipOutputGenerator.outputPayslip(payslip);
    }

}
