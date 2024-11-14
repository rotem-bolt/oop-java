package id_id;

public class MortgageAccount extends Account {
    private int originalMortgageAmount;
    private int years;
    private int monthlyPayment;

    public MortgageAccount(int bankNumber, int accountNumber,double rateDifference ,String managerName , Client[] clients,int originalMortgageAmount, int years, int monthlyPayment) {
        super(bankNumber, accountNumber, rateDifference , managerName , clients);
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
                + ",monthly payment- " + monthlyPayment;


    }

    }
