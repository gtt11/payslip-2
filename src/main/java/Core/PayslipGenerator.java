package Core;

public class PayslipGenerator {

    private TaxCalculator taxCalculator;

    public PayslipGenerator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public PaySlip getPayslip(Employee employee) {
        String fullName = employee.getFullName();
        String payPeriod = getPayPeriod(employee);
        int grossMonthlyIncome = getGrossMonthlyIncome(employee);
        int incomeTax = getIncomeTax(grossMonthlyIncome);
        int netIncome = getNetIncome(grossMonthlyIncome, incomeTax);
        int superannuation = getSuper(employee, grossMonthlyIncome);
        return new PaySlip(fullName, payPeriod, grossMonthlyIncome, incomeTax, netIncome, superannuation);
    }

    private String getPayPeriod(Employee employee) {
        return employee.getPaymentStartDate() + " - " + employee.getPaymentEndDate();
    }

    private int getGrossMonthlyIncome(Employee employee) {
        return Math.round(employee.getSalary() / 12);
    }

    private int getIncomeTax(int grossMonthlyIncome) {
        return taxCalculator.getIncomeTax(grossMonthlyIncome);
    }

    private int getNetIncome(int grossMonthlyIncome, Integer incomeTax) {
        return null;
    }

    private int getSuper(Employee employee, int grossIncome) {
        Float superRateFraction = employee.getSuperRate() / 100;
        return Math.round(grossIncome * superRateFraction);
    }

}
