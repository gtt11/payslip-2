package Console;

import Core.*;

public class Runner {

    private EmployeeGetter employeeGetter;
    private PayslipGenerator payslipGenerator;
    private PayslipWriter output;

    public Runner(EmployeeGetter employeeGetter, PayslipGenerator payslipGenerator, PayslipWriter output) {
        this.employeeGetter = employeeGetter;
        this.payslipGenerator = payslipGenerator;
        this.output = output;
    }

    public void run() {
        Employee employee = employeeGetter.getEmployee();
        PaySlip payslip = payslipGenerator.getPayslip(employee);
        output.outputPayslip(payslip);
    }

}
