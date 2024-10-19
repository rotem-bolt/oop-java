package lee_tsayeg_rotem_boltanski;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Zoo {
    private String name;
    private String address;
    public Animal[] animals;
    private int numOfAnimals;
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
            animals = Arrays.copyOf(this.animals, this.animals.length * 2);
            animals[numOfAnimals++] = new Penguin(name, age , height , isLeader);
            numOfPenguins++;
            return true;
        }
        else {
            return false;
        }
    }

    public String getZooPenguinDetails(Penguin[] penguins) {
        StringBuilder penguinsDetails = new StringBuilder();
        int i = 1;
        for (Penguin penguin : penguins) {
            penguinsDetails.append("Penguin number ");
            penguinsDetails.append(i++).append(":\n");
            penguinsDetails.append(penguin.getAnimalDetails());
        }
        return penguinsDetails.toString();
    }

    public Penguin[] getSortedPenguins() {
        Penguin[] penguins = new Penguin[numOfPenguins];
        int i = 0;
        for (Animal animal : animals) {
            if (animal instanceof Penguin) {
                penguins[i++] = (Penguin) animal;
            }
            else if (animal == null) {
                break;
            }
        }
        Arrays.sort(penguins, new Comparator<Penguin>() {
            @Override
            public int compare(Penguin p1, Penguin p2) {
                return (int) (p2.getPenguinHeight() - p1.getPenguinHeight());
            }
        });
        return penguins;
    }

    public double getLeaderHeight() {
        for(Animal animal : animals) {
            if(animal instanceof Penguin) {
                if (((Penguin) animal).isLeader) {
                    return ((Penguin) animal).getPenguinHeight();
                }
            } else if (animal == null) {
                break;
            }
        }
        return 0;
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
            animals = Arrays.copyOf(this.animals, animals.length * 2);
            animals[numOfAnimals++] = new Tiger(name, age, weight, isFemale);
            numOfTigers++;
            numOfPredators++;
            return true;
        }
        else {
            return false;
        }
    }

// --------Lions---------
    public boolean addLion(String name, int age, double weight, boolean isFemale) {
        if (age > 0 && name.length() > 0 && weight > 0 ) {
            animals = Arrays.copyOf(this.animals, animals.length * 2);
            animals[numOfAnimals++] = new Lion(name, age, weight, isFemale);
            numOfLions++;
            numOfPredators++;
            return true;
        }
        else {
            return false;
        }
    }

// --------Fish---------

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
                animals = Arrays.copyOf(animals, animals.length * 2);
                animals[numOfAnimals++] = new GoldFish(age, length, colors, pattern);
                numOfGoldFishes++;
                numOfFishes++;
                return true;
            } else if (fishType == "Clown") {
                animals = Arrays.copyOf(animals, animals.length * 2);
                animals[numOfAnimals++] = new ClownFish(age, length, colors, pattern);
                numOfClownFishes++;
                numOfFishes++;
                return true;
            } else {
                animals = Arrays.copyOf(this.animals, animals.length * 2);
                animals[numOfAnimals++] = new AquariumFish(age, length, pattern, colors);
                numOfAquariumFishes++;
                numOfFishes++;
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
            int age = r.nextInt(8);
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
            allFishesColors = helperFishDetails(fishesDetails, allFishesColors, mostCommonColors, getAllAquariumFish());
        }

        if (getZooGoldAmount() > 0) {
            fishesDetails.append("\n\nGold Fishes:");
            allFishesColors = helperFishDetails(fishesDetails, allFishesColors, mostCommonColors, getAllGoldFish());
        }

        if (getZooClownAmount() > 0) {
            fishesDetails.append("\n\nClown Fishes:");
            allFishesColors = helperFishDetails(fishesDetails, allFishesColors, mostCommonColors, getAllClownFish());
        }

        fishesDetails.append( "\n\nAll colors: " + Arrays.toString(allFishesColors) + "\n");
        fishesDetails.append( "\n\nTwo most common colors: " + Arrays.toString(twoMaxInt(mostCommonColors, allFishesColors)) + "\n");
        return fishesDetails.toString();
    }

    public Fish[] getAllAquariumFish() {
        Fish[] allAquariumFish = new Fish[numOfAquariumFishes];
        for (int j = 0, i = 0; j < getZooAnimalAmount(); j++) {
            if (animals[j] instanceof AquariumFish) {
                allAquariumFish[i++] = (AquariumFish) animals[j];
            }
        }
        return allAquariumFish;
    }

    public Fish[] getAllGoldFish() {
        Fish[] allGoldFish = new Fish[numOfGoldFishes];
        for (int j = 0, i = 0; j < getZooAnimalAmount(); j++) {
            if (animals[j] instanceof GoldFish) {
                allGoldFish[i++] = (GoldFish) animals[j];
            }
        }
        return allGoldFish;
    }

    public Fish[] getAllClownFish() {
        Fish[] allClownFish = new Fish[numOfClownFishes];
        for (int j = 0, i = 0; j < getZooAnimalAmount(); j++) {
            if (animals[j] instanceof ClownFish) {
                allClownFish[i++] = (ClownFish) animals[j];
            }
        }
        return allClownFish;
    }

    public String[] helperFishDetails(StringBuilder fishesDetails, String[] allFishesColors, int[] mostCommonColors, Fish[] allFish) {
        for (int j = 0, k = 1; j < allFish.length; j++) {
            fishesDetails.append("\nFish number ").append(k++).append(": ").append( allFish[j].getAnimalDetails());
            String[] fishColors = allFish[j].getFishColors();
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
        return allFishesColors;
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

    private int getZooAnimalAmount() {
        return numOfAnimals;
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

    public String getZooAnimalDetails(Class type, int numOfType, String animalName) {
        StringBuilder animalsTypeDetails = new StringBuilder();
        if (numOfType > 0 ) {
            int i = 1;
            for (Animal animal : animals) {
                if (type.isInstance(animal)) {
                    animalsTypeDetails.append(animalName).append(" number ");
                    animalsTypeDetails.append(i++).append(":\n");
                    animalsTypeDetails.append(animal.getAnimalDetails());
                }
            }
        }
        return animalsTypeDetails.toString();
    }

    public int foodForAllAnimals(Class type) {
        int allFood = 0;
        for (Animal animal : animals) {
            if (type.isInstance(animal)) {
                allFood += animal.feed();
            }
        }
        return allFood;
    }

    public String getZooNoise() {
        StringBuilder n = new StringBuilder();
        n.append("\nAnimals make noise:");
        for (int i = 0; i < getZooAnimalAmount(); i++) {
            n.append(" ").append(animals[i].makeNoise());
        }
        return n.toString();
    }

    public boolean ageOneYear() {
        for (int i = 0; i < numOfAnimals; i++) {
            if (animals[i].getAnimalAge() > animals[i].getAnimalMaxAge()) {
                numOfAnimals--;
                animals = Arrays.copyOf(animals, i + 1);
                animals = Arrays.copyOf(animals, numOfAnimals);
            }
        }
        return true;
    }
}







