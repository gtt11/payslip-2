package Console;

import Core.PaySlip;
import Core.PayslipPresenter;

public class ConsoleWriterAlternate implements PayslipPresenter {

    private boolean hasOutputPayslip = false;

    public void outputPayslip(PaySlip payslip) {
        this.hasOutputPayslip = true;
    }

    public boolean hasOutputPayslip() {
        return this.hasOutputPayslip;
    }
}
