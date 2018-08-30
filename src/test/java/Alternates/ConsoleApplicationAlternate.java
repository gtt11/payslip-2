package Alternates;

import Core.*;

public class ConsoleApplicationAlternate {

    private PayslipGeneratorStandard payslipGenerator;

    public ConsoleApplicationAlternate(PayslipGeneratorStandard payslipGenerator) {
        this.payslipGenerator = payslipGenerator;
    }

    public PaySlip getPayslip() {
        Employee employee = new Employee("John", "Doe", "60050", "9", "01 March", "31 March");
        return payslipGenerator.getPayslip(employee);
    }
}
