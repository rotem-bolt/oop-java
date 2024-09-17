package lee_rotem;
import java.util.Arrays;
import java.util.Random;

public class Zoo {
    private String name;
    private String address;
    public Lion[] lions;
    public AquariumFish[] aquariumFishes;
    public Penguin[] penguins;
    private int numOfPenguins;
    private int numOfLions;
    private int numOfAquariumFishes;
    public Zoo(String name, String address) {
        this.name = name;
        this.address = address;
        this.numOfPenguins = 0;
        this.numOfLions = 0;
        this.numOfAquariumFishes = 0;
    }
// --------Penguins---------
    public boolean addPenguin(String name, int age, double height , boolean isLeader) {
        if(Penguin.setPenguinAge(age) && Penguin.setPenguinHeight(height) && Penguin.setPenguinName(name)) {
            penguins = Arrays.copyOf(this.penguins, this.penguins.length * 2);
            penguins[isLeader ? 0 : sortPenguin(height)] = new Penguin(name, age , height , isLeader);
            numOfPenguins++;
            return true;
        }
        else {
            return false;
        }
    }

    private int sortPenguin(double height) {
        int i = 1;
        while(i < getZooPenguinsAmount() - 2) {
            if(penguins[i].getPenguinHeight() < height) {
                break;
            }
            i ++;
        }
        for(int j = getZooPenguinsAmount(); j > i; j--) {
            penguins[j] = penguins[j - 1];
        }
        return i;
    }

    public String getZooPenguinsDetails() {
        StringBuilder penguinsDetails = new StringBuilder();
        for(int j = 0; j < getZooPenguinsAmount() ; j++ ) {
            penguinsDetails.append("Penguin number ");
            penguinsDetails.append((j + 1)).append(":\n");
            penguinsDetails.append(penguins[j].getPenguinDetails());
        }
        return penguinsDetails.toString();
    }

// --------Lions---------
    public boolean addLion(String name, int age, double height, boolean isFemale) {
        if (Lion.setLionAge(age) && Lion.setLionName(name) && Lion.setLionWeight(height)) {
            lions = Arrays.copyOf(this.lions, lions.length * 2);
            lions[getZooLionAmount()] = new Lion(name, age, height, isFemale);
            numOfLions++;
            return true;
        }
        else {
            return false;
        }
    }

    public String getZooLionDetails() {
        StringBuilder lionsDetails = new StringBuilder();
        for(int j = 0; j < getZooLionAmount(); j++ ) {
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

    public String randomPattern(){
        Random R = new Random();
        String[] allPatterns = AquariumFish.getPatternsOptions();
        return allPatterns[R.nextInt(allPatterns.length)];
    }

    public String[] randomColor(){
        Random R = new Random();
        int randomAmount = R.nextInt(AquariumFish.getColorsOptions().length -1) + 1;
        String[] allColors = AquariumFish.getColorsOptions();
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

    public boolean addAFish(int age, double length, String pattern, String[] colors) {
        if(AquariumFish.setFishAge(age) && AquariumFish.setFishLength(length)) {
            aquariumFishes = Arrays.copyOf(this.aquariumFishes, aquariumFishes.length * 2);
            aquariumFishes[getZooAquariumAmount()] = new AquariumFish(age, length, pattern, colors);
            numOfAquariumFishes++;
            return true;
        }
        else {
            return false;
        }
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
        for(int j = 0; j < getZooAquariumAmount() ; j++ ) {
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
            allFood += (int) aquariumFishes[i].foodAmount;
        }
        return allFood;
    }

    public String getZooName() {
        return this.name;
    }

    public String getZooAddress() {
        return this.address;
    }

    public int getZooLionAmount() {
        return this.numOfLions;
    }

    public int getZooPenguinsAmount() {
        return this.numOfPenguins;
    }

    public int getZooAquariumAmount() {
        return this.numOfAquariumFishes;
    }

}






