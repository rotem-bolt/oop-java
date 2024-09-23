package lee_tsayeg_rotem_boltanski;

public abstract class Carnivores {
    protected enum types { LION, TIGER };
    protected String name;
    protected int age;
    protected double weight;
    protected boolean isFemale;
    protected double foodAmount;

    public Carnivores(String name, int age, double weight, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isFemale = isFemale;
        this.foodAmount = 0;
    }

    public double feed() {
        return this.foodAmount;
    };

    public abstract String getCarnivoreDetails();

    public abstract String makeNoise();

}
