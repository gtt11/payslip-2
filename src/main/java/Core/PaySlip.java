package Core;

public class PaySlip {

    private String name;
    private String payPeriod;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer netIncome;
    private Integer superannuation;

    public PaySlip(String name, String payPeriod, Integer grossIncome, Integer incomeTax, Integer netIncome, Integer superannuation) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superannuation = superannuation;
    }

    public String getName() {
        return name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public String getGrossIncome() {
        return String.valueOf(grossIncome);
    }

    public String getIncomeTax() {
        return Integer.toString(incomeTax);
    }

    public String getNetIncome() {
        return Integer.toString(netIncome);
    }

    public String getSuperannuation() {
        return Integer.toString(superannuation);
    }
}
