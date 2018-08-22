public class ConsoleWriter implements PayslipOutputGenerator {

    private boolean hasOutputPayslip = false;

    public void outputPayslip(PaySlip payslip) {
        hasOutputPayslip = true;
    }

    public boolean hasOutputPayslip() {
        return hasOutputPayslip;
    }
}
