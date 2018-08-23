package Core;

public class PayslipGenerator {

    private TaxCalculator taxCalculator;

    public PayslipGenerator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public PaySlip getPayslip(Employee employee) {
        String fullName = employee.getFullName();
        String payPeriod = getPayPeriod(employee);
        Integer grossMonthlyIncome = getGrossIncome(employee);
        Integer incomeTax = getIncomeTax(grossMonthlyIncome);
        Integer netIncome = getNetIncome(grossMonthlyIncome, incomeTax);
        Integer superannuation = getSuper(employee, grossMonthlyIncome);
        return new PaySlip(fullName, payPeriod, grossMonthlyIncome, incomeTax, netIncome, superannuation);
    }

    private String getPayPeriod(Employee employee) {
        return employee.getPaymentStartDate() + " - " + employee.getPaymentEndDate();
    }

    private int getGrossIncome(Employee employee) {
        return Math.round(employee.getSalary() / 12);
    }

    private Integer getIncomeTax(int grossMonthlyIncome) {
        return taxCalculator.getIncomeTax(grossMonthlyIncome);
    }

    private Integer getNetIncome(int grossMonthlyIncome, Integer incomeTax) {
        return null;
    }

    private int getSuper(Employee employee, int grossIncome) {
        Float superRateFraction = employee.getSuperRate() / 100;
        return Math.round(grossIncome * superRateFraction);
    }

}
