package Core;

public class Employee {

    private String firstName;
    private String surname;
    private String salary;
    private String superRate;
    private String paymentStartDate;
    private String paymentEndDate;

    public Employee(String firstName, String surname, String salary, String superRate, String paymentStartDate, String paymentEndDate) {
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

    public Float getSalary() {
        return Float.parseFloat(salary);
    }

    public Float getSuperRate() {
        return Float.parseFloat(superRate);
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public String getPaymentEndDate() {
        return paymentEndDate;
    }
}
