package lee_tsayeg_rotem_boltanski;

public abstract class Carnivores {
    protected enum types { LION, TIGER };
    protected String name;
    protected int age;
    protected double weight;
    protected boolean isFemale;
    protected double foodAmount = getFoodAmount();

    public Carnivores(String name, int age, double weight, boolean isFemale) {

    }

    public double feed() {
        return this.foodAmount;
    };

    public abstract String getCarnivorDetails();

    public abstract String makeNoise();

    public abstract double getFoodAmount();

}
