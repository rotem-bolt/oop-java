package lee_tsayeg_rotem_boltanski;

public class Lion {
    private String name;
    private int age;
    private double weight;
    private boolean isFemale;
    public int foodAmount;

    public Lion(String name, int age, double weight, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isFemale = isFemale;
        this.foodAmount = (int) (weight * age * (isFemale? 0.03 : 0.02));
        this.foodAmount = foodAmount > 25 ? 25 : foodAmount;
    }

    public String getLionDetails() {
        return "\nThe lion name is: " + name
                + "\nThe lion age is:  " + age
                + "\nThe lion weight: " + weight
                + "\nThe lion is" + (isFemale ? " a female\n\n" : " a male\n\n");
    }
    public static boolean setLionName(String name) {
        return name.length() >= 2;
    }
    public boolean setLionAge(int age) {
        return age > 0;
    }
    public boolean setLionWeight(double weight) {
        return weight > 0;
    }
}
