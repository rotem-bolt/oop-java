package lee_rotem;

public class Lion {
    public String name;
    public int age;
    public double weight;
    public boolean isFemale;
    public int foodAmount;
//   ? add an id variable that counts the amount of lions ?

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
                + "\nThe lion is" + (isFemale? " a female\n\n" : " a male\n\n");
    }

}
