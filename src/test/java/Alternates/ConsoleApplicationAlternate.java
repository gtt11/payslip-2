package Alternates;

import Core.*;

import java.io.FileNotFoundException;

public class ConsoleApplicationAlternate {

    private PayslipGenerator payslipGenerator;

    public ConsoleApplicationAlternate(PayslipGenerator payslipGenerator) {
        this.payslipGenerator = payslipGenerator;
    }

    public PaySlip getPayslip() throws FileNotFoundException {
        Employee employee = new Employee("John", "Doe", "60050", "9", "01 March", "31 March");
        return payslipGenerator.getPayslip(employee);
    }
}
