package lee_rotem;

import java.util.Arrays;
import java.util.Random;

public class AquariumFish {
    public int age;
    public double length;
    public String[] colors;
    public String pattern;
    public double foodAmount;

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

    public String[] getFishColors() {
        return colors;
    }
}
