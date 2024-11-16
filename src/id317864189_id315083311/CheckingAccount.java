package id317864189_id315083311;

public abstract class CheckingAccount extends Account{
    protected int credit;

    public CheckingAccount(int bankNumber, int accountNumber, double bankRateDifference,String managerName , Client[] clients,  int credit, String type , int numOfClients) {
        super(bankNumber, accountNumber, bankRateDifference , managerName , clients , numOfClients);
        this.managementFee = 0;
        this.credit = credit;
        this.type = type;
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

    public abstract String getAccountDetails();
}



