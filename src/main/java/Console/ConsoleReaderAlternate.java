package Console;

import Core.EmployeeDetailGetter;

public class ConsoleReaderAlternate implements EmployeeDetailGetter {

    public String getFirstName() {
        return "John";
    }

    public String getSurname() {
        return "Doe";
    }

    public String getSalary() {
        return "60050";
    }

    public String getSuperRate() {
        return "9";
    }

    public String getPaymentStartDate() {
        return "1 March";
    }

    public String getPaymentEndDate() {
        return "31 March";
    }

}
