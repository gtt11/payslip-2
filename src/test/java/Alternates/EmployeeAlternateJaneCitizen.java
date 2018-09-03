package Alternates;

import Core.Employee.Employee;

import java.math.BigDecimal;

public class EmployeeAlternateJaneCitizen implements Employee {

    @Override
    public String getFullName() {
        return "Jane Citizen";
    }

    @Override
    public BigDecimal getSalary() {
        return new BigDecimal("60535");
    }

    @Override
    public BigDecimal getSuperRate() {
        return new BigDecimal("10.5");
    }

    @Override
    public String getPaymentStartDate() {
        return "1 August";
    }

    @Override
    public String getPaymentEndDate() {
        return "31 August";
    }
}
