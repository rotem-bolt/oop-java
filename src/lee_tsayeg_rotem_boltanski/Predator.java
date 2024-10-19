package lee_tsayeg_rotem_boltanski;

public abstract class Predator extends Animal {
    private final int MAX_AGE = 15;
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

    @Override
    public int getAnimalAge() {
        return this.age;
    }

    @Override
    public int getAnimalMaxAge() {
        return MAX_AGE;
    }

    public abstract String getAnimalDetails();

}