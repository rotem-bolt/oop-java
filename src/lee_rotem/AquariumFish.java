package lee_rotem;

public class AquariumFish {
    public int age;
    public double length;
    enum eColors {
        BLACK, WHITE, GREEN, ORANGE, BLUE, YELLOW, BROWN, GOLD, RED, CYAN
    }
    enum ePatterns {
        Dots, Stripes, Spots, Smooth
    }
    public eColors[] colors;
    public ePatterns pattern;
    public double foodAmount;

    public AquariumFish(int age, double length, ePatterns pattern, eColors[] colors) {
        this.age = age;
        this.length = length;
        this.pattern = ePatterns.Dots;
        this.colors = new eColors[0];
        this.foodAmount = age >= 3 ? length + 3 : 3;
    }

    public static void addFish(Zoo zoo, int fishAmount) {
        for(int i = 0; i < fishAmount; i++) {
            ePatterns[] patternsOptions = ePatterns.values();
            int randPattern = (int) (Math.random()*4);
            eColors[] colorsOptions = eColors.values();
            int randColorAmount = (int) (Math.random()*10);
            eColors[] fishColors = new eColors[randColorAmount+1];
//            for(int j = 0; j < randColorAmount; j++) {
//                zoo.aquariumFishes[i] = fishColors[j] = colorsOptions[(int) (Math.random()*10)];
//            }
            new AquariumFish((int) (Math.random()*101), Math.random()*101, patternsOptions[randPattern], fishColors);
        }
    }

    public String getFishDetails() {
        return "\nThe fish age is:  " + age
                + "\nThe fish length: " + length
                + "\nThe fish pattern: " + pattern + "\n\n";
    }
}
