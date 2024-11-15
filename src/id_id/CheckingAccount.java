package id_id;

public class CheckingAccount extends Account {
    private int credit;
    private String type;

    public CheckingAccount(int bankNumber, int accountNumber, double bankRateDifference,String managerName , Client[] clients,  int credit, String type) {
        super(bankNumber, accountNumber, bankRateDifference , managerName , clients);
        this.managementFee = 0;
        this.credit = credit;
        this.type = type;
        this.profit = this.bankRateDifference * this.credit;
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



