package Core;

public class Employee {

    private String firstName;
    private String surname;
    private Float salary;
    private Float superRate;
    private String paymentStartDate;
    private String paymentEndDate;

    public Employee(String firstName, String surname, String salary, String superRate, String paymentStartDate, String paymentEndDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.salary = Float.parseFloat(salary);
        this.superRate = Float.parseFloat(superRate);
        this.paymentStartDate = paymentStartDate;
        this.paymentEndDate = paymentEndDate;
    }

    public String getFullName() {
        return firstName + " " + surname;
    }

    public Float getSalary() {
        return salary;
    }

    public Float getSuperRate() {
        return superRate;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public String getPaymentEndDate() {
        return paymentEndDate;
    }
}
