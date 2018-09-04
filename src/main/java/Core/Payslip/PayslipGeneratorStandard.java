package Core.Payslip;

import Core.Employee.Employee;
import Core.Tax.TaxCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayslipGeneratorStandard implements PayslipGenerator {

    private TaxCalculator taxCalculator;
    private BigDecimal payPeriods;

    private final int decimalPlaces = 0;
    private final RoundingMode roundingMode = RoundingMode.HALF_UP;

    public PayslipGeneratorStandard(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
        this.payPeriods = taxCalculator.getAnnualPayPeriods();
    }

    public Payslip getPayslip(Employee employee) {
        String fullName = employee.getFullName();
        String payPeriod = getPayPeriod(employee);
        BigDecimal grossIncome = getGrossIncomeForPayPeriod(employee);
        BigDecimal incomeTax = getIncomeTaxForPayPeriod(employee);
        BigDecimal netIncome = grossIncome.subtract(incomeTax);
        BigDecimal superannuation = getSuperForPayPeriod(employee, grossIncome);
        return new Payslip(fullName, payPeriod, grossIncome, incomeTax, netIncome, superannuation);
    }

    private String getPayPeriod(Employee employee) {
        return employee.getPaymentStartDate() + " - " + employee.getPaymentEndDate();
    }

    private BigDecimal getGrossIncomeForPayPeriod(Employee employee) {
        BigDecimal annualSalary = employee.getSalary();
        BigDecimal roundedIncomeForPayPeriod = annualSalary.divide(payPeriods, decimalPlaces, roundingMode);
        return roundedIncomeForPayPeriod;
    }

    private BigDecimal getIncomeTaxForPayPeriod(Employee employee) {
        BigDecimal annualSalary = employee.getSalary();
        return taxCalculator.calculateIncomeTax(annualSalary);
    }

    private BigDecimal getSuperForPayPeriod(Employee employee, BigDecimal grossIncome) {
        BigDecimal superRate = employee.getSuperRate();
        BigDecimal roundedSuperForPayPeriod = grossIncome.multiply(superRate).divide(new BigDecimal("100"), decimalPlaces, roundingMode);
        return roundedSuperForPayPeriod;
    }

}
