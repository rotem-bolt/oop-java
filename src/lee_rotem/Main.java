//lee tsayeg and rotem boltanski - zoo task 1
package lee_rotem;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Zoo afekaZoo = new Zoo();
        boolean running = true;
        String menu = "\n0- Exit zoo.\n" +
                "1- Show zoo details.\n" +
                "2- Add new penguin.\n" +
                "3- Add new lion.\n" +
                "4- Add new aquariom fidh.\n" +
                "5- Show zoo penguins details.\n" +
                "6- Show zoo lions.\n" +
                "7- Show aquarium fish and colors.\n" +
                "8- Feed all zoo animals.\n";
        while (running) {
            System.out.println(menu);
            String userChoice = s.nextLine();
            switch (userChoice) {
                case "0":
                    System.out.println("Thanks for visiting the zoo, byeeee");
                    running = false;
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("The zoo name is: " +
                            afekaZoo.name + "\nThe zoo address is: " +
                            afekaZoo.address + "\nThe lions amount is: " +
                            afekaZoo.lions.length + "\nThe penguins amount is: " +
                            afekaZoo.penguins.length + "\nThe fish amount is: " +
                            afekaZoo.aquariumFishes.length);
                    break;
                case "2":
                    System.out.println("what is the penguin name?");
                    String penguinName = s.nextLine();
                    System.out.println("what is the penguin age?");
                    int penguinAge = s.nextInt();
                    System.out.println("what is the penguin height?");
                    double penguinHeight = s.nextDouble();
                    s.nextLine();
                    afekaZoo.addPenguin(penguinName, penguinAge, penguinHeight);
                    System.out.println("Penguin " + penguinName + " added to zoo.");
                    break;
                case "3":
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
                    break;
                case "4":
                    System.out.println("what is the fish age?");
                    int fishAge = s.nextInt();
                    System.out.println("what is the fish length?");
                    double fishLength = s.nextDouble();
//                    need more work
                case "5":
                    System.out.println("The zoo penguins details:\n");
                    System.out.println(afekaZoo.getZooPenguinsDetails());
                    break;
                case "6":
                    System.out.println("The zoo lions details:\n");
                    System.out.println(afekaZoo.getZooLionDetails());
                    break;
                case "7":
                    System.out.println("The zoo fish details:\n");
                    System.out.println(afekaZoo.getZooFishDetails());
                    break;
                case "8":
                    System.out.println("The penguins ate: " + afekaZoo.penguins.length);
                    System.out.println("\nThe lions ate: " + afekaZoo.foodForAllLions());
//                    System.out.println("\nThe fish ate: " + afekaZoo.foodForAllFish());
                    break;
                default:
                    System.out.println("Invalid choice, please try again");

            }
        }
    }
}
