package Core;

import TaxCalculator.TaxCalculator;

public class PayslipGenerator {

    private TaxCalculator taxCalculator;

    public PayslipGenerator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public PaySlip getPayslip(Employee employee) {
        String fullName = getFullName(employee);
        String payPeriod = getPayPeriod(employee);
        Integer grossIncome = getGrossIncome(employee);
        Integer incomeTax = getIncomeTax(grossIncome);
        Integer netIncome = getNetIncome(grossIncome, incomeTax);
        Integer superannuation = getSuper(employee, grossIncome);
        return new PaySlip(fullName, payPeriod, grossIncome, incomeTax, netIncome, superannuation);
    }

    private String getFullName(Employee employee) {
        return employee.getFirstName() + " " + employee.getSurname();
    }

    private String getPayPeriod(Employee employee) {
        return employee.getPaymentStartDate() + " - " + employee.getPaymentEndDate();
    }

    private int getGrossIncome(Employee employee) {
        return Math.round(employee.getSalary() / 12);
    }

    private Integer getIncomeTax(Integer grossIncome) {
        return taxCalculator.getIncomeTax(grossIncome);
    }

    private Integer getNetIncome(Integer grossIncome, Integer incomeTax) {
        return null;
    }

    private Integer getSuper(Employee employee, Integer grossIncome) {
        return null;
    }

}
