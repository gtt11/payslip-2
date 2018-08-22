package Console;

import Core.PaySlip;
import Core.PayslipPresenter;

public class ConsoleWriterAlternate implements PayslipPresenter {

    private PaySlip payslip;

    public void outputPayslip(PaySlip payslip) {
        this.payslip = payslip;
    }

    public PaySlip getPayslip() {
        return this.payslip;
    }

}
