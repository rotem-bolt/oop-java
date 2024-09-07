package lee_rotem;

import java.util.Arrays;

public class Zoo {
    public String name;
    public String address;
    public Lion[] lions;
    public AquariumFish[] aquariumFishes;
    public Penguin[]
            penguins;
    public Zoo() {
        this.lions = new Lion[4];
        this.aquariumFishes = new AquariumFish[10];
        this.penguins = new Penguin[3];
        this.name = "Ramat Gan Zoo";
        this.address = "Afeka";
        penguins[0] = new Penguin("Pini", 25, 200, true);
        penguins[1] = new Penguin("Pinit", 21, 150, false);
        penguins[2] = new Penguin("Pnina", 18, 100, false);
        lions[0] = new Lion("Lior", 14, 150, true);
        lions[1] = new Lion("Lila", 7, 100, true);
        lions[2] = new Lion("Liam", 12, 190, false);
        lions[3] = new Lion("Lidor", 8, 120, false);
//        AquariumFish.addFish(this, 10);
    }

    public void addPenguin(String name, int age, double height) {
        new Penguin(name, age, height, false);
//        fix the sorting of the penguins
    }

    public void addLion(String name, int age, double height, boolean isFemale) {
        lions = Arrays.copyOf(this.lions, lions.length + 1);
        lions[lions.length - 1] = new Lion(name, age, height, isFemale);
    }

    public String getZooPenguinsDetails() {
        String penguinsDetails = "";
        for(int j = 0; j < penguins.length; j++ ) {
            penguinsDetails += "Penguin number " + (j+1) + ":\n";
            penguinsDetails += penguins[j].getPenguinDetails();
        }
        return penguinsDetails;
    }

    public String getZooLionDetails() {
        String lionsDetails = "";
        for(int j = 0; j < lions.length; j++ ) {
            lionsDetails += "Lion number " + (j+1) + ":\n";
            lionsDetails += lions[j].getLionDetails();
        }
        return lionsDetails;
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
}
