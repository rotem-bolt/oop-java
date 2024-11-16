package id317864189_id315083311;

import java.util.Arrays;
import java.util.Random;

public class Bank {
    protected enum accountsTypes {RegularCheckingAccount, BusinessCheckingAccount, MortgageAccount, SavingAccount};
    private int bankNumber;
    private double rateDifference;
    protected int numOfAccounts;
    protected Account[] accounts;
    AccountsFactory factory = new AccountsFactory();
    private final String[] managers = {"Arnon" , "Pini" , "Mika" , "Avelin"};

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
        Account[] sortedAccounts = new Account[numOfAccounts];
        int j = 0;
        for (Account account : accounts) {
            if (account != null) {
                sortedAccounts[j++] = account;
            }
        }
        Arrays.sort(sortedAccounts, new CompareAccountNumber());
        for (int i = 0 ; i < numOfAccounts ; i ++){
            AccountDetails.append(sortedAccounts[i].getAccountDetails());
        }
        return AccountDetails.toString();
    }

    public String getProfitableAccountsDetails() {
        StringBuilder AccountDetails = new StringBuilder();
        Account[] sortedAccounts = new Account[0];
        int j = 0;
        for (Account account : accounts) {
            if (account != null) {
                if (account instanceof Profitable) {
                    sortedAccounts = Arrays.copyOf(sortedAccounts, sortedAccounts.length + 1);
                    sortedAccounts[j++] = account;
                }
            }
        }
        Arrays.sort(sortedAccounts, new CompareProfit());
        for (int i = 0 ; i < j ; i ++){
            AccountDetails.append(sortedAccounts[i].getAccountDetails());
        }
        return AccountDetails.toString();
    }

    public String getAccountsDetailsByType(int type) {
        StringBuilder AccountDetails = new StringBuilder();
        Account[] sortedAccounts = new Account[0];
        int j = 0;
        switch (type) {
            case 1:
                for (Account account : accounts) {
                    if (account != null) {
                        if (account instanceof RegularCheckingAccount) {
                            sortedAccounts = Arrays.copyOf(sortedAccounts, sortedAccounts.length + 1);
                            sortedAccounts[j++] = account;
                        }
                    }
                }
                break;
            case 2:
                for (Account account : accounts) {
                    if (account != null) {
                        if (account instanceof BusinessCheckingAccount) {
                            sortedAccounts = Arrays.copyOf(sortedAccounts, sortedAccounts.length + 1);
                            sortedAccounts[j++] = account;
                        }
                    }
                }
                break;
            case 3:
                for (Account account : accounts) {
                    if (account != null) {
                        if (account instanceof MortgageAccount) {
                            sortedAccounts = Arrays.copyOf(sortedAccounts, sortedAccounts.length + 1);
                            sortedAccounts[j++] = account;
                        }
                    }
                }
                break;
            case 4:
                for (Account account : accounts) {
                    if (account != null) {
                        if (account instanceof SavingAccount) {
                            sortedAccounts = Arrays.copyOf(sortedAccounts, sortedAccounts.length + 1);
                            sortedAccounts[j++] = account;
                        }
                    }
                }
                break;
        }
        Arrays.sort(sortedAccounts, new CompareAccountNumber());
        for (int i = 0 ; i < j ; i ++){
            AccountDetails.append(sortedAccounts[i].getAccountDetails());
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
                case 1 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.MortgageAccount);
                case 2 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.RegularCheckingAccount);
                case 3 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.BusinessCheckingAccount);
                case 4 -> accounts[numOfAccounts] =  factory.buildAccount(this , accountsTypes.SavingAccount);
            }
            numOfAccounts++;
        }
    }
    public void addRegularCheckingAccount(int accountNumber, String managerName , Client[] clients , String type  , int credit , int numOfClients) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new RegularCheckingAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients , type , credit ,numOfClients);
        numOfAccounts++;
    }


    public void addBusinessAccount(int accountNumber , String managerName , Client[] clients , String type, int businessRevenue, int credit , int numOfClients) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new BusinessCheckingAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients ,credit, type , businessRevenue , numOfClients);
        numOfAccounts++;
    }

    public void addMortgageAccount(int accountNumber, String managerName, Client[] clients , int originalMortgageAmount , int years , int monthlyPayment , int numOfClients) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new MortgageAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients , originalMortgageAmount , years , monthlyPayment , numOfClients, "Mortgage");
        numOfAccounts++;
    }

    public void addSavingAccount(int accountNumber, String managerName, Client[] clients , int depositAmount , int years, int numOfClients) {
        accounts = Arrays.copyOf(this.accounts, accounts.length * 2);
        accounts[numOfAccounts] = new SavingAccount(this.bankNumber, accountNumber, this.rateDifference, managerName , clients , depositAmount , years , numOfClients, "Saving");
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
        for(int i = 0; i < numOfAccounts; i++) {
            if (accountsNumbers[i] == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public Account getAccountByAccountNumber(int accountNumber) {
        if (numOfAccounts < 1) {
            return null;
        }
        int[] accountsNumbers = getAccountNumberList();
        for (int i = 0; i < numOfAccounts; i++) {
            if (accountsNumbers[i] == accountNumber) {
                return accounts[i];
            }
        }
        return null;
        //Ask Yuval
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

    public boolean isExistsClientName(String clientName, Client[] clients) {
        for(Client client : clients) {
            if (client != null && client.getName().equals(clientName)) {
                return true;
            }
        }
        return false;
    }

    public void addNewClientToAccount(String clientName, Account account){
        account.addClient(clientName);
    }

    // --------Profitable---------

    public double getYearProfit() {
        double yearProfit = 0;
        for(int i=0 ; i < numOfAccounts ; i++) {
            if(accounts[i] instanceof Profitable){
                yearProfit += (accounts[i]).getProfit();
            }
        }
        return yearProfit;
    }

    public int mostProfitCheckingAccount() {
        double maxProfit = 0;
        int maxProfitAccountNumber = 0;
        for (int i = 0; i < numOfAccounts; i++) {
            if (accounts[i] instanceof CheckingAccount) {
                if (accounts[i].getProfit() > maxProfit) {
                    maxProfitAccountNumber = accounts[i].getAccountNumber();
                    maxProfit = accounts[i].getProfit();
                }
            }
        }
        return maxProfitAccountNumber;
    }

    public double checkProfitVIP(BusinessCheckingAccount account) throws CloneNotSupportedException {
        BusinessCheckingAccount clonedAccount = account.clone();
        Client[] clonedClient = new Client[account.numOfClients];
        for (int i = 0; i < account.numOfClients; i++) {
            clonedClient[i] = account.clients[i].clone();
            clonedClient[i].setRank(0);
        }
        clonedAccount.setClients(clonedClient);
        clonedAccount.setProfit();
        return clonedAccount.getProfit();
    }

    //--------Management Fee-------

    public String printManagementFees() {
        StringBuilder managementFeeDetails = new StringBuilder();
        Account[] sortedAccounts = new Account[0];
        double managerBonus = 0;
        int j = 0;
        for (Account account : accounts) {
            if (account != null) {
                if (account instanceof ManagementFee) {
                    sortedAccounts = Arrays.copyOf(sortedAccounts, sortedAccounts.length + 1);
                    sortedAccounts[j++] = account;
                    managerBonus += account.getManagementFee();
                    managementFeeDetails.append(account.getAccountDetails());
                }
            }
        }
        managementFeeDetails.append("\nThe bank manager bonus is: ").append(managerBonus);
        return managementFeeDetails.toString();
    }

}
