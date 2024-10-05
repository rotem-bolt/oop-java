//lee tsayeg and rotem boltanski - zoo task 1
package lee_tsayeg_rotem_boltanski;
import lee_tsayeg_rotem_boltanski.exceptions.HigherThanPenguinLeaderException;
import lee_tsayeg_rotem_boltanski.exceptions.InvalidFieldValueException;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    private static Zoo afekaZoo = new Zoo("Ramat Gan Zoo","Afeka");
    public final static String Menu = "\n0- Exit zoo.\n" +
            "1- Show zoo details.\n" +
            "2- Add new penguin.\n" +
            "3- Add new carnivore.\n" +
            "4- Add new fish.\n" +
            "5- Show zoo penguins.\n" +
            "6- Show zoo carnivores.\n" +
            "7- Show zoo fish and colors.\n" +
            "8- Feed all zoo animals.\n"+
            "9 - Show zoo animals noise.\n";

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
                case 3 -> addNewPredator();
                case 4 -> addNewFish();
                case 5 -> showPenguin();
                case 6 -> showPredators();
                case 7 -> showFishDetails();
                case 8 -> feedZooAnimals();
                case 9 -> animalMakeNoise();
            }
        } while (choice != 0);
    }


    //------case 0------
    private static void exitProgram() {
        System.out.println("Thanks for visiting the zoo, byeeee");
    }
    //------case 1------
    private static void showZooDetails() {
        System.out.println("The zoo name is: " + afekaZoo.getZooName() +
                "\nThe zoo address is: " + afekaZoo.getZooAddress() +
                "\nThe lions amount is: " + afekaZoo.getZooLionAmount() +
                "\nThe tigers amount is: " + afekaZoo.getZooTigerAmount() +
                "\nThe penguins amount is: " + afekaZoo.getZooPenguinsAmount() +
                "\nThe aquarium fish amount is: " + afekaZoo.getZooAquariumAmount() +
                "\nThe gold fish amount is: " + afekaZoo.getZooGoldAmount() +
                "\nThe clown fish amount is: " + afekaZoo.getZooClownAmount());
    }
    //------case 2------
    private static void addNewPenguin() {
        s.nextLine();
        System.out.println("what is the penguin name?");
        String penguinName = s.nextLine();
        System.out.println("what is the penguin age?");
        int penguinAge;
        while (true) {
            try {
                penguinAge = s.nextInt();
                s.nextLine();
                if (penguinAge > 0) {
                    throw new InvalidFieldValueException(" Entered height: " + penguinAge);
                }
                break;
            } catch (HigherThanPenguinLeaderException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid penguin height lower than the leader");
            }
        }

        System.out.println("what is the penguin height?");
        double penguinHeight;
        while (true) {
            try {
                penguinHeight = s.nextDouble();
                s.nextLine();
                if (penguinHeight >= 200 && afekaZoo.penguins[0].getPenguinIsLeader()) {
                    throw new HigherThanPenguinLeaderException(" Entered height: " + penguinHeight);
                }
                break;
            } catch (HigherThanPenguinLeaderException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid penguin height lower than the leader");
            }
        }
        afekaZoo.addPenguin(penguinName, penguinAge, penguinHeight, false);
        System.out.println("Penguin " + penguinName + " added to zoo.");
    }

    private static void validateAge(int penguinAge) {

    }

    //------case 3------
    private static void addNewPredator() {
        s.nextLine();
        System.out.println("what is the predator name?");
        String lionName = s.nextLine();
        System.out.println("what is the predator age?");
        int lionAge = s.nextInt();
        System.out.println("what is the predator weight?");
        double lionWeight = s.nextDouble();
        s.nextLine();
        System.out.println("is it a female?(true/false)");
        boolean isFemale = s.nextBoolean();
        s.nextLine();
        System.out.println("choose the carnivore type: 1- Tiger, 2- Lion (enter the number):");
        int type = s.nextInt();
        s.nextLine();
        if (afekaZoo.addPredator(type, lionName, lionAge, lionWeight, isFemale)){
            System.out.println("Carnivore " + lionName + " added to zoo.");
        }
        else {
            System.out.println("Carnivore " + lionName + " was not added to zoo, please check your values.");
        }
    }
    //------case 4------
    private static String[] colorChoice(String color, String[] colors) {
        if(afekaZoo.isExistsInArr(colors,color) != -1) {
            System.out.println("color was already chosen, please enter again.");
        }
        else {
            colors = Arrays.copyOf(colors, colors.length + 1);
            colors[colors.length - 1] = color;
        }
        return colors;
    }

    private static void addNewFish() {
        s.nextLine();
        System.out.println("what is the fish type? \n1- Gold, 2- Clown, 3- Aquarium");
        String fishType = s.nextLine();
        switch (fishType){
            case "1" -> fishType = "Gold";
            case "2" -> fishType = "Clown";
            case "3" -> fishType = "Aquarium";
        }
        System.out.println("what is the fish age?");
        int fishAge = s.nextInt();
        System.out.println("what is the fish length?");
        double fishLength = s.nextDouble();
        String fishPattern;
        if (fishType.equals("Aquarium")) {
            System.out.println("what is the fish Pattern? \n1- Dots, 2- Stripes, 3- Spots, 4- Smooth");
            fishPattern = s.nextLine();
            switch (fishPattern) {
                case "1" -> fishPattern = "Dots";
                case "2" -> fishPattern = "Stripes";
                case "3" -> fishPattern = "Spots";
                case "4" -> fishPattern = "Smooth";
            }
            s.nextLine();
        } else if (fishType.equals("Gold")) {
            fishPattern = "Smooth";
        } else {
            fishPattern = "Stripes";
        }
        String[] colors = new String[0];
        int choice;
        if (fishType.equals("Aquarium")) {
            do {
                System.out.println("what is the fish Colors?");
                System.out.println("1-WHITE, 2-GREEN, 3-ORANGE, 4-BLUE, 5-YELLOW, 6-BROWN, 7-GOLD, 8-RED, 9-CYAN, 10-No more colors, ");
                choice = s.nextInt();
                switch (choice) {
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
            } while (choice != 10 && colors.length > 0 && colors.length < AquariumFish.getAquariumColorsOptions().length);
        } else if (fishType.equals("Gold")) {
            do {
                System.out.println("1-ORANGE, 2-YELLOW, 6-BLACK, 4-GOLD, 5-No more colors, ");
                choice = s.nextInt();
                switch (choice) {
                    case 1 -> colors = colorChoice("ORANGE", colors);
                    case 2 -> colors = colorChoice("YELLOW", colors);
                    case 3 -> colors = colorChoice("BLACK", colors);
                    case 4 -> colors = colorChoice("GOLD", colors);
                }
            } while (choice != 5 && colors.length > 0 && colors.length < GoldFish.getGoldColorsOptions().length);
        } else {
            colors = Arrays.copyOf(colors, colors.length + 3);
            colors[0] = "ORANGE";
            colors[1] = "BLACK";
            colors[2] = "WHITE";
            }
        if (afekaZoo.addAFish(fishType, fishAge, fishLength, fishPattern, colors)) {
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
    private static void showPredators() {
        showLion();
        showTiger();
    }

    private static void showLion() {
        System.out.println("The zoo Lions details:\n");
        System.out.println(afekaZoo.getZooLionDetails());
    }

    private static void showTiger() {
        if (afekaZoo.getZooTigerAmount() > 0) {
            System.out.println("The zoo Tigers details:\n");
            System.out.println(afekaZoo.getZooTigerDetails());
        }
    }
    //------case 7------
    private static void showFishDetails() {
        System.out.println("The zoo Aquarium Fish details:\n");
        System.out.println(afekaZoo.getZooFishDetails());
    }
    //------case 8------
    private static void feedZooAnimals() {
        System.out.println("The penguins ate: " + afekaZoo.getZooPenguinsAmount() + " fishes.");
        System.out.println("\nThe lions ate: " + afekaZoo.foodForAllPredators() + " kg.");
        System.out.println("\nThe fish ate: " + afekaZoo.foodForAllFish() + " dishes.");
    }
    //------case 9------
    private static void animalMakeNoise() {
        System.out.println(afekaZoo.getZooNoise());
    }

    private static int showMenu() {
        System.out.println(Menu);
        System.out.println("Please enter your choice");
        return s.nextInt();
    }

    private static void init() {
        afekaZoo.tigers = new Tiger[1];
        afekaZoo.lions = new Lion[1];
        afekaZoo.aquariumFishes = new AquariumFish[1];
        afekaZoo.goldFishes = new GoldFish[1];
        afekaZoo.clownFishes = new ClownFish[1];
        afekaZoo.penguins = new Penguin[1];
        afekaZoo.addPredator( 2, "Lior", 14, 150, true);
        afekaZoo.addPredator( 2, "Lidor", 8, 120, false);
        afekaZoo.addPredator( 2, "Lila", 7, 100, true);
        afekaZoo.addPredator( 2, "Liam", 12, 190, false);
        afekaZoo.addPenguin("Pini", 25, 200, true);
        afekaZoo.addPenguin("Pnina", 18, 100, false);
        afekaZoo.addPenguin("Pinit", 21, 150, false);
        afekaZoo.addFishInAmount(10);
    }
}
