package lee_tsayeg_rotem_boltanski;

public abstract class Predator extends Animal {
    protected String name;
    protected int age;
    protected double weight;
    protected boolean isFemale;
    protected double foodAmount;

    public Predator(String name, int age, double weight, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isFemale = isFemale;
        this.foodAmount = 0;
    }

    public double feed() {
        return this.foodAmount;
    };

    public abstract String getPredatorsDetails();

}
