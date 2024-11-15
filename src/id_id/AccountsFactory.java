package id_id;

import id_id.Bank;

import java.util.Random;

public class AccountsFactory {
    public Account buildAccount(Bank bank, Bank.accountsTypes type) {
        int bankNumber = bank.getBankNumber();
        double rateDifference = bank.getRateDifference();
        int accountNumber = bank.newAccountNumber();
        String managerName = bank.accountManager();
        Client[] clients = randomClients();
        if (type.equals(Bank.accountsTypes.saving)) {
            return buildSavingAccount(bankNumber, accountNumber, rateDifference, managerName, clients , clients.length);
        }
        if (type.equals(Bank.accountsTypes.mortgage)) {
            return buildMortgageAccount(bankNumber, accountNumber, rateDifference, managerName, clients , clients.length);
        }
        if (type.equals(Bank.accountsTypes.businessChecking)) {
            return buildBusinessCheckingAccount(bankNumber, accountNumber, rateDifference, managerName, clients , clients.length);
        }
        if (type.equals(Bank.accountsTypes.regularChecking)) {
            return buildRegularCheckingAccount(bankNumber, accountNumber, rateDifference, managerName,clients , clients.length);
        }
        return null;
    }

    public Client[] randomClients() {
        Random R = new Random();
        int clientAmount = R.nextInt(5) + 2;
        String name = "client";
        Client[] clients = new Client[clientAmount];
        for (int i = 0; i < clientAmount; i++) {
            clients[i] = new Client(name + (i + 1));
        }
        return clients;
    }


    public SavingAccount buildSavingAccount(int bankNumber, int accountNumber, double rateDifference, String managerName, Client[] clients , int numOfClient) {
        Random R = new Random();
        int depositAmount = R.nextInt(100000) + 1;
        int years = R.nextInt(30);
        return new SavingAccount(bankNumber, accountNumber, rateDifference, managerName, clients, depositAmount, years , numOfClient);
    }

    public MortgageAccount buildMortgageAccount(int bankNumber, int accountNumber, double rateDifference, String managerName, Client[] clients , int numOfClient) {
        Random R = new Random();
        int originalMortgageAmount = R.nextInt(1000000) + 100000;
        int years = R.nextInt(30) + 5;
        int monthlyPayment = originalMortgageAmount / years;
        return new MortgageAccount(bankNumber, accountNumber, rateDifference, managerName, clients, originalMortgageAmount, years, monthlyPayment, numOfClient);
    }

    public BusinessCheckingAccount buildBusinessCheckingAccount(int bankNumber, int accountNumber, double rateDifference, String managerName, Client[] clients , int numOfClient) {
        Random R = new Random();
        String type = "businessChecking";
        int checking = R.nextInt(1000000) + 100000;
        int businessRevenue = R.nextInt(1000000) + 100000;
        int credit = R.nextInt(100000) + 10000;
        return new BusinessCheckingAccount(bankNumber, accountNumber, rateDifference, managerName, clients, checking, credit, type, businessRevenue , numOfClient);
    }

    public RegularCheckingAccount buildRegularCheckingAccount(int bankNumber, int accountNumber, double rateDifference, String managerName, Client[] clients, int numOfClient) {
        Random R = new Random();
        String type = "regularChecking";
        int checking = R.nextInt(10000) + 100;
        int credit = R.nextInt(100000) + 10000;
        return new RegularCheckingAccount(bankNumber, accountNumber, rateDifference, managerName, clients, checking, type , credit , numOfClient);
    }
}
