package Application;

import Core.Employee.*;
import Core.Payslip.*;

public class Runner {

    private EmployeeGetter employeeGetter;
    private PayslipGenerator payslipGenerator;
    private PayslipPresenter payslipPresenter;

    public Runner(EmployeeGetter employeeGetter, PayslipGenerator payslipGenerator, PayslipPresenter payslipPresenter) {
        this.employeeGetter = employeeGetter;
        this.payslipGenerator = payslipGenerator;
        this.payslipPresenter = payslipPresenter;
    }

    public void run() {
        Employee employee = employeeGetter.getEmployee();
        Payslip payslip = payslipGenerator.getPayslip(employee);
        payslipPresenter.outputPayslip(payslip);
    }

}
