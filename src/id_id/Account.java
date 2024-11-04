package id_id;

import java.util.Date;
import java.util.Random;

public abstract class Account {
    private Date date;
    private int bankNumber;
    private int accountNumber;
    private int balance;
    //TO DO: default = 20
    private String managerName;
    protected Client[] clients;
    public double profit;
    protected double bankRateDifference;
    protected double managementFee;

    public Account(int bankNumber, int accountNumber, double bankRateDifference) {
        this.date = new Date();
        this.bankNumber = bankNumber;
        this.balance = 20;
        this.bankRateDifference = bankRateDifference;
        if (accountNumber > 0) {
            this.accountNumber = accountNumber;
        }
        else {
            Random rand = new Random();
            this.accountNumber = rand.nextInt(10) + 1;
            //TO DO: find a different way to get a random number
        }
    }

    public abstract String toString();

}
