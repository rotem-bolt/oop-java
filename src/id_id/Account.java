package id_id;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public abstract class Account {
    protected Date date;
    protected int bankNumber;
    protected int accountNumber;
    protected int balance;
    protected String managerName;
    protected Client[] clients;
    public double profit;
    protected double bankRateDifference;
    protected double managementFee;
    public int numOfClients;

    public Account(int bankNumber, int accountNumber, double bankRateDifference , String managerName , Client[] clients , int numOfClients) {
        this.date = new Date();
        this.bankNumber = bankNumber;
        this.balance = 20;
        this.bankRateDifference = bankRateDifference;
        this.managerName = managerName;
        this.clients = clients;
        this.numOfClients = numOfClients;
        if (accountNumber > 0) {
            this.accountNumber = accountNumber;
        }
        else {
            Random rand = new Random();
            this.accountNumber = rand.nextInt(10) + 1;
            //TO DO: find a different way to get a random number
        }
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public Date getDate() {
        return date;
    }

    public int getBalance() {
        return balance;
    }

    public String getManagerName() {
        return managerName;
    }

    public double getProfit() {
        return profit;
    }

    public double getBankRateDifference() {
        return bankRateDifference;
    }

    public double getManagementFee() {
        return managementFee;
    }

    public abstract String getAccountDetails();

    public String getClientDetails() {
        StringBuilder clientList = new StringBuilder();
        for (int i = 0; i < numOfClients; i++) {
            clientList.append(clients[i].getName()).append(" ");
        }
        return clientList.toString();
    }

    public abstract String toString();
    //to delete

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public Client[] getClientList(){
        return this.clients;
    }

    public void addClient(String name){
        clients = Arrays.copyOf(clients, clients.length * 2);
        clients[numOfClients] = new Client(name);
        numOfClients++;
    }

}


