package lee_rotem;

public class Penguin {
    private String name;
    private int age;
    private double height;
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
    public double getPenguinHeight() {
        return this.height;
    }
    public boolean getPenguinIsLeader() {
        return this.isLeader;
    }
    public boolean setPenguinName(String name) {
        return true;
    }
    public boolean setPenguinAge(int age) {
        return true;
    }
    public boolean setPenguinHeight(double height) {
        return true;
    }
    public boolean setIsPenguinLeader(boolean isLeader) {
        return true;
    }
}
