package Core.Employee;

import java.math.BigDecimal;

public interface Employee {

    String getFullName();

    BigDecimal getSalary();

    BigDecimal getSuperRate();

    String getPaymentStartDate();

    String getPaymentEndDate();
}
