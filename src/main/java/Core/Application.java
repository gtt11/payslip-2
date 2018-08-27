package Core;

import java.io.FileNotFoundException;

public class Application {

    private EmployeeDetailGetter employeeDetailGetter;
    private PayslipGenerator payslipGenerator;
    private PayslipPresenter payslipOutputGenerator;

    public Application(EmployeeDetailGetter input, PayslipPresenter output, PayslipGenerator payslipGenerator) {
        this.employeeDetailGetter = input;
        this.payslipOutputGenerator = output;
        this.payslipGenerator = payslipGenerator;
    }

    public void runApplication() throws FileNotFoundException {
        Employee employee = employeeDetailGetter.getEmployee();
        PaySlip payslip = preparePayslip(employee);
        outputPayslip(payslip);
    }

    private PaySlip preparePayslip(Employee employee) throws FileNotFoundException {
        return payslipGenerator.getPayslip(employee);
    }

    private void outputPayslip(PaySlip payslip) {
        payslipOutputGenerator.outputPayslip(payslip);
    }

}
