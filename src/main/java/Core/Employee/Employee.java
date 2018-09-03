package Core.Employee;

import java.math.BigDecimal;

public class Employee {

    private String firstName;
    private String surname;
    private BigDecimal salary;
    private BigDecimal superRate;
    private String paymentStartDate;
    private String paymentEndDate;

    public Employee(String firstName, String surname, BigDecimal salary, BigDecimal superRate, String paymentStartDate, String paymentEndDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.salary = salary;
        this.superRate = superRate;
        this.paymentStartDate = paymentStartDate;
        this.paymentEndDate = paymentEndDate;
    }

    public String getFullName() {
        return firstName + " " + surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public BigDecimal getSuperRate() {
        return superRate;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public String getPaymentEndDate() {
        return paymentEndDate;
    }
}
