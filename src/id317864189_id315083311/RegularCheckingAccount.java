package id317864189_id315083311;

public class RegularCheckingAccount extends CheckingAccount implements Profitable {
    public RegularCheckingAccount(int bankNumber, int accountNumber, double bankRateDifference,String managerName , Client[] clients, String type , int credit, int numOfClients) {
        super(bankNumber, accountNumber, bankRateDifference, managerName , clients, credit, type, numOfClients);
        this.profit = this.bankRateDifference * this.credit;
    }

    public String getAccountDetails() {
        return "\nBank number- " + getBankNumber()
                + ",Account number- " + getAccountNumber()
                + ",date of creation- " + getDate()
                + ",balance- " + getBalance()
                + ",manager name- " + getManagerName()
                + ",clients list- " + getClientDetails()
                + ",credit " + getCredit()
                + ",bank profit - " + getProfit()
                + ",type is - " + type;

    }

}
