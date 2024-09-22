package lee_tsayeg_rotem_boltanski;

public class Lion extends Carnivores{

    public Lion(String name, int age, double weight, boolean isFemale) {
        super(name, age, weight, isFemale);
    }

    @Override
    public double getFoodAmount() {
        this.foodAmount =  weight * age * (isFemale? 0.03 : 0.02);
        this.foodAmount = foodAmount > 25 ? 25 : foodAmount;
        return this.foodAmount;
    }

    @Override
    public String getCarnivorDetails() {
        return "\nThe lion name is: " + name
                + "\nThe lion age is:  " + age
                + "\nThe lion weight: " + weight
                + "\nThe lion is" + (isFemale ? " a female\n\n" : " a male\n\n");
    }

    @Override
    public String makeNoise() {
        return "ROAR";
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
