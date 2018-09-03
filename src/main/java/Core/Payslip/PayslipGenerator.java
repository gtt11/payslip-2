package Core.Payslip;

import Core.Employee.Employee;

public interface PayslipGenerator {

    Payslip getPayslip(Employee employee);

}
