package lee_rotem;

import java.util.Random;

public class AquariumFish {
    public int age;
    public double length;
    public String[] colors;
    public String[] patterns;
    public double foodAmount;

    public AquariumFish(int age, double length, String[] patterns, String[] colors) {
        this.age = age;
        this.length = length;
        this.foodAmount = age >= 3 ? length + 3 : 3;
        this.colors = colors;
        this.patterns = patterns;
    }



    //public String getFishDetails() {
     //   return "\nThe fish age is:  " + age
      //          + "\nThe fish length: " + length
       //         + "\nThe fish pattern: " + pattern + "\n\n";
    //}
}
