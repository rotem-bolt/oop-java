package id_id;
import java.util.Random;
import java.util.Scanner;
import id_id.exceptions.InvalidChoiceException;

public class Main {
    public static Scanner s = new Scanner(System.in);
    //AccountsFactory
    static Bank afekaBank = new Bank(12345, 1);
    public static final String Menu =
            "1- Auto fill for 4 accounts.\n" +
            "2- Add new account.\n" +
            "3- Add client to account.\n" +
            "4- Show all accounts.\n" +
            "5- Show profit accounts.\n" +
            "6- Show accounts by types.\n" +
            "7- Show annual profit of specific account.\n" +
            "8- Show annual profit of bank.\n" +
            "9- Check Profit VIP.\n" +
            "10- Show most profit account of bank.\n" +
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
                case "3" -> addClienToAccount();
                case "4" -> showAllAcounts();
                case "5" -> showProfitAcounts();
                case "6" -> showAcountsByType();
                case "7" -> showAnnualProfitOfSpecificAccount();
                case "8" -> showAnnualProfitOfBank();
                case "9" -> checkProfitVIP();
                case "10" -> showMostProfitAccountOfBank();
                case "11" -> showManagementFees();
                case "e", "E" -> exitProgram();
            }
        } while (!choice.equals("e") && !choice.equals("E"));
    }
    //------case 1 ------
    private static void autoFill() {
    }
    //------case 2 ------
    private static void addNewAccount() {
        System.out.println("What is the account type? \n1- Checking Account ,2- Business Checking Account ,3- Mortgage Account, 4- Saving Account");
        int typeChoice = validateChoice(1,4);
        String accountType = "";
        switch(typeChoice){
            case 1 :
                accountType = "checkingAccount";
                break;
            case 2 :
                accountType = "businessCheckingAccount";
                break;
            case 3 :
                accountType = "mortgageAccount";
                break;
            case 4 :
                accountType = "savingAccount";
                break;
        }
    }
    //------case 3 ------
    private static void addClienToAccount() {
    }
    //------case 4 ------
    private static void showAllAcounts() {
        //sorted by the account num
    }
    //------case 5 ------
    private static void showProfitAcounts() {
        //sorted by the profit amount
    }
    //------case 6 ------
    private static void showAcountsByType() {
        //sorted by the account num
    }
    //------case 7 ------
    private static void showAnnualProfitOfSpecificAccount() {
    }
    //------case 8 ------
    private static void showAnnualProfitOfBank() {
        //only for checking account
    }
    //------case 9 ------
    private static void checkProfitVIP() {
        double profit = afekaBank.checkProfitVIP(afekaBank.accounts[0]);
    }
    //------case 10 ------
    private static void showMostProfitAccountOfBank() {
        //make sure its exists
    }
    //------case 11 ------
    private static void showManagementFees() {
        StringBuilder st = afekaBank.printManagementFees();
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

    //------Accounts------
    private static void addCheckingAccount() {
        System.out.println("What is the account number? (if you dont want to choice enter 0)");
        int accountNum =validateInputInt();
        if (accountNum == 0) {
            Random rand = new Random();
            accountNum = rand.nextInt(afekaBank.numOfAccounts * 2) + 1;
        }
        System.out.println("Enter the credit:");
        int credit = validateInputInt();
        System.out.println("what is the penguin height?");
        afekaBank.addAccount(accountNum, credit, "regular");
    }

    //-------Main------
    private static String showMenu() {
        System.out.println(Menu);
        System.out.println("Please enter your choice");
        return s.nextLine();
    }

    private static void init() {
    }
}
