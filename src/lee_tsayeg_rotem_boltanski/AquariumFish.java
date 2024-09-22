package lee_tsayeg_rotem_boltanski;

import java.util.Arrays;

public class AquariumFish extends Fish {
    private static enum colorsOptions {WHITE, GREEN, ORANGE, BLUE, YELLOW, BROWN, GOLD, RED, CYAN};
    private static enum patternOptions {Dots, Stripes, Spots, Smooth};
    public AquariumFish(int age, double length, String pattern, String[] colors) {
        super(age, length, pattern, colors);
        this.foodAmount = age >= 3 ? length + 3 : 3;
        this.colors = colors;
        this.pattern = pattern;
    }

    public String[] getFishColors() {
        return colors;
    }

    public boolean setFishAge(int age) {
        return age > 0;
    }
    public boolean setFishLength(double length) {
        return length > 0;
    }

    public String makeNoise() {
        return "blob";
    }
}

