package id317864189_id315083311;

public class MortgageAccount extends Account implements Profitable, ManagementFee {
    private int originalMortgageAmount;
    private int years;
    private int monthlyPayment;

    public MortgageAccount(int bankNumber, int accountNumber,double rateDifference ,String managerName , Client[] clients,int originalMortgageAmount, int years, int monthlyPayment , int numOfClients, String type) {
        super(bankNumber, accountNumber, rateDifference , managerName , clients , numOfClients);
        this.managementFee = 0.1 * originalMortgageAmount;
        this.originalMortgageAmount = originalMortgageAmount;
        this.years = years;
        this.monthlyPayment = monthlyPayment;
        this.profit = ((0.8* originalMortgageAmount)/years)*bankRateDifference;
        this.type = type;
    }

    @Override
    public String getAccountDetails() {
        return "\nBank number- " + getBankNumber()
                + ",Account number- " + getAccountNumber()
                + ",date of creation- " + getDate()
                + ",balance- " + getBalance()
                + ",manager name- " + getManagerName()
                + ",clients list- " + getClientDetails()
                + ",original mortgage amount- " + originalMortgageAmount
                + ",years- " + years
                + ",monthly payment- " + monthlyPayment
                + ",bank profit - " + getProfit()
                + ",type is - " + type;
    }

    @Override
    public double getManagementFee() {
        return managementFee;
    }
}
