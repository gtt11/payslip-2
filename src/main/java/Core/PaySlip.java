package Core;

public class PaySlip {

    private String name;
    private String payPeriod;
    private String grossIncome;
    private String incomeTax;
    private String netIncome;
    private String superannuation;

    public PaySlip(String name, String payPeriod, int grossIncome, int incomeTax, int netIncome, int superannuation) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = String.valueOf(grossIncome);
        this.incomeTax = String.valueOf(incomeTax);
        this.netIncome = String.valueOf(netIncome);
        this.superannuation = String.valueOf(superannuation);
    }

    public String getName() {
        return name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public String getGrossIncome() {
        return grossIncome;
    }

    public String getIncomeTax() {
        return incomeTax;
    }

    public String getNetIncome() {
        return netIncome;
    }

    public String getSuperannuation() {
        return superannuation;
    }
}
