//lee tsayeg and rotem boltanski - zoo task 1
package lee_rotem;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    private static Zoo afekaZoo = new Zoo("Ramat Gan Zoo","Afeka");
    public final static String Menu = "\n0- Exit zoo.\n" +
            "1- Show zoo details.\n" +
            "2- Add new penguin.\n" +
            "3- Add new lion.\n" +
            "4- Add new aquariom fidh.\n" +
            "5- Show zoo penguins details.\n" +
            "6- Show zoo lions.\n" +
            "7- Show aquarium fish and colors.\n" +
            "8- Feed all zoo animals.\n";
    public static void main(String[] args) {
        init();
        run();
        }
    private static void run() {
        int choice;
        do {
            choice = showMenu();
            switch (choice){
                case 0 -> exitProgram();
                case 1 -> showZooDetails();
                case 2 -> addNewPenguin();
                case 3 -> addNewLion();
                case 4 -> addNewFish();
                case 5 -> showPenguin();
                case 6 -> showLion();
                case 7 -> showFishDetalis();
                case 8 -> feedZooAnimals();
            }
        }while (choice != 0);
    }

    private static void feedZooAnimals() {
        System.out.println("The penguins ate: " + afekaZoo.penguins.length);
        System.out.println("\nThe lions ate: " + afekaZoo.foodForAllLions());
//                    System.out.println("\nThe fish ate: " + afekaZoo.foodForAllFish());
    }

    private static void showFishDetalis() {
    }

    private static void showLion() {
        System.out.println("The zoo lions details:\n");
        System.out.println(afekaZoo.getZooLionDetails());
    }

    private static void showPenguin() {
        System.out.println("The zoo penguins details:\n");
        System.out.println(afekaZoo.getZooPenguinsDetails());
    }

    private static void addNewFish() {
        System.out.println("what is the fish age?");
        int fishAge = s.nextInt();
        System.out.println("what is the fish length?");
        double fishLength = s.nextDouble();
            System.out.println("what is the fish Pattern? 1. Dots, 2. Stripes, 3. Spots, 4. Smooth");
            String fishPattern = s.nextLine();
            switch (fishPattern){
            case "1" -> fishPattern = "Dots";
            case "2" -> fishPattern = "Stripes";
            case "3" -> fishPattern = "Spots";
            case "4" -> fishPattern = "Smooth";
            default -> System.out.println("Invalid choice");
            } while (true);
    }




    }

    private static void addNewLion() {
        s.nextLine();
        System.out.println("what is the lion's name?");
        String lionName = s.nextLine();
        System.out.println("what is the lion's age?");
        int lionAge = s.nextInt();
        System.out.println("what is the lion's weight?");
        double lionHeight = s.nextDouble();
        s.nextLine();
        System.out.println("is it a female?");
        boolean isFemale = s.nextBoolean();
        s.nextLine();
        afekaZoo.addLion(lionName, lionAge, lionHeight, isFemale);
        System.out.println("Lion " + lionName + " added to zoo.");

    }

    private static void addNewPenguin() {
        s.nextLine();
        System.out.println("what is the penguin name?");
        String penguinName = s.nextLine();
        System.out.println("what is the penguin age?");
        int penguinAge = s.nextInt();
        System.out.println("what is the penguin height?");
        double penguinHeight = s.nextDouble();
        while(penguinHeight >= 200){
            System.out.println("The penguin is higher then the leader please enter penguin weight again");
            penguinHeight = s.nextDouble();
            s.nextLine();
        }
        afekaZoo.addPenguin(penguinName, penguinAge, penguinHeight , false);
        System.out.println("Penguin " + penguinName + " added to zoo.");
    }

    private static void showZooDetails() {
        System.out.println("The zoo name is: " +
                afekaZoo.name + "\nThe zoo address is: " +
                afekaZoo.address + "\nThe lions amount is: " +
                afekaZoo.lions.length + "\nThe penguins amount is: " +
                afekaZoo.penguins.length + "\nThe fish amount is: " +
                afekaZoo.aquariumFishes.length);
    }

    private static void exitProgram() {
        System.out.println("Thanks for visiting the zoo, byeeee");
    }

    private static int showMenu() {
        System.out.println(Menu);
        System.out.println("Please enter your choice");
        return s.nextInt();
    }

    private static void init() {
        afekaZoo.lions = new Lion[0];
        afekaZoo.aquariumFishes = new AquariumFish[10];
        afekaZoo.penguins = new Penguin[0];
        afekaZoo.addLion("Lior", 14, 150, true);
        afekaZoo.addLion("Lidor", 8, 120, false);
        afekaZoo.addLion("Lila", 7, 100, true);
        afekaZoo.addLion("Liam", 12, 190, false);
        afekaZoo.addPenguin("Pini", 25, 200, true);
        afekaZoo.addPenguin("Pnina", 18, 100, false);
        afekaZoo.addPenguin("Pinit", 21, 150, false);
//        AquariumFish.addFish(this, 10);
    }
}
