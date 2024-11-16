package id317864189_id315083311;

public class SavingAccount extends Account {
    private int depositAmount;
    private int years;

    public SavingAccount(int bankNumber, int accountNumber, double rateDifference , String managerName , Client[] clients, int depositAmount, int years , int numOfClients, String type) {
        super(bankNumber, accountNumber, rateDifference , managerName , clients , numOfClients);
        this.depositAmount = depositAmount;
        this.years = years;
        this.profit = 0;
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
                + ",deposit Amount- " + depositAmount
                + ",years- " + years
                + ",bank profit - " + getProfit()
                + ",type is - " + type;

    }
}
