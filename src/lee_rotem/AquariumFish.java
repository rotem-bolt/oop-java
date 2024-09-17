package lee_rotem;

import java.util.Arrays;

public class AquariumFish {
    private int age;
    private double length;
    private String[] colors;
    private String pattern;
    public double foodAmount;
    private static String[] colorsOptions = {"WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    private static String[] patternOptions = {"Dots", "Stripes", "Spots", "Smooth"};
    public AquariumFish(int age, double length, String pattern, String[] colors) {
        this.age = age;
        this.length = length;
        this.foodAmount = age >= 3 ? length + 3 : 3;
        this.colors = colors;
        this.pattern = pattern;
    }

    public String getFishDetails() {
        return "\nThe fish age is- " + age
                + ",length- " + length
                + ",pattern- " + pattern + ",colors: " + Arrays.toString(colors);
    }

    public static String[] getColorsOptions() {
        return colorsOptions;
    }
    public static String[] getPatternsOptions(){
        return patternOptions;
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
}

