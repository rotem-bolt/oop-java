package id_id;

public class RegularCheckingAccount extends CheckingAccount implements Profitable {
 ;
    public RegularCheckingAccount(int bankNumber, int accountNumber, double bankRateDifference,String managerName , Client[] clients, int checking, String type , int credit, int numOfClients) {
        super(bankNumber, accountNumber, bankRateDifference, managerName , clients, checking, type, numOfClients);
        this.profit = this.bankRateDifference * this.credit;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getAccountDetails() {
        return "\nBank number- " + getBankNumber()
                + ",Account number- " + getAccountNumber()
                + ",date of creation- " + getDate()
                + ",balance- " + getBalance()
                + ",manager name- " + getManagerName()
                + ",clients list- " + getClientDetails()
                + ",credit " + getCredit()
                + ",type " + getType();

    }

}
