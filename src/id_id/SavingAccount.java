package id_id;

public class SavingAccount extends Account {
    private int depositAmount;
    private int years;

    public SavingAccount( int bankNumber, int accountNumber, double rateDifference , String managerName , Client[] clients, int depositAmount, int years) {
        super(bankNumber, accountNumber, rateDifference , managerName , clients);
        this.depositAmount = depositAmount;
        this.years = years;
        this.profit = 0;
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
                + ",deposit Amount- " + depositAmount
                + ",years- " + years;

    }
}
