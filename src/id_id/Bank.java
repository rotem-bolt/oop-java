package id_id;

import id_id.AccountsFactory;
import lee_tsayeg_rotem_boltanski.Animal;

import java.util.Arrays;
import java.util.Random;

public class Bank {
    public enum accountsTypes {regularChecking, businessChecking, mortgage, saving};
    private int bankNumber;
    private double rateDifference;
    protected int numOfAccounts;
    protected Account[] accounts;
    AccountsFactory factory = new AccountsFactory();
    protected final String[] managers = {"Arnon" , "Pini" , "Mika" , "Avelin"};

    public Bank(int bankNumber, double rateDifference) {
        this.bankNumber = bankNumber;
        this.rateDifference = rateDifference;
    }

    // --------get---------
    public int getBankNumber(){
        return bankNumber;
    }

    public double getRateDifference(){
        return rateDifference;
    }

    public String getAccountsDetails() {
        StringBuilder AccountDetails = new StringBuilder();
            for (int i = 0 ; i < numOfAccounts ; i ++){
                AccountDetails.append(accounts[i].getAccountDetails());
                }
        return AccountDetails.toString();
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }
    public int[] getAccountNumberList() {
        int[] accountsNumbers = new int[numOfAccounts];
        for (int i = 0 ; i < numOfAccounts ; i++) {
            accountsNumbers[i] = accounts[i].getAccountNumber();
        }
        return accountsNumbers;
    }


    // --------New Accounts---------
    public void addRandomAccount(accountsTypes types) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] =  factory.buildAccount(this , types);
        numOfAccounts++;
    }

    public void additionalRandomAccount(){
        Random R = new Random();
        int numOfRandomAccounts = R.nextInt(5) + 2;
        for (int i = 0; i < numOfRandomAccounts; i++) {
            accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
            int accountType = R.nextInt(4) + 1;
            switch (accountType) {
                case 1 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.mortgage);
                case 2 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.regularChecking);
                case 3 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.businessChecking);
                case 4 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.saving);
            }
            numOfAccounts++;
        }
    }
    public void addRegularCheckingAccount(int accountNumber, String managerName , Client[] clients , int checking , String type  , int credit) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new RegularCheckingAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients, checking , type , credit);
        numOfAccounts++;
    }



    public void addBusinessAccount(int accountNumber , String managerName , Client[] clients , int checking , String type, int businessRevenue, int credit) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new BusinessCheckingAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients, checking , type , businessRevenue, credit);
        numOfAccounts++;
    }

    public void addMortgageAccount(int accountNumber, String managerName, Client[] clients , int originalMortgageAmount , int years , int monthlyPayment) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new MortgageAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients , originalMortgageAmount , years , monthlyPayment);
        numOfAccounts++;
    }

    public void addSavingAccount(int accountNumber, String managerName, Client[] clients , int depositAmount , int years) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new SavingAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients , depositAmount , years);
        numOfAccounts++;
    }

    // --------Manager---------
    public String accountManager() {
        Random R = new Random();
        int managerNumber = R.nextInt(3);
        return managers[managerNumber];
    }


    // --------Account Number---------

    public boolean isExistsAccountNumber(int accountNumber) {
        if(numOfAccounts < 1){
            return false;
        }
        int[] accountsNumbers = getAccountNumberList();
        for(int i = 0; i < numOfAccounts - 1; i++) {
            if (accountsNumbers[i] == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public int newAccountNumber() {
        if (numOfAccounts < 1){
            return 1;
        }
        int newAccountNumber = getAccountNumberList()[numOfAccounts -1];
        newAccountNumber ++;
        while(isExistsAccountNumber(newAccountNumber)) {
            newAccountNumber++;
        }
        return newAccountNumber;
    }

        // --------Client---------
    public boolean isExistsClient(String clientName, Account account) {
        Client[] clients = account.getClientList();
        for(Client client : clients) {
            if (client.getName().equals(clientName)) {
                return true;
            }
        }
        return false;
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
        managementFeeDetails.append("\nThe bank manager bonus is: ").append(managerBonus);
        return managementFeeDetails;
    }

}
