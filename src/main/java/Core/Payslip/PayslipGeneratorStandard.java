package Core.Payslip;

import Core.Employee.Employee;
import Core.Tax.TaxCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayslipGeneratorStandard implements PayslipGenerator {

    private TaxCalculator taxCalculator;
    private BigDecimal salaryDivisor;
    private final int quotientScale = 0;

    public PayslipGeneratorStandard(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
        this.salaryDivisor = taxCalculator.getSalaryDivisor();
    }

    public Payslip getPayslip(Employee employee) {
        String fullName = employee.getFullName();
        String payPeriod = getPayPeriod(employee);
        BigDecimal grossMonthlyIncome = getGrossMonthlyIncome(employee);
        BigDecimal monthlyIncomeTax = getMonthlyIncomeTax(employee);
        BigDecimal netIncome = grossMonthlyIncome.subtract(monthlyIncomeTax);
        BigDecimal superannuation = getSuper(employee, grossMonthlyIncome);
        return new PayslipStandard(fullName, payPeriod, grossMonthlyIncome, monthlyIncomeTax, netIncome, superannuation);
    }

    private String getPayPeriod(Employee employee) {
        return employee.getPaymentStartDate() + " - " + employee.getPaymentEndDate();
    }

    private BigDecimal getGrossMonthlyIncome(Employee employee) {
        BigDecimal annualSalary = employee.getSalary();
        BigDecimal monthlySalary = annualSalary.divide(salaryDivisor, quotientScale, RoundingMode.HALF_UP);
        return monthlySalary;
    }

    private BigDecimal getMonthlyIncomeTax(Employee employee) {
        BigDecimal annualSalary = employee.getSalary();
        return taxCalculator.calculateIncomeTax(annualSalary);
    }

    private BigDecimal getSuper(Employee employee, BigDecimal grossIncome) {
        BigDecimal superRate = employee.getSuperRate();
        return grossIncome.multiply(superRate).divide(new BigDecimal("100"), quotientScale, RoundingMode.HALF_UP);
    }

}
