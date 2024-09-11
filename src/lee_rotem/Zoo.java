package lee_rotem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Zoo {
    public String name;
    public String address;
    public Lion[] lions;
    public AquariumFish[] aquariumFishes;
    public Penguin[] penguins;
    public Zoo(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addPenguin(String name, int age, double height , boolean isLeader) {
        penguins = Arrays.copyOf(this.penguins, penguins.length + 1);
        penguins[isLeader? 0 : sortPenguin(height)] = new Penguin(name, age , height , isLeader);
    }

    private int sortPenguin(double height) {
        int i = 1;
        while(i < penguins.length - 2) {
            if(penguins[i].getPenguinHeight() < height) {
                break;
            }
            i ++;
        }
        for(int j = penguins.length - 1; j > i; j--) {
            penguins[j] = penguins[j - 1];
        }
        return i;
    }

    public void addLion(String name, int age, double height, boolean isFemale) {
        lions = Arrays.copyOf(this.lions, lions.length + 1);
        lions[lions.length - 1] = new Lion(name, age, height, isFemale);
    }

    public String getZooPenguinsDetails() {
        StringBuilder penguinsDetails = new StringBuilder();
        for(int j = 0; j < penguins.length; j++ ) {
            penguinsDetails.append("Penguin number ");
            penguinsDetails.append((j + 1)).append(":\n");
            penguinsDetails.append(penguins[j].getPenguinDetails());
        }
        return penguinsDetails.toString();
    }

    public String getZooLionDetails() {
        StringBuilder lionsDetails = new StringBuilder();
        for(int j = 0; j < lions.length; j++ ) {
            lionsDetails.append("Lion number ").append(j + 1).append(":\n");
            lionsDetails.append(lions[j].getLionDetails());
        }
        return lionsDetails.toString();
    }

    public String getZooFishDetails() {
        String fishesDetails = "";
        for(int j = 0; j < aquariumFishes.length; j++ ) {
            fishesDetails += "Fish number " + (j+1) + ":\n";
            fishesDetails += aquariumFishes[j].getFishDetails();
        }
        return fishesDetails;
    }

    public int foodForAllLions() {
        int allFood = 0;
        for (int i = 0; i < lions.length; i++) {
            allFood += lions[i].foodAmount;
        }
        return allFood;
    }

    public int foodForAllFish() {
        int allFood = 0;
        for (int i = 0; i < aquariumFishes.length; i++) {
            allFood += aquariumFishes[i].foodAmount;
        }
        return allFood;
    }
    public String randomPattern(){
        Random R = new Random();
        String[] allPatterns = patternsOptions();
        return allPatterns[R.nextInt(allPatterns.length)];
    }
    public String[] randomColor(){
        Random R = new Random();
        String[] allColors = colorsOptions();
        int colorAmount = R.nextInt(allColors.length) + 1;
        String[] fishColors = new String[colorAmount];
        int [] randomNumbers = new int[colorAmount];
        for(int i = 0; i < colorAmount -1; i++) {
            int number = R.nextInt(allColors.length);
            do {
                randomNumbers[i] = R.nextInt(allColors.length);
            } while ( for ());

        }

    public String[] colorsOptions(){
        return new String[] {"WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    }

    public String[] patternsOptions(){
        return new String[] {"Dots", "Stripes", "Spots", "Smooth"};
    }

}




