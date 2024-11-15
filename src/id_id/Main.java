package id_id;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import id_id.exceptions.DuplicationException;
import id_id.exceptions.InvalidAccountNumber;
import id_id.exceptions.InvalidChoiceException;
import id_id.exceptions.GeneralException;
import lee_tsayeg_rotem_boltanski.exceptions.InvalidWeightException;

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

    public static void main(String[] args) {
        init();
        run();
    }
    private static void run() {
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
        afekaBank.addRandomAccount(Bank.accountsTypes.regularChecking);
        afekaBank.addRandomAccount(Bank.accountsTypes.mortgage);
        afekaBank.addRandomAccount(Bank.accountsTypes.businessChecking);
        afekaBank.addRandomAccount(Bank.accountsTypes.saving);
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
            String name = s.nextLine();
            clients[i] = new Client(name);
        }
        System.out.println("What is the account type? \n1- Checking Account ,2- Business Checking Account ,3- Mortgage Account, 4- Saving Account");
        int typeChoice = validateChoice(1,4);
        switch(typeChoice){
            case 1 :
                System.out.println("Enter account credit");
                int regularCredit =validateInputInt();
                System.out.println("Enter account checking");
                int regularChecking =validateInputInt();
                afekaBank.addRegularCheckingAccount(accountNumber , managerName , clients , regularChecking , "Regular Checking", regularCredit , numberOfClients);
                break;
            case 2 :
                System.out.println("Enter account credit");
                int businessCredit =validateInputInt();
                System.out.println("Enter account checking");
                int businessChecking =validateInputInt();
                System.out.println("Enter business revenue");
                int businessRevenue =validateInputInt();
                afekaBank.addBusinessAccount(accountNumber , managerName , clients , businessChecking , "Business Checking",  businessCredit , businessRevenue  , numberOfClients);
                break;
            case 3 :
                System.out.println("Enter original mortgage amount");
                int originalMortgageAmount =validateInputInt();
                System.out.println("Enter years");
                int years =validateInputInt();
                System.out.println("Enter monthly payment");
                int monthlyPayment =validateInputInt();
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
        afekaBank.addNewClientToAccount(clientName, account);

    }

    //------case 4 ------
    private static void showAllAccounts() {
        if(!checkBankStatus()){
            return;
        }
        System.out.println(afekaBank.getAccountsDetails());
        //sorted by the account num
    }

    //------case 5 ------
    private static void showProfitAccounts() {
        //sorted by the profit amount
    }

    //------case 6 ------
    private static void showAccountsByType() {
        //sorted by the account num
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
    private static void checkBankProfitVIP() {
        System.out.println("Please enter account number");
        int accountNumber = validateAccountNumber();
        double newProfit = 0;
        Account account = afekaBank.getAccountByAccountNumber(accountNumber);
        if(account instanceof BusinessCheckingAccount){
            if(((BusinessCheckingAccount) account).getIsVIP()) {
                newProfit = afekaBank.checkProfitVIP((BusinessCheckingAccount) account);
                System.out.println("Old Profit is " + account.getProfit() + "New profit is " + newProfit);
            }
            else System.out.println("This is not VIP account");
        }
        else {
            System.out.println("Account number " + accountNumber + " is not a Business Checking Account");
        }


        //make sure its exists
    }

    //------case 11 ------
    private static void showManagementFees() {
        if(!checkBankStatus()){
            return;
        }
        StringBuilder st = afekaBank.printManagementFees();
        System.out.println(st.toString());
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
                return numInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
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
                System.out.println("Account Number is not exist.");
            }
        }
    }

    private static double validateDuplicateAccount() {
        int accountNumber   ;
        while (true) {
            try {
                accountNumber = s.nextInt();
                if (afekaBank.isExistsAccountNumber(accountNumber)) {
                    throw new DuplicationException("Account number: " + accountNumber);
                }
                return accountNumber;
            } catch (DuplicationException e) {
                System.out.println("Account number already exist on the system. Please enter a valid number.");
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
     //   afekaBank.addAccount(123, 15000, Bank.accountsTypes.checking);
        //To remove
    }

    private static boolean checkBankStatus(){
            if(afekaBank.getNumOfAccounts() < 1) {
                System.out.println("The Bank is empty");
                return false;
            }
            return true;
    }
}
