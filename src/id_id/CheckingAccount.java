package id_id;

public class CheckingAccount extends Account {
    private int credit;
    private String type;

    public CheckingAccount(int bankNumber, int accountNumber, double bankRateDifference,  int credit, String type) {
        super(bankNumber, accountNumber, bankRateDifference);
        this.managementFee = 0;
        this.credit = credit;
        this.type = type;
        this.profit = this.bankRateDifference * this.credit;
    }

    @Override
    public String toString() {
        return "";
    }
}
