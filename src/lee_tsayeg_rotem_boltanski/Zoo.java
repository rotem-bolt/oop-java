package lee_tsayeg_rotem_boltanski;
import java.util.Arrays;
import java.util.Random;

public class Zoo {
    private String name;
    private String address;
    public Lion[] lions;
    public Tiger[] tigers;
    public AquariumFish[] aquariumFishes;
    public GoldFish[] goldFishes;
    public ClownFish[] clownFishes;
    public Penguin[] penguins;
    private int numOfPenguins;
    private int numOfLions;
    private int numOfTigers;
    private int numOfPredators;
    private int numOfAquariumFishes;
    private int numOfFishes;
    private int numOfGoldFishes;
    private int numOfClownFishes;
    public Zoo(String name, String address) {
        this.name = name;
        this.address = address;
    }
// --------Penguins---------
    public boolean addPenguin(String name, int age, double height , boolean isLeader) {
        if(age > 0 && height > 0 && name.length() > 0) {
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
        while(i < getZooPenguinsAmount()) {
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
    public int foodForAllPenguins() {
        int allFood = 0;
        for (int i = 0; i < getZooPenguinsAmount(); i++) {
            allFood += (int) penguins[i].feed();
        }
        return allFood;
    }
// --------Predators---------
    public boolean addPredator(int type, String name, int age, double weight, boolean isFemale) {
        if (type == 2) {
            return addLion(name, age, weight, isFemale);
        }
        else {
            return addTiger(name, age, weight, isFemale);
        }
    }

// --------Tigers---------
    public boolean addTiger(String name, int age, double weight, boolean isFemale) {
        if (age > 0 && name.length() > 0 && weight > 0 ) {
            tigers = Arrays.copyOf(this.tigers, tigers.length * 2);
            tigers[getZooTigerAmount()] = new Tiger(name, age, weight, isFemale);
            numOfTigers++;
            numOfPredators++;
            return true;
        }
        else {
            return false;
        }
    }

    public String getZooTigerDetails() {
        StringBuilder tigersDetails = new StringBuilder();
        for(int j = 0; j < getZooTigerAmount(); j++ ) {
            tigersDetails.append("Tiger number ").append(j + 1).append(":\n");
            tigersDetails.append(tigers[j].getPredatorsDetails());
        }
        return tigersDetails.toString();
    }

    public int foodForAllTigers() {
        int allFood = 0;
        for (int i = 0; i < getZooTigerAmount(); i++) {
            allFood += (int) tigers[i].feed();
        }
        return allFood;
    }
// --------Lions---------
    public boolean addLion(String name, int age, double weight, boolean isFemale) {
        if (age > 0 && name.length() > 0 && weight > 0 ) {
            lions = Arrays.copyOf(this.lions, lions.length * 2);
            lions[getZooLionAmount()] = new Lion(name, age, weight, isFemale);
            numOfLions++;
            numOfPredators++;
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
            lionsDetails.append(lions[j].getPredatorsDetails());
        }
        return lionsDetails.toString();
    }

    public int foodForAllLions() {
        int allFood = 0;
        for (int i = 0; i < getZooLionAmount(); i++) {
            allFood += (int) lions[i].feed();
        }
        return allFood;
    }

// --------Fish---------

    public int foodForAllClownFish() {
        double allFood = 0;
        for (int i = 0; i < getZooClownAmount(); i++) {
            allFood += clownFishes[i].feed();
        }
        return (int) allFood;
    }

    public int foodForAllAquariumFish() {
        double allFood = 0;
        for (int i = 0; i < getZooAquariumAmount(); i++) {
            allFood += aquariumFishes[i].feed();
        }
        return (int)allFood;
    }

    public int foodForAllGoldFish() {
        double allFood = 0;
        for (int i = 0; i < getZooGoldAmount(); i++) {
            allFood += goldFishes[i].feed();
        }
        return (int) allFood;
    }

    public String randomPattern(){
        Random R = new Random();
        String[] allPatterns = AquariumFish.getAquariumPatternsOptions();
        return allPatterns[R.nextInt(allPatterns.length)];
    }

    public String[] randomColor(){
        Random R = new Random();
        int randomAmount = R.nextInt(AquariumFish.getAquariumColorsOptions().length -1) + 1;
        String[] allColors = AquariumFish.getAquariumColorsOptions();
        String[] randomColors = new String[0];
        for (int i = 0; i < randomAmount; i++) {
            int randomNum = R.nextInt(allColors.length);
            String color = allColors[randomNum];
            int existsNum = isExistsInArr(randomColors, color);
            if (existsNum == -1) {
                randomColors = Arrays.copyOf(randomColors, randomColors.length + 1);
                randomColors[randomColors.length - 1] = color;
            }
        }
        return randomColors;
    }

    public int isExistsInArr(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAFish(String fishType, int age, double length, String pattern, String[] colors) {
        if(age > 0 && length > 0 && colors.length > 0) {
            if (fishType == "Gold") {
                goldFishes = Arrays.copyOf(goldFishes, goldFishes.length * 2);
                goldFishes[getZooGoldAmount()] = new GoldFish(age, length, colors, pattern);
                numOfGoldFishes++;
                numOfFishes++;
                return true;
            } else if (fishType == "Clown") {
                clownFishes = Arrays.copyOf(clownFishes, clownFishes.length * 2);
                clownFishes[getZooClownAmount()] = new ClownFish(age, length, colors, pattern);
                numOfClownFishes++;
                numOfFishes++;
                return true;
            } else {
                aquariumFishes = Arrays.copyOf(this.aquariumFishes, aquariumFishes.length * 2);
                aquariumFishes[getZooAquariumAmount()] = new AquariumFish(age, length, pattern, colors);
                numOfAquariumFishes++;
                return true;
            }
        }
        else {
            return false;
        }
    }

    public void addFishInAmount(int fishAmount) {
        for (int i = 0; i < fishAmount; i++) {
            Random r = new Random();
            int age = r.nextInt(100);
            int randType = r.nextInt(3);
            String fishType = Fish.getFishTypesOptions()[randType];
            double length = (double)r.nextInt(200);
            addAFish(fishType, age, length, randomPattern(),  randomColor());
        }
    }

    public String getZooFishDetails() {
        StringBuilder fishesDetails = new StringBuilder();
        String[] allFishesColors = new String[0];
        int[] mostCommonColors = new int[10];
        if (getZooAquariumAmount() > 0) {
            fishesDetails.append("\n\nAquarium Fishes:");
            for (int j = 0; j < getZooAquariumAmount(); j++) {
                fishesDetails.append("\nFish number ").append(j + 1).append(": ").append(aquariumFishes[j].getFishDetails());
                String[] fishColors = aquariumFishes[j].getFishColors();
                //sort the colors
                for (int i = 0; i < fishColors.length; i++) {
                    int existsNum = isExistsInArr(allFishesColors, fishColors[i]);
                    if (existsNum == -1) {
                        allFishesColors = Arrays.copyOf(allFishesColors, allFishesColors.length + 1);
                        allFishesColors[allFishesColors.length - 1] = fishColors[i];
                        mostCommonColors[allFishesColors.length - 1]++;
                    }
                    else {
                        mostCommonColors[existsNum]++;
                    }
                }
            }
        }

        if (getZooGoldAmount() > 0) {
            fishesDetails.append("\n\nGold Fishes:");
            for (int j = 0; j < getZooGoldAmount(); j++) {
                fishesDetails.append("\nFish number " + (j + 1) + ": " + goldFishes[j].getFishDetails());
                String[] fishColors = goldFishes[j].getFishColors();
                //sort the colors
                for (int i = 0; i < fishColors.length; i++) {
                    int existsNum = isExistsInArr(allFishesColors, fishColors[i]);
                    if (existsNum == -1) {
                        allFishesColors = Arrays.copyOf(allFishesColors, allFishesColors.length + 1);
                        allFishesColors[allFishesColors.length - 1] = fishColors[i];
                        mostCommonColors[allFishesColors.length - 1]++;
                    }
                    else {
                        mostCommonColors[existsNum]++;
                    }
                }
            }
        }

        if (getZooClownAmount() > 0) {
            fishesDetails.append("\n\nClown Fishes:");
            for (int j = 0; j < getZooClownAmount(); j++) {
                fishesDetails.append("\nFish number " + (j + 1) + ": " + clownFishes[j].getFishDetails());
                String[] fishColors = clownFishes[j].getFishColors();
                //sort the colors
                for (int i = 0; i < fishColors.length; i++) {
                    int existsNum = isExistsInArr(allFishesColors, fishColors[i]);
                    if (existsNum == -1) {
                        allFishesColors = Arrays.copyOf(allFishesColors, allFishesColors.length + 1);
                        allFishesColors[allFishesColors.length - 1] = fishColors[i];
                        mostCommonColors[allFishesColors.length - 1]++;
                    }
                    else {
                        mostCommonColors[existsNum]++;
                    }
                }
            }
        }

        fishesDetails.append( "\n\nAll colors: " + Arrays.toString(allFishesColors) + "\n");
        fishesDetails.append( "\n\nTwo most common colors: " + Arrays.toString(twoMaxInt(mostCommonColors, allFishesColors)) + "\n");
        return fishesDetails.toString();
    }

    private String[] twoMaxInt(int[] mostCommonColors, String[] allFishesColors) {
        if (allFishesColors.length < 2){
            return allFishesColors;
        }
        int max1 = 0, max1Index = 0, max2 = 0, max2Index = 0;
        String[] twoMaxColors = new String[2];
        for (int i = 0; i < mostCommonColors.length; i++) {
            if (mostCommonColors[i] >= max1) {
                max2 = max1;
                max2Index = max1Index;
                max1 = mostCommonColors[i];
                max1Index = i;
            } else if (mostCommonColors[i] >= max2) {
                max2 = mostCommonColors[i];
                max2Index = i;
            }
        }
        twoMaxColors[0] = allFishesColors[max1Index];
        twoMaxColors[1] = allFishesColors[max2Index];
        return twoMaxColors;
    }


    // --------Zoo---------

    public String getZooName() {
        return this.name;
    }

    public String getZooAddress() {
        return this.address;
    }

    public int getZooLionAmount() {
        return this.numOfLions;
    }

    public int getZooTigerAmount() {
        return this.numOfTigers;
    }

    public int getZooPenguinsAmount() {
        return this.numOfPenguins;
    }

    public int getZooAquariumAmount() {
        return this.numOfAquariumFishes;
    }

    public int getZooGoldAmount() {
        return this.numOfGoldFishes;
    }

    public int getZooClownAmount() {
        return this.numOfClownFishes;
    }

    public String getZooNoise() {
        StringBuilder n = new StringBuilder();
        n.append("\nAnimals make noise:");
        if(getZooClownAmount() > 0) {
            for (int i = 0; i < getZooClownAmount(); i++) {
                n.append(" ").append(clownFishes[i].makeNoise());
            }
        }
        if(getZooGoldAmount() > 0) {
            for (int i = 0; i < getZooGoldAmount(); i++) {
                n.append(" ").append(goldFishes[i].makeNoise());
            }
        }
        if (getZooAquariumAmount() > 0) {
            for (int i = 0; i < getZooAquariumAmount(); i++) {
                n.append(" ").append(aquariumFishes[i].makeNoise());
            }
        }
        if (getZooLionAmount() > 0) {
            for (int i = 0; i < getZooLionAmount(); i++) {
                n.append(" ").append(lions[i].makeNoise());
            }
        }
        if (getZooTigerAmount() > 0) {
            for (int i = 0; i < getZooTigerAmount(); i++) {
                n.append(" ").append(tigers[i].makeNoise());
            }
        }
        if (getZooPenguinsAmount() > 0) {
            for (int i = 0; i < getZooPenguinsAmount(); i++) {
                n.append(" ").append(penguins[i].makeNoise());
            }
        }
        return n.toString();
    }
}






