package id317864189_id315083311;
import java.util.Scanner;

import id317864189_id315083311.exceptions.DuplicationException;
import id317864189_id315083311.exceptions.InvalidAccountNumber;
import id317864189_id315083311.exceptions.InvalidChoiceException;
import id317864189_id315083311.exceptions.InvalidClientName;

public class Main {
    public static Scanner s = new Scanner(System.in);
    //AccountsFactory
    static Bank afekaBank = new Bank(12345, 1);
    public static final String Menu =
            "1- Auto fill for 4+ accounts.\n" +
            "2- Add new account.\n" +
            "3- Add client to account.\n" +
            "4- Show all accounts.\n" +
            "5- Show profit accounts.\n" +
            "6- Show accounts by types.\n" +
            "7- Show annual profit of specific account.\n" +
            "8- Show annual profit of bank.\n" +
            "9- Show most profit account of bank.\n" +
            "10- Check Profit VIP.\n" +
            "11- Show management fees.\n" +
            "e/E - exit program.\n";

    public static void main(String[] args) throws CloneNotSupportedException {
        init();
        run();
    }
    private static void run() throws CloneNotSupportedException {
        String choice;
        do {
            choice = showMenu();
            switch (choice){
                case "1" -> autoFill();
                case "2" -> addNewAccount();
                case "3" -> addClientToAccount();
                case "4" -> showAllAccounts();
                case "5" -> showProfitAccounts();
                case "6" -> showAccountsByType();
                case "7" -> showAnnualProfitOfSpecificAccount();
                case "8" -> showAnnualProfitOfBank();
                case "9" -> showMostProfitAccountOfBank();
                case "10" -> checkBankProfitVIP();
                case "11" -> showManagementFees();
                case "e", "E" -> exitProgram();
            }
        } while (!choice.equals("e") && !choice.equals("E"));
    }

    //------case 1 ------
    private static void autoFill() {
        afekaBank.addRandomAccount(Bank.accountsTypes.RegularCheckingAccount);
        afekaBank.addRandomAccount(Bank.accountsTypes.MortgageAccount);
        afekaBank.addRandomAccount(Bank.accountsTypes.BusinessCheckingAccount);
        afekaBank.addRandomAccount(Bank.accountsTypes.SavingAccount);
        afekaBank.additionalRandomAccount();
    }

    //------case 2 ------
    private static void addNewAccount() {
        int accountNumber = 0;
        System.out.println("Would you like to choose account number or use automatic number? \n1-automatic number   2-chose number");
        int typeChoice2 = validateChoice(1,2);
        switch(typeChoice2) {
            case 1:
                accountNumber = afekaBank.newAccountNumber();
                break;
            case 2:
                System.out.println("Enter account number: ");
                accountNumber = (int) validateDuplicateAccount();
                break;
        }
        String managerName = afekaBank.accountManager();
        System.out.println("How many clients to this account");
        int numberOfClients = validateInputInt();
        Client[] clients = new Client[numberOfClients];
        for (int i = 0; i < numberOfClients; i++) {
            System.out.println("Enter the name of client " + (i+1) + ":");
            String name = validateClientName(clients);
            clients[i] = new Client(name);
        }
        System.out.println("What is the account type? \n1- Checking Account ,2- Business Checking Account ,3- Mortgage Account, 4- Saving Account");
        int typeChoice = validateChoice(1,4);
        switch(typeChoice){
            case 1 :
                System.out.println("Enter account credit");
                int regularCredit =validateInputInt();
                afekaBank.addRegularCheckingAccount(accountNumber , managerName , clients , "Regular Checking", regularCredit , numberOfClients);
                break;
            case 2 :
                System.out.println("Enter account credit");
                int businessCredit =validateInputInt();
                System.out.println("Enter business revenue");
                int businessRevenue =validateInputInt();
                afekaBank.addBusinessAccount(accountNumber , managerName , clients , "Business Checking", businessRevenue, businessCredit , numberOfClients);
                break;
            case 3 :
                System.out.println("Enter original mortgage amount");
                int originalMortgageAmount =validateInputInt();
                System.out.println("Enter years");
                int years =validateInputInt();
                int monthlyPayment = (originalMortgageAmount / years) / 12;
                afekaBank.addMortgageAccount(accountNumber , managerName , clients , originalMortgageAmount , years,  monthlyPayment , numberOfClients);
                break;

            case 4 :
                System.out.println("Enter deposit amount");
                int depositAmount =validateInputInt();
                System.out.println("Enter years");
                int depositYears =validateInputInt();
                afekaBank.addSavingAccount(accountNumber , managerName , clients , depositAmount , depositYears , numberOfClients);
                break;

        }



    }

    //------case 3 ------
    private static void addClientToAccount() {
        if(!checkBankStatus()){
            return;
        }
        System.out.println("Please enter account number");
        int accountNumber = validateAccountNumber();
        System.out.println("Please enter client name");
        String clientName = s.nextLine();
        Account account = afekaBank.getAccountByAccountNumber(accountNumber);
        if(afekaBank.isExistsClient(clientName , account )){
            System.out.println("Client already exists");
        }
        else {
            afekaBank.addNewClientToAccount(clientName, account);
        }

    }

    //------case 4 ------
    private static void showAllAccounts() {
        if(!checkBankStatus()){
            return;
        }
        System.out.println(afekaBank.getAccountsDetails());
    }

