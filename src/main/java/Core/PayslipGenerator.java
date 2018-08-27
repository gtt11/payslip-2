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
        int incomeTax = getIncomeTax(grossMonthlyIncome);
        Integer netIncome = getNetIncome(grossMonthlyIncome, incomeTax);
        int superannuation = getSuper(employee, grossMonthlyIncome);
        return new PaySlip(fullName, payPeriod, grossMonthlyIncome, incomeTax, netIncome, superannuation);
    }

    private String getPayPeriod(Employee employee) {
        return employee.getPaymentStartDate() + " - " + employee.getPaymentEndDate();
    }

    private int getGrossMonthlyIncome(Employee employee) {
        return Math.round(employee.getSalary() / 12);
    }

    private int getIncomeTax(int grossMonthlyIncome) throws FileNotFoundException {
        return taxCalculator.getIncomeTax(grossMonthlyIncome);
    }

    private Integer getNetIncome(int grossMonthlyIncome, int incomeTax) {
        return null;
    }

    private int getSuper(Employee employee, int grossIncome) {
        Float superRateFraction = employee.getSuperRate() / 100;
        return Math.round(grossIncome * superRateFraction);
    }

}
