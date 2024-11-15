package id_id;

import java.io.Serializable;

public class BusinessCheckingAccount extends CheckingAccount implements Profitable{
    private int businessRevenue;
    private boolean isVIP;


    public BusinessCheckingAccount(int bankNumber, int accountNumber, double bankRateDifference, String managerName, Client[] clients, int checking, int credit , String type, int businessRevenue, int numOfClients) {
        super(bankNumber, accountNumber, bankRateDifference, managerName, clients, checking, type, numOfClients);
        this.checking = checking;
        this.managementFee = 1000;
        this.businessRevenue = businessRevenue;
        this.isVIP = (businessRevenue >= 10000000) && getIsVIP();
        if (isVIP) {
            this.profit = 0;
        } else {
            this.profit = (this.bankRateDifference * this.credit) + 3000;
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

    public Account cloneBusinessCheckingAccount(){
        return new BusinessCheckingAccount(bankNumber, accountNumber, bankRateDifference, managerName, clients, checking, credit, type, businessRevenue , numOfClients);
    }
}
