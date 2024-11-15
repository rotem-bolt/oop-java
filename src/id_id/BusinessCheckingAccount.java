package id_id;

public class BusinessCheckingAccount extends CheckingAccount {
    private int businessRevenue;
    private boolean isVIP;


    public BusinessCheckingAccount(int bankNumber, int accountNumber, double bankRateDifference, String managerName, Client[] clients, int checking, String type, int businessRevenue , int credit) {
        super(bankNumber, accountNumber, bankRateDifference, managerName, clients, checking, type);
        this.managementFee = 1000;
        this.businessRevenue = businessRevenue;
        this.isVIP = (businessRevenue >= 10000000) && getIsVIP();
        if (isVIP) {
            this.profit = 0;
        } else {
            this.profit = profit + 3000;
            //TO DO: how to calculate 3000 for each year?
        }
    }

    public boolean getIsVIP() {
        for (Client client : this.clients) {
            if (client.rank != 10)
                return false;
        }
        return true;
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
                + ",Account type- " + getType()
                + ",Business revenue- " +  businessRevenue
                + ",isVIP- " + isVIP
                + ",type " + getType();
    }
}
