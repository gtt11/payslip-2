package Console;

import Core.Employee;
import Core.PaySlip;

public interface UserInterface {

    void outputPayslip(PaySlip payslip);

    Employee getEmployee();
}
