package id317864189_id315083311;

public class BusinessCheckingAccount extends CheckingAccount implements Profitable, Cloneable, ManagementFee {
    private int businessRevenue;
    private boolean isVIP;


    public BusinessCheckingAccount(int bankNumber, int accountNumber, double bankRateDifference, String managerName, Client[] clients, int credit , String type, int businessRevenue, int numOfClients) {
        super(bankNumber, accountNumber, bankRateDifference, managerName, clients, credit, type, numOfClients);
        this.managementFee = 1000;
        this.businessRevenue = businessRevenue;
        setProfit();
    }

    public boolean setIsVIP() {
        if (businessRevenue >= 10000000) {
            for (Client client : this.clients) {
                if (client.rank != 10)
                    return false;
            }
            return true;
        }
        return false;
    }

    public void setProfit() {
        this.isVIP = setIsVIP();
        if (isVIP) {
            this.profit = 0;
        } else {
            this.profit = (this.bankRateDifference * this.credit) + 3000;
        }
    }

    @Override
    public String getAccountDetails() {
        return "\nBank number- " + getBankNumber()
                + ",Account number- " + getAccountNumber()
                + ",date of creation- " + getDate()
                + ",balance- " + getBalance()
                + ",manager name- " + getManagerName()
                + ",clients list- " + getClientDetails()
                + ",Account type- " + getType()
                + ",Business revenue- " +  businessRevenue
                + ",isVIP- " + isVIP
                + ",bank profit - " + getProfit()
                + ",type is - " + type;
    }

    public BusinessCheckingAccount clone() throws CloneNotSupportedException {
        return (BusinessCheckingAccount) super.clone();
    }

    @Override
    public double getManagementFee() {
        return managementFee;
    }
}
