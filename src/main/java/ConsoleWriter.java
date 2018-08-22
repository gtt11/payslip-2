public class ConsoleWriter implements PayslipOutputGenerator {

    private boolean hasOutputPayslip = false;

    public void outputPayslip(PaySlip payslip) {
        this.hasOutputPayslip = true;
    }

    public boolean hasOutputPayslip() {
        return this.hasOutputPayslip;
    }
}
