package lee_tsayeg_rotem_boltanski;

import java.util.Arrays;

public abstract class Fish extends Animal {
    protected int age;
    protected double length;
    protected String[] colors;
    public static String[] fishTypes = {"Gold", "Clown", "Aquarium"};
    protected String pattern;
    protected double foodAmount = 1;

    public Fish(int age, double length, String pattern, String[] colors) {
        this.age = age;
        this.length = length;
        this.pattern = pattern;
        this.colors = colors;
    }

    @Override
    public String getAnimalDetails() {
        return "\nThe fish age is- " + age
                + ",length- " + length
                + ",pattern- " + pattern + ",colors: " + Arrays.toString(colors);
    }

    public static String[] getFishTypesOptions() {
        return fishTypes;
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

    @Override
    public double feed() {
        return foodAmount;
    }

    @Override
    public String makeNoise() {
        return "blob";
    }
}

