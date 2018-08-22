public class PaySlip {

    private String name;
    private String payPeriod;
    private String grossIncome;
    private String incomeTax;
    private String netIncome;
    private String superannuation;

    public PaySlip(String name, String payPeriod, String grossIncome, String incomeTax, String netIncome, String superannuation) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superannuation = superannuation;
    }

}
