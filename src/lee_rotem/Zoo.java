package lee_rotem;
import java.util.Arrays;
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
// --------Penguins---------
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

    public String getZooPenguinsDetails() {
        StringBuilder penguinsDetails = new StringBuilder();
        for(int j = 0; j < penguins.length; j++ ) {
            penguinsDetails.append("Penguin number ");
            penguinsDetails.append((j + 1)).append(":\n");
            penguinsDetails.append(penguins[j].getPenguinDetails());
        }
        return penguinsDetails.toString();
    }

// --------Lions---------
    public void addLion(String name, int age, double height, boolean isFemale) {
        lions = Arrays.copyOf(this.lions, lions.length + 1);
        lions[lions.length - 1] = new Lion(name, age, height, isFemale);
    }

    public String getZooLionDetails() {
        StringBuilder lionsDetails = new StringBuilder();
        for(int j = 0; j < lions.length; j++ ) {
            lionsDetails.append("Lion number ").append(j + 1).append(":\n");
            lionsDetails.append(lions[j].getLionDetails());
        }
        return lionsDetails.toString();
    }

    public int foodForAllLions() {
        int allFood = 0;
        for (int i = 0; i < getZooLionAmount(); i++) {
            allFood += lions[i].foodAmount;
        }
        return allFood;
    }

// --------Fish---------
    public String[] colorsOptions(){
        return new String[] {"WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    }

    public String[] patternsOptions(){
        return new String[] {"Dots", "Stripes", "Spots", "Smooth"};
    }

    public String randomPattern(){
        Random R = new Random();
        String[] allPatterns = patternsOptions();
        return allPatterns[R.nextInt(allPatterns.length)];
    }

    public String[] randomColor(){
        Random R = new Random();
        int randomAmount = R.nextInt(colorsOptions().length -1) + 1;
        String[] allColors = colorsOptions();
        String[] randomColors = new String[0];
        for (int i = 0; i < randomAmount; i++) {
            int randomNum = R.nextInt(allColors.length);
            String color = allColors[randomNum];
            if (!isExistsInArr(randomColors, color)) {
                randomColors = Arrays.copyOf(randomColors, randomColors.length + 1);
                randomColors[randomColors.length - 1] = color;
            }
        }
        return randomColors;
    }

    public boolean isExistsInArr(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void addAFish(int age, double length, String pattern, String[] colors) {
        aquariumFishes = Arrays.copyOf(this.aquariumFishes, aquariumFishes.length + 1);
        aquariumFishes[aquariumFishes.length - 1] = new AquariumFish(age, length, pattern, colors);
    }

    public void addFishInAmount(int fishAmount) {
        for (int i = 0; i < fishAmount; i++) {
            Random r = new Random();
            int age = r.nextInt(100);
            double length = (double)r.nextInt(200);
            addAFish(age, length, randomPattern(),  randomColor());
        }
    }

    public String getZooFishDetails() {
        StringBuilder fishesDetails = new StringBuilder();
        String[] allFishesColors = new String[0];
        for(int j = 0; j < aquariumFishes.length; j++ ) {
            fishesDetails.append ("\nFish number " + (j+1) + ": " + aquariumFishes[j].getFishDetails());
            String[] fishColors = aquariumFishes[j].getFishColors();
            //sort the colors
            for (int i = 0; i < fishColors.length; i++) {
                if (!isExistsInArr(allFishesColors, fishColors[i])) {
                    allFishesColors = Arrays.copyOf(allFishesColors, allFishesColors.length + 1);
                    allFishesColors[allFishesColors.length - 1] = fishColors[i];
                }
            }
        }

        fishesDetails.append( "\nAll colors: " + Arrays.toString(allFishesColors) + "\n");
        return fishesDetails.toString();
    }


    // --------Zoo---------
    public int foodForAllFish() {
        int allFood = 0;
        for (int i = 0; i < getZooAquariumAmount(); i++) {
            allFood += aquariumFishes[i].foodAmount;
        }
        return allFood;
    }

    public String getZooName() {
        return this.name;
    }

    public String getZooAdress() {
        return this.address;
    }

    public int getZooLionAmount() {
        return this.lions.length;
    }

    public int getZooPenguinsAmount() {
        return this.penguins.length;
    }

    public int getZooAquariumAmount() {
        return this.aquariumFishes.length;
    }

}






