package lee_rotem;

public class Penguin {
    public String name;
    public int age;
    public double height;
    public boolean isLeader;
    private int foodAmount;

    public Penguin(String name, int age, double height, boolean isLeader) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.isLeader = isLeader;
        this.foodAmount = 1;
    }

    public String getPenguinDetails() {
        return "\nThe penguin name is: " + name
                + "\nThe penguin age is:  " + age
                + "\nThe penguin height: " + height
                + "\nThe penguin is" + (isLeader? " a leader\n\n" : " not a leader\n\n");
    }
}
