package Core;

import java.io.FileNotFoundException;

public class PayslipGenerator {

    private TaxCalculator taxCalculator;

    public PayslipGenerator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public PaySlip getPayslip(Employee employee) throws FileNotFoundException {
        String fullName = employee.getFullName();
        String payPeriod = getPayPeriod(employee);
        int grossMonthlyIncome = getGrossMonthlyIncome(employee);
        int monthlyIncomeTax = getMonthlyIncomeTax(employee);
        int netIncome = getNetIncome(grossMonthlyIncome, monthlyIncomeTax);
        int superannuation = getSuper(employee, grossMonthlyIncome);
        return new PaySlip(fullName, payPeriod, grossMonthlyIncome, monthlyIncomeTax, netIncome, superannuation);
    }

    private String getPayPeriod(Employee employee) {
        return employee.getPaymentStartDate() + " - " + employee.getPaymentEndDate();
    }

    private int getGrossMonthlyIncome(Employee employee) {
        return Math.round(employee.getSalary() / 12);
    }

    private int getMonthlyIncomeTax(Employee employee) throws FileNotFoundException {
        float annualSalary = employee.getSalary();
        return taxCalculator.calculateIncomeTax(annualSalary);
    }

    private int getNetIncome(int grossMonthlyIncome, int incomeTax) {
        return grossMonthlyIncome - incomeTax;
    }

    private int getSuper(Employee employee, int grossIncome) {
        Float superRateFraction = employee.getSuperRate() / 100;
        return Math.round(grossIncome * superRateFraction);
    }

}
