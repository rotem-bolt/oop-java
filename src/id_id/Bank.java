package id_id;

import lee_tsayeg_rotem_boltanski.Tiger;

import java.util.Arrays;

public class Bank {
    private int bankNumber;
    private double rateDifference;
    protected int numOfAccounts;
    protected Account[] accounts;

    public Bank(int bankNumber, double rateDifference) {
        this.bankNumber = bankNumber;
        this.rateDifference = rateDifference;
    }

    public double checkProfitVIP(Account account) {
        Account newAccount = account;
        for (Client client : account.clients) {
            client.rank = 0;
        }
        return newAccount.profit;
    }

    public StringBuilder printManagementFees() {
        StringBuilder managementFeeDetails = new StringBuilder();
        int managerBonus = 0;
        for (Account account: this.accounts) {
            if (account.managementFee > 0) {
                managementFeeDetails.append(account.toString());
                managerBonus += account.managementFee;
            }
        }
        managementFeeDetails.append("\nThe bank manager bonus is: " + managerBonus);
        return managementFeeDetails;
    }

    public void addAccount(int accountNumber, int credit, String type) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts++] = new Account(this.bankNumber, accountNumber, this.rateDifference) {
            @Override
            public String toString() {
                return "";
            }
        };
        numOfAccounts++;
    }
}
