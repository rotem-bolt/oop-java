package id_id;

public class SavingAccount extends Account {
    private int depositAmount;
    private int years;

    public SavingAccount( int bankNumber, double bankRateDifference, int accountNumber, int depositAmount, int years) {
        super(bankNumber, accountNumber, bankRateDifference);
        this.depositAmount = depositAmount;
        this.years = years;
        this.profit = 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
