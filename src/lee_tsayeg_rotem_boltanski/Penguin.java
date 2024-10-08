package lee_tsayeg_rotem_boltanski;

public class Penguin extends Animal {
    private String name;
    private int age;
    private double height;
    public boolean isLeader;
    private double foodAmount;

    public Penguin(String name, int age, double height, boolean isLeader) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.isLeader = isLeader;
        this.foodAmount = 1;
    }

    @Override
    public String getAnimalDetails() {
        return "\nThe penguin name is: " + name
                + "\nThe penguin age is:  " + age
                + "\nThe penguin height: " + height
                + "\nThe penguin is" + (isLeader? " a leader\n\n" : " not a leader\n\n");
    }
    public double getPenguinHeight() {
        return this.height;
    }
    public boolean getPenguinIsLeader() {
        return this.isLeader;
    }
    public static boolean setPenguinName(String name) {
        return name.length() >= 2;
    }
    public boolean setPenguinAge(int age) {
        return age > 0;
    }
    public boolean setPenguinHeight(double height) {
        return (height > 0 && height < 200);
    }

    @Override
    public double feed() {
        return foodAmount;
    }
    @Override
    public String makeNoise() {
        return "squack";
    }
}
