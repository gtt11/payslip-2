package Alternates;

import Core.Employee.Employee;

import java.math.BigDecimal;

public class EmployeeAlternateJohnDoe implements Employee {

    @Override
    public String getFullName() {
        return "John Doe";
    }

    @Override
    public BigDecimal getSalary() {
        return new BigDecimal("60050");
    }

    @Override
    public BigDecimal getSuperRate() {
        return new BigDecimal("9");
    }

    @Override
    public String getPaymentStartDate() {
        return "1 March";
    }

    @Override
    public String getPaymentEndDate() {
        return "31 March";
    }
}