    //------case 5 ------
    private static void showProfitAccounts() {
        if(!checkBankStatus()){
            return;
        }
        System.out.println(afekaBank.getProfitableAccountsDetails());
    }

    //------case 6 ------
    private static void showAccountsByType() {
        if(!checkBankStatus()){
            return;
        }
        System.out.println("What is the account type? \n1- Regular Checking Account ,2- Business Checking Account ,3- Mortgage Account, 4- Saving Account");
        int typeChoice = validateChoice(1,4);
        System.out.println(afekaBank.getAccountsDetailsByType(typeChoice));
    }

    //------case 7 ------
    private static void showAnnualProfitOfSpecificAccount() {
        if(!checkBankStatus()){
            return;
        }
            System.out.println("Please enter account number");
            int accountNumber = validateAccountNumber();
            Account account = afekaBank.getAccountByAccountNumber(accountNumber);
            System.out.println("Account number " + accountNumber + " Profit: " + account.getProfit());
    }

    //------case 8 ------
    private static void showAnnualProfitOfBank() {
        if(!checkBankStatus()){
            return;
        }
        System.out.println("The bank profit this year:" +afekaBank.getYearProfit());

    }

    //------case 9 ------
    private static void showMostProfitAccountOfBank() {
        if(!checkBankStatus()){
            return;
        }
        int mostProfitCheckingAccount = afekaBank.mostProfitCheckingAccount();
        if(mostProfitCheckingAccount == 0){
            System.out.println("There is no checking account on the bank");
        }
        else {
            System.out.println("The most profit checking account on the bank is account number " + mostProfitCheckingAccount);
        }
    }
    //------case 10 ------
    private static void checkBankProfitVIP() throws CloneNotSupportedException {
        if(!checkBankStatus()){
            return;
        }
        System.out.println("Please enter account number");
        int accountNumber = validateAccountNumber();
        double newProfit = 0;
        Account account = afekaBank.getAccountByAccountNumber(accountNumber);
        if(account instanceof BusinessCheckingAccount){
            if(((BusinessCheckingAccount) account).setIsVIP()) {
                newProfit = afekaBank.checkProfitVIP((BusinessCheckingAccount) account);
                System.out.println("The current profit is " + account.getProfit() + ", if the account was not VIP the profit was - " + newProfit);
            }
            else System.out.println("This is not VIP account");
        }
        else {
            System.out.println("Account number " + accountNumber + " is not a Business Checking Account");
        }
    }

    //------case 11 ------
    private static void showManagementFees() {
        if(!checkBankStatus()){
            return;
        }
        System.out.println(afekaBank.printManagementFees());
    }

    //------case e \ E ------
    private static void exitProgram() {
        System.out.println("Thanks for visiting the bank, byeeee");
    }

    //------Exceptions------
    private static int validateInputInt() {
        String input;
        int numInput;
        while (true) {
            try {
                input = s.nextLine();
                numInput = Integer.parseInt(input);
                if (numInput < 1){
                    throw new InvalidChoiceException("Please enter only positive numbers");
                }
                return numInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validateChoice(int min , int max) {
        String Choice;
        int numChoice;
        while (true) {
            try {
                Choice = s.nextLine();
                numChoice = Integer.parseInt(Choice);
                if (numChoice < min  || numChoice > max) {
                    throw new InvalidChoiceException(" Entered Choice " + numChoice);
                }
                return numChoice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid Choice between " + min + " to " + max);
            }
        }
    }

    private static int validateAccountNumber() {
        String input;
        int numInput;
        while (true) {
            try {
                input = s.nextLine();
                numInput = Integer.parseInt(input);
                if (!afekaBank.isExistsAccountNumber(numInput)) {
                    throw new InvalidAccountNumber("Account number entered:" + numInput);
                }
                return numInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
            } catch (InvalidAccountNumber e) {
                System.out.println(e.getMessage());
                System.out.println("Account number is not exist.");
            }
        }
    }

    private static String validateClientName(Client[] clients) {
        String input;
        while (true) {
            try {
                input = s.nextLine();
                if (afekaBank.isExistsClientName(input, clients)) {
                    throw new InvalidClientName("Client name entered:" + input);
                }
                return input;
            } catch (InvalidClientName e) {
                System.out.println(e.getMessage());
                System.out.println("Client name is already exist.");
            }
        }
    }

    private static double validateDuplicateAccount() {
        String input;
        int numInput;
        while (true) {
            try {
                input = s.nextLine();
                numInput = Integer.parseInt(input);
                if (numInput < 1){
                    throw new InvalidChoiceException("Please enter only positive numbers");
                }
                if (afekaBank.isExistsAccountNumber(numInput)) {
                    throw new DuplicationException("Account number entered:" + numInput);
                }
                return numInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
            } catch (DuplicationException e) {
                System.out.println(e.getMessage());
                System.out.println("Account Number exists.");
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //-------Main------
    private static String showMenu() {
        System.out.println(Menu);
        System.out.println("Please enter your choice");
        return s.nextLine();
    }

    private static void init() {
        afekaBank.accounts = new Account[1];
    }

    private static boolean checkBankStatus(){
            if(afekaBank.getNumOfAccounts() < 1) {
                System.out.println("The Bank is empty");
                return false;
            }
            return true;
    }
}
