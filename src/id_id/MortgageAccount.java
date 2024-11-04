package id_id;

public class MortgageAccount extends Account {
    private int originalMortgageAmount;
    private int years;
    private int monthlyPayment;

    public MortgageAccount(int bankNumber, int accountNumber,double bankRateDifference,int originalMortgageAmount, int years, int monthlyPayment) {
        super(bankNumber, accountNumber, bankRateDifference);
        this.managementFee = 0.1 * originalMortgageAmount;
        this.originalMortgageAmount = originalMortgageAmount;
        this.years = years;
        this.monthlyPayment = monthlyPayment;
        this.profit = ((0.8* originalMortgageAmount)/years)*bankRateDifference;
    }

    @Override
    public String toString() {
        return "";
    }

}
