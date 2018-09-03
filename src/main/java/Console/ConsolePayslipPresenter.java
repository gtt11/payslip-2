package Console;

import Console.Writer.ConsoleWriter;
import Core.Payslip.Payslip;
import Core.Payslip.PayslipPresenter;

public class ConsolePayslipPresenter implements PayslipPresenter {

    private ConsoleWriter output;

    public ConsolePayslipPresenter(ConsoleWriter output){
        this.output = output;
    }

    public void outputPayslip(Payslip payslip) {
        output.display("\nYour payslip has been generated:\n");
        output.display("Name: " + payslip.getName());
        output.display("Pay Period: " + payslip.getPayPeriod());
        output.display("Gross Income: " + payslip.getGrossIncome());
        output.display("Income Tax: " + payslip.getIncomeTax());
        output.display("Net Income: " + payslip.getNetIncome());
        output.display("Super: " + payslip.getSuperannuation());
        output.display("Thank you for using MYOB!");
    }

}
