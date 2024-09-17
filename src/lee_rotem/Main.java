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
            "4- Add new aquarium fish.\n" +
            "5- Show zoo penguins.\n" +
            "6- Show zoo lions.\n" +
            "7- Show zoo aquarium fish and colors.\n" +
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
                case 7 -> showFishDetails();
                case 8 -> feedZooAnimals();
            }
        } while (choice != 0);
    }
    //------case 0------
    private static void exitProgram() {
        System.out.println("Thanks for visiting the zoo, byeeee");
    }
    //------case 1------
    private static void showZooDetails() {
        System.out.println("The zoo name is: " +
                afekaZoo.getZooName() + "\nThe zoo address is: " +
                afekaZoo.getZooAddress() + "\nThe lions amount is: " +
                afekaZoo.getZooLionAmount() + "\nThe penguins amount is: " +
                afekaZoo.getZooPenguinsAmount() + "\nThe fish amount is: " +
                afekaZoo.getZooAquariumAmount());
    }
    //------case 2------
    private static void addNewPenguin() {
        s.nextLine();
        System.out.println("what is the penguin name?");
        String penguinName = s.nextLine();
        System.out.println("what is the penguin age?");
        int penguinAge = s.nextInt();
        System.out.println("what is the penguin height?");
        double penguinHeight = s.nextDouble();
        while(penguinHeight >= 200 && (afekaZoo.penguins[0].getPenguinIsLeader())){
            System.out.println("The penguin is higher then the leader please enter penguin height again");
            penguinHeight = s.nextDouble();
            s.nextLine();
        }
        if (afekaZoo.addPenguin(penguinName, penguinAge, penguinHeight , false)) {
            ;
            System.out.println("Penguin " + penguinName + " added to zoo.");
        }
        else {
            System.out.println("Penguin " + penguinName + " was not added to zoo, please check your values.");
        }
    }
    //------case 3------
    private static void addNewLion() {
        s.nextLine();
        System.out.println("what is the lion's name?");
        String lionName = s.nextLine();
        System.out.println("what is the lion's age?");
        int lionAge = s.nextInt();
        System.out.println("what is the lion's weight?");
        double lionHeight = s.nextDouble();
        s.nextLine();
        System.out.println("is it a female?(true/false)");
        boolean isFemale = s.nextBoolean();
        s.nextLine();
        if (afekaZoo.addLion(lionName, lionAge, lionHeight, isFemale)){
            System.out.println("Lion " + lionName + " added to zoo.");
        }
        else {
            System.out.println("Lion " + lionName + " was not added to zoo, please check your values.");
        }
    }
    //------case 4------
    private static String[] colorChoice(String color, String[] colors) {
        if(afekaZoo.isExistsInArr(colors,color)) {
            System.out.println("color was already chosen, please enter again.");
        }
        else {
            colors = Arrays.copyOf(colors, colors.length + 1);
            colors[colors.length - 1] = color;
        }
        return colors;
    }

    private static void addNewFish() {
        System.out.println("what is the fish age?");
        int fishAge = s.nextInt();
        System.out.println("what is the fish length?");
        double fishLength = s.nextDouble();
        System.out.println("what is the fish Pattern? \n1- Dots, 2- Stripes, 3- Spots, 4- Smooth");
        String fishPattern = s.nextLine();
        switch (fishPattern){
            case "1" -> fishPattern = "Dots";
            case "2" -> fishPattern = "Stripes";
            case "3" -> fishPattern = "Spots";
            case "4" -> fishPattern = "Smooth";
        }
        s.nextLine();
        System.out.println("what is the fish Colors?");
        String[] colors = new String[0];
        int choice;
        do {
            System.out.println("1-WHITE, 2-GREEN, 3-ORANGE, 4-BLUE, 5-YELLOW, 6-BROWN, 7-GOLD, 8-RED, 9-CYAN, 10-No more colors, ");
            choice = s.nextInt();
            switch (choice){
                case 1 -> colors = colorChoice("WHITE", colors);
                case 2 -> colors = colorChoice("GREEN", colors);
                case 3 -> colors = colorChoice("ORANGE", colors);
                case 4 -> colors = colorChoice("BLUE", colors);
                case 5 -> colors = colorChoice("YELLOW", colors);
                case 6 -> colors = colorChoice("BROWN", colors);
                case 7 -> colors = colorChoice("GOLD", colors);
                case 8 -> colors = colorChoice("RED", colors);
                case 9 -> colors = colorChoice("CYAN", colors);
            }
        } while (choice != 10 && colors.length>0 && colors.length < AquariumFish.getColorsOptions().length);
        if (afekaZoo.addAFish(fishAge, fishLength, fishPattern, colors)) {
            System.out.println("Fish added to zoo.");
        }
        else {
            System.out.println("Fish was not added to zoo, please check your values.");
        }
    }
    //------case 5------
    private static void showPenguin() {
        System.out.println("The zoo penguins details:\n");
        System.out.println(afekaZoo.getZooPenguinsDetails());
    }
    //------case 6------
    private static void showLion() {
        System.out.println("The zoo lions details:\n");
        System.out.println(afekaZoo.getZooLionDetails());
    }
    //------case 7------
    private static void showFishDetails() {
        System.out.println("The zoo Aquarium Fish details:\n");
        System.out.println(afekaZoo.getZooFishDetails());
    }
    //------case 8------
    private static void feedZooAnimals() {
        System.out.println("The penguins ate: " + afekaZoo.getZooPenguinsAmount() + " fishes.");
        System.out.println("\nThe lions ate: " + afekaZoo.foodForAllLions() + " kg.");
        System.out.println("\nThe fish ate: " + afekaZoo.foodForAllFish() + " dishes.");
    }

    private static int showMenu() {
        System.out.println(Menu);
        System.out.println("Please enter your choice");
        return s.nextInt();
    }

    private static void init() {
        afekaZoo.lions = new Lion[1];
        afekaZoo.aquariumFishes = new AquariumFish[1];
        afekaZoo.penguins = new Penguin[1];
        afekaZoo.addLion("Lior", 14, 150, true);
        afekaZoo.addLion("Lidor", 8, 120, false);
        afekaZoo.addLion("Lila", 7, 100, true);
        afekaZoo.addLion("Liam", 12, 190, false);
        afekaZoo.addPenguin("Pini", 25, 200, true);
        afekaZoo.addPenguin("Pnina", 18, 100, false);
        afekaZoo.addPenguin("Pinit", 21, 150, false);
        afekaZoo.addFishInAmount(10);
    }
}
