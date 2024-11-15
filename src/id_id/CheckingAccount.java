package id_id;

import java.io.Serializable;

public class CheckingAccount extends Account{
    protected int credit;
    protected String type;
    protected int checking;

    public CheckingAccount(int bankNumber, int accountNumber, double bankRateDifference,String managerName , Client[] clients,  int credit, String type , int numOfClients) {
        super(bankNumber, accountNumber, bankRateDifference , managerName , clients , numOfClients);
        this.managementFee = 0;
        this.credit = credit;
        this.type = type;
        this.checking = checking;
    }

    public int getCredit() {
        return credit;
    }

    public String getType() {
        return type;
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
                    + ",credit " + getCredit()
                    + ",type " + getType();

    }
}



