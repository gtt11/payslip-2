package Alternates;

import Core.Employee;
import Core.EmployeeDetailGetter;

public class ConsoleReaderAlternate implements EmployeeDetailGetter {

    public Employee getEmployee() {
        return new Employee("John", "Doe", "60050", "9", "01 March", "31 March");
    }

}
